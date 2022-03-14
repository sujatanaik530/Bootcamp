package org.sujata.myfirstpackage;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigDecimal;

public class LearingJava {
    // pvsm tab to get below boilerplate
    public static void main(String[] args) {
        // Entry point in Java

        // sout tab to get below boilerplate
        System.out.println("Hello, Java!");
        double radius = 20.0;
        final double PI = 3.14;
        double area = radius * radius * PI;
        System.out.println("The area of a circle with radius " + radius + " is "+ area);

        System.out.println("----------Primitive data types------------");
        byte bytevar = 5;
        short shortvar = 20;
        int intvar = 500;
        long longvar = 3898L;

        float floatvar1 = 3.24F;
        float floatvar2 = 10 / 3;
        double doublevar1 = 4.55;
        double doublevar2 = 45/37;

        char charvar1 = 'S';
        char charvar2 = '\u1f60'; // Unicode
        System.out.println(charvar2);

        boolean boolvar1 = true;
        boolean boolvar2 = false;
        System.out.println(boolvar1);

        // widening type casting (auto type conversion): smaller -> larger
        bytevar = 5;
        shortvar = bytevar; // byte -> short
        intvar = shortvar; // short -> int
        longvar = intvar; // int -> long
        System.out.println(longvar);

        double floatvar = longvar;
        double doublevar = floatvar;
        System.out.println("short " + shortvar);
        System.out.println("int " + intvar);
        System.out.println("long " + longvar);
        System.out.println("float " + floatvar);
        System.out.println("double " + doublevar);

        // narrow type casting: larger -> smaller
        // values are truncated, so data is lost

        double dtax = 2598.321;
        int itax = (int) dtax;
        short stax = (short) dtax;
        byte btax = (byte) dtax;
        System.out.println(btax);
        System.out.println(stax);
        System.out.println(itax);

        byte b = 127;
        System.out.println("Byte b = " + b);
        short s = 128;
        b = (byte) s;
        System.out.println("Byte b = " + b);

        // Non-primitive datatypes or reference data types

        System.out.println("----------Non-primitive data types------------");
        String st = "Hello String";
        System.out.println("Original: " + st);
        System.out.println("In uppercase: " + st.toUpperCase());
    } // end main method
    /*
    This is a multi-line comment.
    By Sujata
     */

}
