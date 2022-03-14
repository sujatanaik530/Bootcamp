package com.UseInterfaces;

public class WaterBottle implements WaterBottleInterface{
    @Override
    public void fillBottle() {
        System.out.println("Bottle is now full.");
    }

    @Override
    public void emptyBottle() {
        System.out.println("Bottle is now empty.");
    }

    public static void main(String[] args) {
        System.out.println(color);

        // can't have below line - cannot assign value to final variable color
        // interface variables are final
        // color = "Blue";

        WaterBottle myWB = new WaterBottle();
        myWB.fillBottle();
        myWB.emptyBottle();
    }
}
