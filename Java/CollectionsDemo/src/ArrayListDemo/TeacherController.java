package ArrayListDemo;

import java.util.ArrayList;

// controller classes contain business logic
// gets info from database, puts info into database

public class TeacherController {
    int[] tid = {101, 102, 103, 104, 105};
    String[] tname = {"Teacher abc", "Teacher xyz", "Teacher efg", "Teacher xyz", "Teacher MNO"};
    int[] tage = {30, 33, 45, 60, 35};

    public TeacherController() {
    }

    public ArrayList<Teacher> pullTeacherInfo() {
        ArrayList<Teacher> tList = new ArrayList<>();
        for (int i = 0; i < tid.length; i++) {
            Teacher tObj = new Teacher();
            tObj.setTid(tid[i]);
            tObj.setTname(tname[i]);
            tObj.setTage(tage[i]);
            tList.add(tObj);
        }
        return tList;
    }


}
