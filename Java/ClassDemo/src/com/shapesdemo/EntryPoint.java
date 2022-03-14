package com.shapesdemo;

public class EntryPoint {
    public static void main(String[] args) {
        Circle c = new Circle(20);
        Rectangle r = new Rectangle(20, 30);

        System.out.println("\nArea of circle with radius 20 is " + c.getArea());
        System.out.println("Circumference of circle with radius 20 is " + c.getPerimeter());
        System.out.println("\nArea of 20 x 30 rectangle is " + r.getArea());
        System.out.println("Circumference of 20 x 30 rectangle is " + r.getPerimeter());

        r.setHeight(50);
        r.setWidth(10);
        System.out.println("\nArea of 50 x 10 rectangle is " + r.getArea());
        System.out.println("Circumference of 50 x 10 rectangle is " + r.getPerimeter());

        System.out.println();
        c.showMsg();
        r.showMsg();

        System.out.println("\nUsing enum");
        EmployeeTitle et = EmployeeTitle.CEO;
        switch (et) {
            case CEO: System.out.println("CEO"); break;
            case CHAIRMAN: System.out.println("Chairman"); break;
            case DIRECTOR: System.out.println("Director"); break;
            case MANAGER: System.out.println("Manager"); break;
            case SUPERVISOR: System.out.println("Supervisor"); break;
        }
    }
}
