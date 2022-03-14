package RM;

import java.util.Scanner;

/*
 * Create the class Robot. Do not use the public access modifier in your class declaration.
 */
class Robot {
    int currentX = 0;
    int currentY = 5;
    int previousX;
    int previousY;
    public Robot() {

    }
    public Robot(int x, int y) {
        this.previousX = this.currentX;
        this.previousY = this.currentY;
        this.currentX = x;
        this.currentY = y;
    }
    public void moveX(int dx) {
        this.previousX = this.currentX;
        this.previousY = this.currentY;
        this.currentX += dx;
    }
    public void moveY(int dy) {
        this.previousX = this.currentX;
        this.previousY = this.currentY;
        this.currentY += dy;
    }
    public void printCurrentCoordinates() {
        System.out.println(this.currentX + " " + this.currentY);
    }
    public void printLastCoordinates() {
        System.out.println(this.previousX + " " + this.previousY);
    }
    public void printLastMove() {
        if (this.currentX != this.previousX) {
            System.out.println("x " + (Math.abs(this.currentX - this.previousX)));
        }
        if (this.currentY != this.previousY) {
            System.out.println("y " + (Math.abs(this.currentY - this.previousY)));
        }
    }
}

public class RobotMoves {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        int dx = scan.nextInt();
        int dy = scan.nextInt();

        Robot firstRobot = new Robot();
        firstRobot.printCurrentCoordinates();

        Robot secondRobot = new Robot(x, y);
        secondRobot.printCurrentCoordinates();

        for (int i = 1; i < 3; i++) {
            secondRobot.moveX(dx);
            secondRobot.printLastMove();
            secondRobot.printCurrentCoordinates();
            secondRobot.moveY(dy);
            secondRobot.printLastCoordinates();

            dx += i * i;
            dy -= i * i;
        }
    }
}