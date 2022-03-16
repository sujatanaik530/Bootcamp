package com.perscholas.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Department implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int did;
    private String dname;

    // Create a relationship between Department and Teacher
    // Hibernate style (old style)
    //@OneToMany(cascade = CascadeType.ALL)
    //private Set<Teacher> teachersList;

    // alternate
    // JPA style (new style)
    @OneToMany(targetEntity = Teacher.class, cascade = CascadeType.ALL)
    private Set teachersList;

    public Set<Teacher> getTeachersList(Set<Teacher> teacherList) {
        return teachersList;
    }

    public void setTeachersList(Set<Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public Department(int did, String dname) {
        super();
        this.did = did;
        this.dname = dname;
    }

    public Department()
    {

    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
