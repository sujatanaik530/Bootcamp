package org.sujata.myfirstpackage;

import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        System.out.println("Enter the temperature in degrees F: ");
        Scanner scanFTemp = new Scanner(System.in);
        double tempF = scanFTemp.nextDouble();
        double tempC = (double) (5.0/9.0) * (tempF-32.0);
        System.out.println(tempF + " degrees F = " + tempC + " degrees C.");
        scanFTemp.close();
    }
}
