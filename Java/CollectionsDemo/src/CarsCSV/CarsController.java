package CarsCSV;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarsController {
    public CarsController() {
    }

    public ArrayList<Cars> readFromCSV() {
        String fName = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\cars.csv";
        File f = new File(fName);
        ArrayList<Cars> carsList = new ArrayList<>();
        try {
            if (f.exists()) {
                Scanner fs = new Scanner(f);
                String[] splitData = null;
                String columnNames = fs.nextLine();
                while (fs.hasNext()) {
                    String data = fs.nextLine();
                    splitData = data.split(",");
                    //System.out.println(Arrays.toString(splitData));
                    Cars c = new Cars();
                    c.setcName(splitData[0]);
                    c.setcMPG(Double.parseDouble(splitData[1]));
                    c.setcCylinders(Byte.parseByte(splitData[2]));
                    c.setcDisplacement(Double.parseDouble(splitData[3]));
                    c.setcHorsepower(Double.parseDouble(splitData[4]));
                    c.setcWeight(Double.parseDouble(splitData[5]));
                    c.setcAcceleration(Double.parseDouble(splitData[6]));
                    c.setcModel(Byte.parseByte(splitData[7]));
                    c.setcOrigin(splitData[8]);
                    carsList.add(c);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Something wrong!");
            e.printStackTrace();
        }
        finally {
            return carsList;
        }
    }
}
