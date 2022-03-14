package FileReaderDemo;

import jdk.jfr.events.FileReadEvent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Runnable {
    public static void main(String[] args) {
        fnOne();
    }
    static void fnOne() {
        try {
            // Character based

            FileReader fr = new FileReader("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt");

            // read() - > reads ASCII code of single character, returning -1 at EOF
            // below commented block works too.
/*
            int readCharAsInt = fr.read();

            while (readCharAsInt != -1) {
                System.out.println((char)readCharAsInt);
                readCharAsInt = fr.read();
            }
            fr.close();

 */
            // below code...instructor's way
            int readCharAsInt;
            while ((readCharAsInt = fr.read()) != -1) {
                System.out.println((char)readCharAsInt);
            }
            fr.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File is missing");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
