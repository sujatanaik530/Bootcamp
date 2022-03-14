package com.College;

public interface College {
    // only public abstract methods
    // only public static final variables
    // can't be instantiated

    String COLLEGENAME = "TEKsystems";
    String ADDRESS = "258-66ST";

    // Don't confuse these with getter and setter methods. They are just some methods with some logic.
    void getCourseName();
    void getIAName();
    void getInstructorName();
    void getProgramDuration();

    // abstract method overloading
    void getStudentRollNumber(int rollnumber);
    void getStudentRollName(String stName);

    /*default void mymethod() {
        System.out.println("Hello");
    }*/
    // functional interface, lambda function
}
