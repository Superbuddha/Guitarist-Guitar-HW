package models;

import javax.persistence.*;

@Entity
@Table(name = "guitarists")
public class Guitarist {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String style;

    public Guitarist(){
}
public Guitarist(String firstName, String lastName, int age, String style){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.style = style;
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

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "style")
public String getStyle(){return style; }
public void setStyle(String style){ this.style = style; }}

