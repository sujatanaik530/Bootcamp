package CarsCSV;

import java.util.ArrayList;

public class CarsWorking {
    public void displayCars() {
        CarsController cc = new CarsController();
        ArrayList<Cars> carsList = cc.readFromCSV();
        System.out.println();
        for (Cars c: carsList) {
            System.out.format("%-36s\t%.2f\t%d\t%.2f\t%.2f\t%.2f\t%.2f\t%d\t%s\n",
                    c.getcName(),
                    c.getcMPG(),
                    c.getcCylinders(),
                    c.getcDisplacement(),
                    c.getcHorsepower(),
                    c.getcWeight(),
                    c.getcAcceleration(),
                    c.getcModel(),
                    c.getcOrigin());
        }
    }
}
