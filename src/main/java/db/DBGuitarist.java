package db;

import models.Guitarist;
import models.Guitar;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGuitarist {

    private static Session session;
    private static Transaction transaction;

    public static void save(Guitarist guitarist){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(guitarist);
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
        List<Guitarist> results = null;
        try {
            Criteria criteria = session.createCriteria(Guitarist.class);
            results = criteria.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Guitarist find(int id){
        Guitarist result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Guitarist.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Guitarist) criteria.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void delete(Guitarist guitarist) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(guitarist);
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
            Criteria criteria = session.createCriteria(Guitarist.class);
            List<Guitarist> results = criteria.list();
            transaction = session.beginTransaction();
            for (Guitarist guitarist : results){
                session.delete(guitarist);
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