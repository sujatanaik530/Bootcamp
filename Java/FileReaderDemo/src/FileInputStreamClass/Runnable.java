package FileInputStreamClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Runnable {
    public static void main(String[] args) {
        fnOne();
    }
    static void fnOne() {
        try {
            // Byte based

            FileInputStream fin = new FileInputStream("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt");
            int i;
            while ((i = fin.read()) != -1) {
                System.out.println((char)i);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File is missing");
        }
        catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
