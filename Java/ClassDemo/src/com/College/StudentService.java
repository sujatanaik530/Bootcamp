package com.College;

public class StudentService extends StudentAbstract implements College {
    public StudentService() {

    }
    // implementing the interface methods
    @Override
    public void getCourseName() {

    }

    @Override
    public void getIAName() {

    }

    @Override
    public void getInstructorName() {

    }

    @Override
    public void getProgramDuration() {

    }

    @Override
    public void getStudentRollName(String stName) {

    }

    @Override
    public void getStudentRollNumber(int rollnumber) {

    }

    // now, the student abstract class methods
    public void displayInformation() {
        System.out.println("Hi! My name is " + super.sFirstName + " " + super.sLastName + ".");
        System.out.println("My roll number is " + super.sRollNumber + ".");
        System.out.println("My GPA is " + super.sGPA + ".");
    }

    public String getStudentAddress() {
        return "";
    }

    @Override
    protected String[] getStudentFullName() {
        return new String[0];
    }

    @Override
    protected void getStudentFullName(String[] courseDetails) {

    }

}
