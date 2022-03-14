package TheScannerClass;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        //  Arrays
        // <datatype>[] <object-name> = new <datatype>[size]
        System.out.println("Arrays");
        int[] a = new int[10]; // recommended
        int b[] = new int[10]; // will work too

        byte[] by = new byte[3];
        short[] s = new short[4];
        long[] l = new long[4];

        float[] f = new float[4];
        double[] d = new double[4];

        String[] str = new String[3];
        Integer[] i = new Integer[5];

        Object o[];     // size can be provided during initialization
        int[] intarray;

        // initializing the array
        // even if only 5 of 10 are initialized, no errors or warnings or exceptions
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 40;
        a[4] = 50;
        for(int ii =0; ii < 10; ii++){
            System.out.println(a[ii]);
        }

        //a[10] = 110; // ArrayIndexOutOfBoundsException

        int[] aint = new int[10];
        for(int ii = 0; ii < 10; ii++) {
            aint[ii] = ii + 10;
            System.out.println("Element at " + ii + " = " + aint[ii]);
        }

        // another way to initialize an array
        int[] c = {11, 22, 33, 44, 55, 66};

        // array declared with size of another array
        int[] d1 = new int[c.length];

        // accessing array elements with for loop
        // for(<datatype> <item>:<arrayname>
        System.out.println("\nAccessing array elements with for loop");
        for(int ii = 0; ii < c.length; ii++) {
            System.out.println(c[ii]);
        }
        // accessing array elements with enhanced for loop
        // for(<datatype> <item>:<arrayname>
        System.out.println("\nAccessing array elements with enhanced for loop");
        for(int citem: c) {
            System.out.println(citem);
        }

        // printing an array with Arrays.toString()
        System.out.println("\nUsing Arrays.toString()");
        System.out.println(Arrays.toString(c));

        System.out.println("\nArray copying");
        int[] listone = {1, 2, 3, 4, 5, 6};
        int[] listtwo = listone;
        System.out.println("listone: " + Arrays.toString(listone));
        System.out.println("listtwo: " + Arrays.toString(listtwo));

        System.out.println("\nChanged item in listone at index 4 to 99");
        listone [4] = 99;
        System.out.println("listone: " + Arrays.toString(listone));
        System.out.println("listtwo: " + Arrays.toString(listtwo));

        System.out.println("\nChanged item in listtwo at index 3 to 55");
        listtwo [3] = 55;
        System.out.println("listone: " + Arrays.toString(listone));
        System.out.println("listtwo: " + Arrays.toString(listtwo));

        if (listone == listtwo) {
            System.out.println("\nSame instance or memory location");
        }
        else {
            System.out.println("\nDifferent instances or memory locations");
        }

        System.out.println("\nCopying an array using a loop and then changing both arrays");
        int srcArray[] = {1, 2, 3, 4, 5, 6};
        int dstArray[] = new int[srcArray.length];
        for(int idx = 0; idx < srcArray.length; idx++) {
            dstArray[idx] = srcArray[idx];
        }
        srcArray[5] = 99;
        dstArray[5] = 999;
        System.out.println("srcArray = " + Arrays.toString(srcArray));
        System.out.println("dstArray = " + Arrays.toString(dstArray));

        System.out.println("\nCopying an array using clone and then changing both arrays");
        int tgtArray[] = srcArray.clone();
        srcArray[5] = 9999;
        tgtArray[5] = 99999;
        System.out.println("srcArray = " + Arrays.toString(srcArray));
        System.out.println("tgtArray = " + Arrays.toString(tgtArray));

        System.out.println("\nCopying (part of) an array using System.arraycopy()");
        int srcArray1[] = {1, 2, 3, 4, 5, 6};
        int tgtArray1[] = {0, 0, 0, 7, 8, 9};
        System.out.println("srcArray1 = " + Arrays.toString(srcArray1));
        System.out.println("tgtArray1 = " + Arrays.toString(tgtArray1));
        System.out.println("Calling System.arraycopy()");
        System.arraycopy(srcArray1, 3, tgtArray1, 0, 3);
        System.out.println("srcArray1 = " + Arrays.toString(srcArray1));
        System.out.println("tgtArray1 = " + Arrays.toString(tgtArray1));

        System.out.println("\nCopying (part of) an array using Arrays.copyOf()");
        int[] list3 = {5, 6, 7, 8, 9, 10};
        int[] list4 = Arrays.copyOf(list3, 20);
        System.out.println("list3 = " + Arrays.toString(list3));
        System.out.println("list4 = " + Arrays.toString(list4));

        System.out.println("\nCopying (part of) an array using Arrays.copyOfRange()");
        int[] list5 = Arrays.copyOfRange(list3, 2, 5);
        System.out.println("list3 = " + Arrays.toString(list3));
        System.out.println("list5 = " + Arrays.toString(list5));

        System.out.println("\nInitializing array with user input");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number for array initialization: ");
        int arraysize = sc.nextInt();
        String[] data = new String[arraysize];

        sc.nextLine(); // to read the newline character at the end of the integer

        System.out.println("Enter your full name: ");
        String myName = sc.nextLine();
        System.out.println("Enter your user name: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Enter your phone number: ");
        int phone = sc.nextInt();

        data[0] = myName;
        data[1] = userName;
        data[2] = password;
        data[3] = Integer.toString(phone);

        System.out.println(Arrays.toString(data));

        // Initializing arrays with Arrays.fill()
        System.out.println("Arrays.fill()");
        long[] lvalues = new long[500];
        Arrays.fill(lvalues, 3L);
        System.out.println(Arrays.toString(lvalues));

        // Challenge: reverse an array
        int[] intArray = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 10};
        int[] revIntArray = new int[intArray.length];
        for(int j = 0; j < intArray.length ; j++) {
            revIntArray[j] = intArray[intArray.length - 1 - j];
        }
        System.out.println("\nReverse of " + Arrays.toString(intArray) + " is " + Arrays.toString(revIntArray));

        // Challenge: find maximum number in an array
        int numArray[] = {45, 23, 78, 1, 4, 8, 89, 33, 5, 0};
        int maxNum = numArray[0];
        for (int eachNum: numArray) {
            if (eachNum > maxNum) {
                maxNum = eachNum;
            }
        }
        System.out.println("\nMaximum of " + Arrays.toString(numArray) + " is " + maxNum);

        // deleting an element
        int anumArray[] = {45, 23, 78, 1, 4, 8, 89, 33, 5, 0};
        System.out.println("\nArray is " + Arrays.toString(anumArray));
        System.out.println("\nRemoving element at index 4...");
        int removeelementat = 4;
        for (int ii = removeelementat; ii < anumArray.length - 1; ii++) {
            anumArray[ii] = anumArray[ii + 1];
        }
        System.out.println("\nArray is now " + Arrays.toString(anumArray));

        // inserting an element

        // using Array.sort()
        System.out.println("\nUsing Arrays.sort()");
        System.out.println("Before sort: " + Arrays.toString(anumArray));
        Arrays.sort(anumArray);
        System.out.println("After sort: " + Arrays.toString(anumArray));

        // 2D arrays
        int[][] my2darray = new int[][]
                {
                        {10, 12, 43, 22},
                        {20, 56, 58, 96},
                        {40, 565, 66, 8},
                        {15, 58, 79, 52},
                        {58, 96, 36, 74},
                        {58, 96, 36, 74, 52, 63}
                };

        System.out.println("----------------------");
        for (int x = 0; x < my2darray.length; x++) {
            //System.out.println(my2darray[x]);
            for (int y = 0; y < my2darray[x].length; y++)
            {
                System.out.print(my2darray[x][y] + " ");
            }
            System.out.println();
        }

        /*
        System.out.println("\n2 D arrays");
        System.out.println("Number of elements in the main array (number of rows)");
        System.out.println(my2darray.length);
        System.out.println("Number of elements in each sub-array");
        System.out.println(my2darray[0].length);
        System.out.println(my2darray[1].length);
        System.out.println(my2darray[2].length);
        System.out.println(my2darray[3].length);
        System.out.println(my2darray[4].length);
        System.out.println(my2darray[5].length);

        System.out.println("Print each element using nested for loops");
        for(int ii = 0;ii < my2darray.length; ii++) {
            for(int jj = 0; jj < my2darray[ii].length; jj++){
                System.out.print(my2darray[ii][jj] + " ");
            }
            System.out.println();
        }*/
    }
}
