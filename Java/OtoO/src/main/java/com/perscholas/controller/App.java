package com.perscholas.controller;

public class App {
    public static void main(String[] args) {
        AddressController ac = new AddressController();
        ac.createTables();
        ac.insertRows();
        //ac.insertUserInputRows();
        ac.getPersonInfo();
    }
}
