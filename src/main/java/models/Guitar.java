package models;

import javax.persistence.*;

@Entity
@Table(name = "guitars")
public class Guitar {
    private int id;
    private String model;
    private String brand;
    private int age;

    public Guitar(){
    }
    public Guitar(String model, String brand, int age){
        this.model = model;
        this.brand = brand;
        this.age = age;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

