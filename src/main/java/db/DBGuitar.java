package db;

import models.Guitarist;
import models.Guitar;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGuitar {

    private static Session session;
    private static Transaction transaction;

    public static void save(Guitar guitar){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(guitar);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Guitarist> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitar> results = null;
        try {
            Criteria criteria = session.createCriteria(Guitar.class);
            results = criteria.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Guitar find(int id){
        Guitar result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Guitarist.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Guitar) criteria.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void delete(Guitar guitar) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(guitar);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Guitar.class);
            List<Guitarist> results = criteria.list();
            transaction = session.beginTransaction();
            for (Guitar guitar : results){
                session.delete(guitar);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}