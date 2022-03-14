package FileWriterDemo;

import java.io.FileWriter;

public class Runnable {
    public static void main(String[] args) {
        fnOne();
    }

    static void fnOne() {
        // character based

        try {
            FileWriter fw = new FileWriter("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\tmpfile.txt");
            fw.write(65); // ASCII for A
            fw.write('\n');
            fw.write('a');
            fw.write('\n');
            fw.write("I can also write a string.");
            fw.write('\n');
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
        }
    }
}
