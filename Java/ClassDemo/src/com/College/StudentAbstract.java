package com.College;

public abstract class StudentAbstract {
    // variables are not public, static, final by default
    // they have 'default' as access modifier

    protected String sFirstName;
    protected String sLastName;
    protected float sGPA;
    protected int sRollNumber;

    // cannot be instantiated, but has (a) constructor(s)

    public StudentAbstract() {
    }

    public StudentAbstract(String sFirstName, String sLastName, float sGPA, int sRollNumber) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        this.sGPA = sGPA;
        this.sRollNumber = sRollNumber;
    }

    // may contain both abstract and concrete methods

    // abstract methods
    protected abstract void displayInformation();
    protected abstract String getStudentAddress();
    protected abstract String[] getStudentFullName();
    protected abstract void getStudentFullName(String[] courseDetails);

    // non-abstract methods (concrete methods)

    public String getsFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public float getsGPA() {
        return sGPA;
    }

    public void setsGPA(float sGPA) {
        this.sGPA = sGPA;
    }

    public int getsRollNumber() {
        return sRollNumber;
    }

    public void setsRollNumber(int sRollNumber) {
        this.sRollNumber = sRollNumber;
    }
}
