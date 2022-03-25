package com.example;

import java.util.Collection;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        // print the column names
        System.out.println("Cart:");
        System.out.format("%-20s %-20s %-10s %-10s %-10s%n",
                "Name",
                "Description",
                "Price",
                "Quantity",
                "Sub Total");

        // print details of each item
        double preTaxTotal = 0;
        Collection<Item> items = getItemCollection().values();
        for (Item i: items) {
            double subTotal = i.getItemPrice() * i.getQuantity();
            System.out.format("%-20s %-20s %-10.2f %-10d %-10.2f%n",
                    i.getItemName(),
                    i.getItemDesc(),
                    i.getItemPrice(),
                    i.getQuantity(),
                    subTotal);
            preTaxTotal += subTotal;
        }
        double tax = preTaxTotal * 0.05;
        double total = preTaxTotal + tax;
        System.out.format("%-20s %-20.2f%n", "Pre-tax Total", preTaxTotal);
        System.out.format("%-20s %-20.2f%n", "Tax", tax);
        System.out.format("%-20s %-20.2f%n", "Total", total);
    }
}
