package com.perscholas.model;

public class App {
    public static void main(String[] args) {
        MyController c = new MyController();
        c.createManyToOne();
        c.insertRecords();
        c.showRecords();
    }
}
