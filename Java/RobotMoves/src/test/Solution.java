package test;

import java.util.*;

interface Sport{
    void calculateAvgAge(int[] age);
    void retirePlayer(int id);
}

/*
Write the implementation of the Cricket and Football classes
*/
class Cricket implements Sport {
    private int[] playerIDs;
    public Cricket() {
        this.playerIDs = new int[11];
        for(int i = 0; i < 11; i++) {
            playerIDs[i] = 1;
        }
        System.out.println("A new cricket team has been formed.");
    }
    public void calculateAvgAge(int[] age) {
        double sumAges = 0;
        for (int a: age) {
            sumAges += a;
        }
        System.out.format("The average age of the team is %.2f.", sumAges/age.length);
    }
    public void retirePlayer(int id) {
        if (playerIDs[id-1] == -1) {
            System.out.println("Player had already retired.");
        }
        else {
            playerIDs[id-1] = -1;
            System.out.println("Player with  id: " + id + " has retired.");
        }
    }
}

class Football implements Sport {
    int[] playerIDs;
    public Football() {
        this.playerIDs = new int[11];
        for(int i = 0; i < 11; i++) {
            playerIDs[i] = 1;
        }
        System.out.println("A new football team has been formed.");
    }
    public void calculateAvgAge(int[] age) {
        double sumAges = 0;
        for (int a: age) {
            sumAges += a;
        }
        System.out.format("The average age of the team is %.2f.", sumAges/age.length);
    }
    public void retirePlayer(int id) {
        if (playerIDs[id-1] == -1) {
            System.out.println("Player had already retired.");
        }
        else {
            playerIDs[id-1] = -1;
            System.out.println("Player with  id: " + id + " has retired.");
        }
    }
    public void playerTransfer(int fee, int id) {
        if (playerIDs[id-1] == 1) {
            System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee +".");
        }
        else {
            System.out.println("Player has already retired.");
        }
    }
}

