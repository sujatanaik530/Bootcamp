package GenericsDemo;

public class StudentService {
    private String sName;
    private int sRNum;

    StudentService() {

    }
    StudentService(String sName, int sRNum) {
        this.sName = sName;
        this.sRNum = sRNum;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsRNum(int sRNum) {
        this.sRNum = sRNum;
    }
}
