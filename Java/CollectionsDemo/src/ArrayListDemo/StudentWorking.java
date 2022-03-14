package ArrayListDemo;

import java.util.ArrayList;

// this class handles displaying data required

public class StudentWorking {
    public void displayStudentInfo() {
        StudentController con = new StudentController();
        ArrayList<StudentService> sData = con.pullStudentInfo();
        for (StudentService ss: sData) {
            System.out.println(ss.getsName() + " " + ss.getsRNum());
        }
    }
    public void displayStudentInfoFromFile() {
        StudentController con = new StudentController();
        ArrayList<StudentService> sData = con.readStudentDataFromFile();
        for (StudentService ss: sData) {
            System.out.println(ss.getsRNum() + " " + ss.getsName());
        }
    }
}
