package com.perscholas.cafe;

public class Coffee extends Product {
    private boolean sugar;
    private boolean milk;

    public Coffee() {
        super();
        this.milk = false;
        this.sugar = false;
    }

    public Coffee(String name, double price, String description, boolean sugar, boolean milk) {
        super(name, price, description);
        this.sugar = sugar;
        this.milk = milk;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    @Override
    public double calculateProductTotal() {
        return this.getPrice() * this.getQuantity();
    }
}
