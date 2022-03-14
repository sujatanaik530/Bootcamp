package com.teksystems;

public class MethodOverload {
    private int a;
    private int b;
    private int c;
    private double result;

    public MethodOverload() {

    }

    public MethodOverload(int a, int b, int c) {

    }

    public double getResult(){
        return this.result;
    }

    // rules for overloaded methods:
    // number of arguments must be different OR
    // data type of arguments must be different

    public void addingnumber() {

    }

    public void addingnumber(int a, int b) {
        this.result = (double)(a + b);
    }

    public void addingnumber(double a, int b) {

    }

    public void addingnumber(double a, double b) {

    }

    public void addingnumber(int a, int b, int c) {

    }

    public void addingnumber(int[] x) {
        // use a loop to access array elements, toString
        int xsum = 0;
        for (int i: x) {
            xsum += i;
        }
        System.out.println("Sum is " + xsum);
    }

    public void addingnumber(String str, int...x) {
        // use a loop to access array elements, toString
        int xsum = 0;
        for (int i: x) {
            xsum += i;
        }
        System.out.println(str + xsum);
    }

    public void addingnumber(int[] x, int[] y) {
        // use a loop to access array elements, toString
        int xsum = 0;
        for (int i: x) {
            xsum += i;
        }
        System.out.println(xsum);
    }
}
