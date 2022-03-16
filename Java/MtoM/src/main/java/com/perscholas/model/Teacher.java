package com.perscholas.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int tID;
    private String tName;
    private int tSalary;

    @ManyToMany (targetEntity = Cohort.class)
    private Set cohortSet;

    public Teacher() {
    }

    public Teacher(String tName, int tSalary, Set cohortSet) {
        this.tName = tName;
        this.tSalary = tSalary;
        this.cohortSet = cohortSet;
    }

    public Set getCohortSet() {
        return cohortSet;
    }

    public void setCohortSet(Set cohortSet) {
        this.cohortSet = cohortSet;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int gettSalary() {
        return tSalary;
    }

    public void settSalary(int tSalary) {
        this.tSalary = tSalary;
    }
}
