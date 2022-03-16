package com.perscholas.model;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int personID;
    private String name;
    private String email;
    private int age;
    private String hobbies;

    // declare Address class for relationship
    @OneToOne(cascade = CascadeType.ALL)
    private Address myaddress;

    public Person() {
    }

    public Person(int personID, String name, String email, int age, String hobbies, Address address) {
        this.personID = personID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hobbies = hobbies;
        this.myaddress = address;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Address getMyaddress() {
        return myaddress;
    }

    public void setMyaddress(Address myaddress) {
        this.myaddress = myaddress;
    }
}
