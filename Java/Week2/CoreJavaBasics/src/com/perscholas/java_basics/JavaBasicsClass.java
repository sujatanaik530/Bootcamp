package com.perscholas.java_basics;

public class JavaBasicsClass {
    public static void main(String[] args) {
        System.out.println("----------Core Java - Exercises - Variables----------");

        // Write a program that declares 2 integer variables, assigns an integer to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        System.out.println("\n-----Ex. 1-----");
        int ia = 5;
        int ib = 7;
        int ic = ia + ib;
        System.out.println("ia = " + ia);
        System.out.println("ib = " + ib);
        System.out.println("ic = " + ic);

        // Write a program that declares 2 double variables, assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        System.out.println("\n-----Ex. 2-----");
        double da = 2.3;
        double db = 5.7;
        double dc = da + db;
        System.out.println("da = " + da);
        System.out.println("db = " + db);
        System.out.println("dc = " + dc);

        // Write a program that declares an integer variable and a double variable, assigns numbers to each,
        // and adds them together. Assign the sum to a variable. Print out the result. What variable type must
        // the sum be?
        System.out.println("\n-----Ex. 3-----");
        int id = 7;
        double dd = 10.7;
        double de = id + dd;
        //int ie = id + dd;   // incompatible types: possible lossy conversion from double to int
        System.out.println("id = " + id);
        System.out.println("dd = " + dd);
        System.out.println("de = " + de);
        //System.out.println("ie = " + ie);

        // Write a program that declares 2 integer variables, assigns an integer to each, and divides the larger
        // number by the smaller number. Assign the result to a variable. Print out the result. Now change the
        // larger number to a decimal. What happens? What corrections are needed?
        System.out.println("\n-----Ex. 4-----");
        int ig = 89;            // Changing this to a decimal number gives an error:
                                // incompatible types: possible lossy conversion from double to int
                                // We can change the data type to double.
        int ih = 7;
        double df = ig / ih;    // This gives the quotient part. (integer division)
        System.out.println("ig = " + ig);
        System.out.println("ih = " + ih);
        System.out.println("df = " + df);

        double dg = 89.7;
        df = dg / ih;
        System.out.println("Changed the larger number to double holding a decimal.");
        System.out.println("dg = " + dg);
        System.out.println("ih = " + ih);
        System.out.println("df = " + df);

        // Write a program that declares 2 double variables, assigns a number to each, and divides the larger by
        // the smaller. Assign the result to a variable. Print out the result. Now, cast the result to an integer.
        // Print out the result again.
        System.out.println("\n-----Ex. 5-----");
        double dh = 9.8;
        double di = 34.7;
        double dj = di / dh;
        System.out.println("dh = " + dh);
        System.out.println("di = " + di);
        System.out.println("dj = " + dj);
        System.out.println("Casting di / dh to int ii");
        int ii = (int)(di / dh);
        System.out.println("ii = " + ii);

        // Write a program that declares 2 integer variables, x, and y, and assign 5 to x and 6 to y. Declare a
        // variable q and assign y/x to it and print q. Now, cast y to a double and assign to q. Print q again.
        System.out.println("\n-----Ex. 6-----");
        int x = 5;
        int y = 6;
        int q = y / x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("q = " + q);
        System.out.println("Casting y to double and assigning it to q");
        System.out.println("Error: incompatible types: possible lossy conversion from double to int");
        //q = (double)y;    // incompatible types: possible lossy conversion from double to int
        //System.out.println("q = " + q);

        // Write a program that declares a named constant and uses it in a calculation. Print the result.
        System.out.println("\n-----Ex. 7-----");
        System.out.println("Creating and using a named constant");
        final double PI = 3.14; // named constant PI
        double radius = 3.0;
        double circumference = 2 * PI * radius;
        System.out.println("A circle with radius " + radius + " units has circumference " + circumference + " units.");

        // Write a program where you create 3 variables that represent products at a cafe. The products could be
        // beverages like coffee, cappuccino, espresso, green tea, etc. Assign prices to each product. Create 2
        // more variables called subtotal and totalSale and complete an “order” for 3 items of the first product,
        // 4 items of the second product, and 2 items of the third product. Add them all together to calculate the
        // subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale
        // amount. Be sure to format the results to 2 decimal places.
        System.out.println("\n-----Ex. 8-----");
        double priceSmoothie = 3.99;
        double priceGreenTea = 1.99;
        double priceLatte = 2.99;
        double subTotal, totalSale;
        final double SALES_TAX = 2.00;
        subTotal = (3 * priceSmoothie) + (4 * priceGreenTea) + (2 * priceLatte);
        totalSale = subTotal + SALES_TAX;
        System.out.println("A smoothie costs: " + priceSmoothie);
        System.out.println("A green tea costs: " + priceGreenTea);
        System.out.println("A latte costs: " + priceLatte);
        System.out.println("The sales tax is: " + SALES_TAX);
        System.out.println("3 smoothies, 4 green teas and 2 lattes cost: " + totalSale);
    }
}
