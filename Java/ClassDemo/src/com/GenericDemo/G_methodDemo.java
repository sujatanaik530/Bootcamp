package com.GenericDemo;

public class G_methodDemo {
    public  int mymethod(int a) {
        int b = a;
        return b;
    }
    public double mymethod(double a) {
        double b = a;
        return b;
    }
    // Repeating functions like the above mymethod takes time. Use a generic method instead.

    public <DataType> void genericmethod(DataType a) {

    }
}
