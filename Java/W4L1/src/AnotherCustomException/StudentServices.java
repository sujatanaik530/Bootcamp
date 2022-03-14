package AnotherCustomException;

public class StudentServices {
    private String sName;
    private int sID;
    public StudentServices () {

    }
    public StudentServices (String sName, int sID) {
        this.sID = sID;
        this.sName = sName;
    }
    public String findByName(String sName) {
        if ("".equals(sName)) {
            try {
                throw new StudentModuleException("Name cannot be empty");
            }
            catch (StudentModuleException e) {
                System.out.println(e);
            }
            return "ABC";
        }
        else {
            String msg = "Student in database";
            return msg;
        }
    }

    public Integer findByID(Integer sID) {
        if (sID.equals(this.sID)) {
            System.out.println("Student ID " + sID + " found in database");
            return sID;
        }
        else {
            try {
                throw new StudentModuleException("Student ID " + sID + " not found in database");
            }
            catch (StudentModuleException e) {
                System.out.println(e);
            }
            return sID;
        }
    }

    public String getsName() {
        return sName;
    }

    public int getsID() {
        return sID;
    }
}
