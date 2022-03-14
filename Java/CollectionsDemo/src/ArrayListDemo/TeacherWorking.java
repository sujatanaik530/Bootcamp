package ArrayListDemo;

import java.util.ArrayList;

// this class handles displaying data required

public class TeacherWorking {
    public void displayTeacherInfo() {
        TeacherController con = new TeacherController();
        ArrayList<Teacher> tData = con.pullTeacherInfo();
        for (Teacher t: tData) {
            System.out.println(t.getTname() + " " + t.getTage() + " " + t.getTid());
        }
    }}
