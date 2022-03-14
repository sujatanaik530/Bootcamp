package AnotherCustomException;

public class Runnable {
    public static void main(String[] args) {
        StudentServices ss = new StudentServices("Sujata", 7);
        System.out.println(ss.getsID() + " " + ss.getsName());
        ss.findByName("Sujata");
        ss.findByName("");
        Integer result = ss.findByID(7);
        result = ss.findByID(8);
    }
}
