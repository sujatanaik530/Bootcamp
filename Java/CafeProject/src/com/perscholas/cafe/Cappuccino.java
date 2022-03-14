package com.perscholas.cafe;

public class Cappuccino extends Product {
    private boolean whippedCream;
    private boolean peppermint;

    public Cappuccino() {
        super();
    }

    public Cappuccino(String name, double price, String description, boolean whippedCream, boolean peppermint) {
        super(name, price, description);
        this.whippedCream = whippedCream;
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    @Override
    public double calculateProductTotal() {
        double productTotal = this.getPrice() * this.getQuantity();
        if (isPeppermint()) {
            productTotal += 2;
        }
        if (isWhippedCream()) {
            productTotal += 1;
        }
        return productTotal;
    }
}
