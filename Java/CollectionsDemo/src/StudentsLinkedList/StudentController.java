package StudentsLinkedList;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

// controller classes contain business logic
// gets info from database, puts info into database

public class StudentController {
    int[] id = {101, 102, 103, 104, 105};
    String[] name = {"abc", "xyz", "efg", "xyz", "MNO"};

    public StudentController() {
    }

    public LinkedList<StudentService> pullStudentInfo() {
        LinkedList<StudentService> stList = new LinkedList<>();
        for (int i = 0; i < id.length; i++) {
            StudentService stObj = new StudentService();
            stObj.setsRNum(id[i]);
            stObj.setsName(name[i]);
            stList.add(stObj);
        }
        return stList;
    }

    public LinkedList<StudentService> readStudentDataFromFile() {
        String fName = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\studentdata.txt";
        File f = new File(fName);
        LinkedList<StudentService> sList = new LinkedList<>();
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
