package com.test.hib.controller;

import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        findUser_Hql objHQL = new findUser_Hql();
        objHQL.findAllUsers();
        objHQL.getRecordbyId();
        objHQL.getMaxSalary();
        objHQL.getTotalRows();

        System.out.println("\nEnter user id: ");
        Scanner uIn = new Scanner(System.in);
        int userid = uIn.nextInt();
        objHQL.getAllUsers(userid);
    }
}
