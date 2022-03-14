package FileDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;

public class Runnable {
    public static void main(String[] args) {
       //fnOne();
        fnTwo();
/*         fnThree();
        try {
            fnFour();
        }
        catch (Exception e) {

        }
        try {
            fnFive();
        }
        catch (Exception e) {

        }*/
        /*try {
            fnSix();
        }
        catch (Exception e) {

        }*/
        /*try {
            fnSeven();
        }
        catch (Exception e) {

        }*/
    }

    static void fnOne() {
        System.out.println("\n-------------Custom exception when directory is not found------------");
        String path = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing123";
        File dir = new File(path);
        try {
            if (!dir.isDirectory()) {
                throw new MyFileExceptions("Directory not found");
            }
            else {
                System.out.println("The directory " + path + " exists");
            }
        }
        catch (MyFileExceptions e) {
            System.out.println("Directory not found");
        }
    }

    static void fnTwo() {
        System.out.println("\n-------------File methods------------");
        String path = "C:\\Users\\naiks\\Documents\\Bootcamp";
        File dir = new File(path);
        String[] listFiles = dir.list();

        /*String[] listFiles = dir.list((d,s) -> {
            return s.toLowerCase(Locale.ROOT).endsWith(".txt");
        });*/

        System.out.println(Arrays.toString(listFiles));

        File[] fileWithPath = dir.listFiles();
        System.out.println(Arrays.toString(fileWithPath));

        String path2 = "C:\\Users\\naiks\\Documents\\Bootcamp\\textone.txt";
        File dir2 = new File(path2);
        System.out.println("Absolute path? " + dir2.isAbsolute());
        System.out.println("Absolute path: " + dir2.getAbsolutePath());
        System.out.println("Parent path: " + dir2.getParent());
        System.out.println("Exists? " + dir2.exists());
        if (dir2.exists()) {
            System.out.println("File found");
            System.out.println("Readable? " + dir2.canRead());
            System.out.println("Writeable? " + dir2.canWrite());
            System.out.println("Executable? " + dir2.canExecute());
        }
        System.out.println("File length in bytes = " + dir2.length());
        //boolean renamed = dir2.renameTo(new File("C:\\Users\\naiks\\Documents\\Bootcamp\\texttwo.txt"));
    }
    static void fnThree() {
        System.out.println("\n-------------File folder methods...more------------");
        String folderPath = "C:\\Users\\naiks\\Documents\\Bootcamp\\testingone";
        File f = new File(folderPath);
        if (f.isDirectory()) {
            System.out.println("Directory already exists");
        }
        else {
            if (f.mkdirs()) {
                System.out.println("Directory created");
            }
            else {
                System.out.println("Directory could not be created");
            }
        }
    }

    static void fnFour() throws IOException {
        System.out.println("\n-------------Reading a file------------");
        File f = new File("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file1.txt");
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        }
        else {
            System.out.println("File was not found. It will be created.");
            if (f.createNewFile()) {
                System.out.println(f.getName() + " created.");
            }
            else {
                System.out.println("File creation failed.");
            }
        }
    }

    static void fnFive() throws FileNotFoundException {
        System.out.println("\n-------------Reading multiple files------------");

        String path = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing";

        File dir = new File(path);
        File[] listOfFiles = dir.listFiles();

        for (File eachFile: listOfFiles) {
            System.out.println("\nReading " + eachFile.getName());
            Scanner sc = new Scanner(eachFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
    }

    static void fnSix() throws IOException{
        System.out.println("\n-------------Reading cars.csv------------\n");

        String filepath = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\cars.csv";

        File csvFile = new File(filepath);

        if (csvFile.exists()) {
            Scanner sc = new Scanner(csvFile);
            String line = sc.nextLine();
            String[] lineFields = line.split(",");
            System.out.format("%20s\t%5s\t%2s\t%5s\t%5s\t%5s\t%5s\t%5s\t%5s\n", lineFields[0], lineFields[1], lineFields[2], lineFields[3], lineFields[4], lineFields[5], lineFields[6], lineFields[7], lineFields[8]);
            // not done with formatting yet
            //System.out.println(Arrays.toString(lineFields));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                lineFields = line.split(",");
                System.out.println(Arrays.toString(lineFields));
            }
            sc.close();
        }
    }

    static void fnSeven() throws IOException {
        String fname = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\newlycreated.txt";
        File newFile = new File(fname);
        FileWriter mywriter;
        LocalDateTime ldt = LocalDateTime.now();
        if (newFile.createNewFile()) { // file does not exist and is created
            mywriter = new FileWriter(fname, false);
            mywriter.write("Newly created at " + ldt.toString() + "\n");
        }
        else { // file exists
            mywriter = new FileWriter(fname, true);
            mywriter.write("Updated at " + ldt.toString() + "\n");
        }
        mywriter.close();
    }
}
