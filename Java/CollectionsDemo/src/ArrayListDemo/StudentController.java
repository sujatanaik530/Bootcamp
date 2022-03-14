package ArrayListDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// controller classes contain business logic
// gets info from database, puts info into database

public class StudentController {
    int[] id = {101, 102, 103, 104, 105};
    String[] name = {"abc", "xyz", "efg", "xyz", "MNO"};

    public StudentController() {
    }

    public ArrayList<StudentService> pullStudentInfo() {
        ArrayList<StudentService> stList = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            StudentService stObj = new StudentService();
            stObj.setsRNum(id[i]);
            stObj.setsName(name[i]);
            stList.add(stObj);
        }
        return stList;
    }

    public ArrayList<StudentService> readStudentDataFromFile() {
        String fName = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\studentdata.txt";
        File f = new File(fName);
        ArrayList<StudentService> sList = new ArrayList<>();
        try {
            if (f.exists()) {
                Scanner fs = new Scanner(f);

                String[] splitData = null;
                while (fs.hasNext()) {
                    String data = fs.nextLine();
                    splitData = data.split(",");
                    StudentService sObj = new StudentService();
                    sObj.setsRNum(Integer.parseInt(splitData[0]));
                    sObj.setsName(splitData[1]);
                    sList.add(sObj);
                }
            }
        }
        catch (Exception e) {

        }
        finally {
            return sList;
        }
    }
}
