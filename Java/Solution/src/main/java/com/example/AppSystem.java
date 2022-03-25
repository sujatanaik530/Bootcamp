package com.example;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        // print the column names
        System.out.println("AppSystem Inventory:");
        System.out.format("%-20s %-20s %-10s %10s%n",
                "Name",
                "Description",
                "Price",
                "Available Quantity");


        // print details of each item
        for (Item i: getItemCollection().values()) {
            System.out.format("%-20s %-20s %-10.2f %-10d%n",
                    i.getItemName(),
                    i.getItemDesc(),
                    i.getItemPrice(),
                    i.getAvailableQuantity());
        }
    }

    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }
        else {
            // item is already in the system, can not add it
            if (getItemCollection().containsValue(item)) {
                System.out.println(item.getItemName()
                        + " is already in the App System");
                return false;
            }
            // item is not in the system, add it
            else {
                getItemCollection().put(item.getItemName(), item);
                return true;
            }
        }
    }

    public Item reduceAvailableQuantity(String item_name) {
        // item is in collection, decrement available quantity by 1
        if (getItemCollection().containsKey(item_name)) {
            Item updatedItem = getItemCollection().get(item_name);
            updatedItem.setAvailableQuantity(updatedItem.getAvailableQuantity() - 1);
            if (updatedItem.getAvailableQuantity() == 0) {
                getItemCollection().remove(item_name);
                return null;
            }
            else {
                getItemCollection().replace(item_name, updatedItem);
                // return updatedItem or replaced item?
                return updatedItem;
            }
        }
        // item is not in collection, return null
        else {
            return null;
        }
    }
}
