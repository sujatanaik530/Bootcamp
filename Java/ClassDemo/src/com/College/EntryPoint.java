package com.College;

public class EntryPoint {
    public static void main(String[] args) {
        StudentService s = new StudentService();
        s.setsFirstName("Sujata");
        s.setsLastName("Naik");
        s.setsGPA(4.0f);
        s.setsRollNumber(7);
        s.displayInformation();
    }
}
