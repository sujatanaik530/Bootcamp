package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
    protected HashMap<String, Item> itemCollection;

    TheSystem() {
        this.itemCollection = new HashMap<>();
        FileReader sampleFile = null;
        Scanner scanSampleFile = null;
        if (getClass().getSimpleName().equals("AppSystem")) {
            try {

                sampleFile = new FileReader("./resources/sample.txt");
                scanSampleFile = new Scanner(sampleFile);
                while (scanSampleFile.hasNextLine()) {
                    String lineSample = scanSampleFile.nextLine();
                    String[] itemDetails = lineSample.split("  ");
                    String iName = itemDetails[0];
                    String iDesc = itemDetails[1];
                    Double iPrice = Double.parseDouble(itemDetails[2]);
                    Integer iQuantityAvailable = Integer.parseInt(itemDetails[3]);
                    Item newItem = new Item(iName, iDesc, iPrice, iQuantityAvailable);
                    itemCollection.put(iName, newItem);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Error loading items from samples.txt");
            }
            finally {
                if (scanSampleFile != null) {
                    scanSampleFile.close();
                }
                if (sampleFile != null) {
                    try {
                        sampleFile.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }

    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() > item.getAvailableQuantity()) {
            System.out.println("System is unable to add "
                    + item.getItemName()
                    + " to the cart. System only has "
                    + item.getAvailableQuantity()
                    + " "
                    + item.getItemName()
                    + "s");
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }
        else {
            // item already in collection, increment quantity by 1
            if (getItemCollection().containsValue(item)) {
                Item updatedItem = getItemCollection().get(item.getItemName());
                updatedItem.setQuantity(updatedItem.getQuantity() + 1);
                getItemCollection().replace(item.getItemName(), updatedItem);
                return true;
            }
            // item not in collection, add it
            else {
                item.setQuantity(1);
                getItemCollection().put(item.getItemName(), item);
                return true;
            }
        }
    }

    public Item remove(String itemName) {
        // item is present, remove it
        if (getItemCollection().containsKey(itemName)) {
            return getItemCollection().remove(itemName);
        }
        // item not present
        else {
            return null;
        }
    }

    public abstract void display();
}
