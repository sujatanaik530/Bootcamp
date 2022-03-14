package Test;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Runnable {
    public static void main(String[] args) {
        //fnOne()
        //fnTwo();
        fnThree();
    }
    static void fnOne() {
        try {
            // writing a string as bytes
            FileOutputStream fout = new FileOutputStream("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\tmpfile.txt");
            //int toWrite = 2_147_483_645;
            //fout.write(toWrite);

            byte[] toWrite = {2, 6, 3, 65}; // 263A smiley face emoji
            fout.write(toWrite);
            fout.close();
            System.out.println("Written"); // Notepad cant display it
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    static void fnTwo() {
        try {
            // writing a string as bytes
            FileWriter fout = new FileWriter("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\tmpfile.txt");
            //int toWrite = 2_147_483_645;
            //fout.write(toWrite);

            //byte[] toWrite = {2, 6, 3, 65}; // 263A smiley face emoji
            //fout.write(toWrite);
            fout.write(0x263A); // 263A smiley face emoji
            fout.close();
            System.out.println("Written"); // Notepad cant display it
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    static void fnThree() {
        System.out.format("%10.2f%n", 23.45);
        System.out.format("%-10.2f%n", 23.45);
    }
}
