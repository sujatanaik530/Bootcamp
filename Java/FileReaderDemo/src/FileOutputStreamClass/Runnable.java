package FileOutputStreamClass;

import java.io.FileOutputStream;

public class Runnable {
    public static void main(String[] args) {
        try {
            // writing a string as bytes
            FileOutputStream fout = new FileOutputStream("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\tmpfile.txt");
            String s="Welcome to Java.";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
