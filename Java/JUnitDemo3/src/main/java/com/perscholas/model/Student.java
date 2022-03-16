package com.perscholas.model;

public class Student {
    private int sID;
    private String sEmail;
    private String sFName;
    private String sLName;

    public Student() {
    }

    public Student(int sID, String sEmail, String sFName, String sLName) {
        this.sID = sID;
        this.sEmail = sEmail;
        this.sFName = sFName;
        this.sLName = sLName;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsFName() {
        return sFName;
    }

    public void setsFName(String sFName) {
        this.sFName = sFName;
    }

    public String getsLName() {
        return sLName;
    }

    public void setsLName(String sLName) {
        this.sLName = sLName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            boolean sameId = (this.sID == other.getsID());
            boolean sameEmail = (this.sEmail.equals(other.getsEmail()));
            boolean sameFName = (this.sFName.equals(other.getsFName()));
            boolean sameLName = (this.sLName.equals(other.getsLName()));
            if (sameId && sameEmail && sameFName && sameLName) {
                return true;
            }
        }
        return false;
    }
}
