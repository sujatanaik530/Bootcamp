package com.teksystems;

import java.util.Arrays;

public class EntryPoint {
    public static void main(String[] args) {
        Shape spObj1 = new Shape();
        Shape spObj2 = new Shape(2.5, 52.3);
        Shape spObj3 = new Shape(3.5);

        spObj1.printMessage();
        System.out.println(spObj2.returnMessage());

        spObj1.setWidth(256.45);
        System.out.println(spObj1.getWidth());

        spObj2.setWidth(99.99);
        System.out.println(spObj2.getWidth());

        spObj1.setHeight(7.0);
        spObj1.setWidth(10.0);
        System.out.println("Height = " + spObj1.getHeight());
        System.out.println("Width = " + spObj1.getWidth());
        System.out.println("Perimeter = " + spObj1.getPerimeter());
        System.out.println("Area = " + spObj1.getArea());

        System.out.println("\nMethod overloading");
        MethodOverload mo1 = new MethodOverload();
        mo1.addingnumber(25, 25);
        System.out.println("Sum is " + mo1.getResult());

        System.out.println("\nArray is");
        int[] x = {5, 6, 93, 5, 87, 4};
        System.out.println(Arrays.toString(x));
        mo1.addingnumber(x);

        mo1.addingnumber("Hello! ", x);

        System.out.println("\nStatic variables");
        System.out.println(StaticDemo.var1);
        StaticDemo.var1 = 30;
        StaticDemo.var1 = 40;
        StaticDemo.var1 = 50;
        StaticDemo.var1 = 60;
        StaticDemo.var1 = 70;
        System.out.println("Changed the value to 70");
        System.out.println(StaticDemo.var1);

        StaticDemo sd1 = new StaticDemo();
        StaticDemo sd2 = new StaticDemo();
        StaticDemo sd3 = new StaticDemo();
        StaticDemo sd4 = new StaticDemo();
        StaticDemo sd5 = new StaticDemo();

        sd1.var1 = 100;
        sd2.var1 = 200;
        sd3.var1 = 300;
        sd4.var1 = 400;
        sd5.var1 = 500;
        // var1 is a static variable and is shared between all 5 objects.
        // Its value just changes from 100 to 200 to 300 to 400 to 500.

        sd1.var2 = 10;
        sd2.var2 = 20;
        sd3.var2 = 30;
        sd4.var2 = 40;
        sd5.var2 = 50;
        // var2 is not a static variable and is not shared between all 5 objects.
        // Each object has its own value for var2.

        // The below statements will all print 500, since var1 is static.
        System.out.println("Printing static variable");
        System.out.println(sd1.var1);
        System.out.println(sd2.var1);
        System.out.println(sd3.var1);
        System.out.println(sd4.var1);
        System.out.println(sd5.var1);

        System.out.println("Printing non-static variable");
        System.out.println(sd1.var2);
        System.out.println(sd2.var2);
        System.out.println(sd3.var2);
        System.out.println(sd4.var2);
        System.out.println(sd5.var2);

        System.out.println("\nCircle is a Shape");
        Circle c = new Circle(5.0);
        System.out.println(c.getArea());

        System.out.println("\nRectangle is a Shape");
        Rectangle r = new Rectangle();
        System.out.println(r.getArea());

        System.out.println("\nCreating a new circle with r = 10");
        Circle c1 = new Circle(10);
        System.out.println("Area = " + c1.getArea());

        System.out.println("\nSetting width to 10, height to 20");
        c1.setWidth(10);
        c1.setHeight(20);
        System.out.println("Perimeter = " + c1.getPerimeter());

        Cylinder cy = new Cylinder();
        System.out.println("\nCylinder");
        System.out.println(cy.getPerimeter());
        System.out.println("Setting width and height to 20");
        cy.setWidth(20);
        cy.setHeight(20);
        System.out.println("Perimeter = " + cy.getPerimeter());

        Triangle t = new Triangle();
    }
}
