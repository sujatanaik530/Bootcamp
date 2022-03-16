package com.perscholas.model;

import javax.persistence.*;

@Entity
@Table
public class Cohort {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int cID;
    private String cName;
    private String cDuration;

    public Cohort() {
    }

    public Cohort(String cName, String cDuration) {
        this.cName = cName;
        this.cDuration = cDuration;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDuration() {
        return cDuration;
    }

    public void setcDuration(String cDuration) {
        this.cDuration = cDuration;
    }
}
