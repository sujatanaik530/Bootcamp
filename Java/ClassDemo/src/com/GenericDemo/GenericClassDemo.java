package com.GenericDemo;

// <DataType> can be <anything>
public class GenericClassDemo<DataType> {
    // class-level variable
    // data type determined at runtime
    private DataType varOne;

    public GenericClassDemo(DataType var) {
        this.varOne = var;
    }

    public void setVarOne(DataType var) {
        this.varOne = var;
    }

    public DataType getVarOne() {
        return this.varOne;
    }

    public void printArray(DataType[] arr) {
        for (DataType item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
