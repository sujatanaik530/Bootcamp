package ReadWithScanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        fnOne();
    }
    static void fnOne() {
        Scanner s = null;
        //File fIn = new File("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt");
        File fIn = new File(".\\src\\ReadWithScanner\\sample.txt");
        System.out.println(System.getProperty("user.dir"));
        BufferedReader br;
        FileReader fr;
        try {
            fr = new FileReader(fIn);
            br = new BufferedReader(fr);
            s = new Scanner(br);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parts = line.split("\\s ");
                System.out.println(parts[0] + "* " + parts[1] + "* " + parts[2] + "* " + parts[3]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
