package Day2;

import java.util.Arrays;

public class CoreJavaArrays {
    public static void main(String[] args) {
        //fnOne();
        //fnTwo();
        //fnThree();
        //fnFour();
        //fnFive();
        //fnSix();
        //fnSeven();
        //fnEight();
        //fnNine();
        //fnTen();
    }
    static void fnOne() {
/*  Write a program that creates an array of integers with a length of 3. Assign the values 1, 2, and 3 to the indexes.
    Print out each array element.
 */
        int[] intArray = new int[3];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        System.out.println(intArray[0] + " " + intArray[1] + " " + intArray[2]);
    }

    static void fnTwo() {
/*  Write a program that returns the middle element in an array. Give the following values to the integer array:
    {13, 5, 7, 68, 2} and produce the following output: 7
 */
        int[] intArray = {13, 5, 7, 68, 2};
        System.out.println(intArray[intArray.length/2]);
    }

    static void  fnThree() {
/*  Write a program that creates an array of String type and initializes it with the strings “red”, “green”, “blue” and
    “yellow”. Print out the array length. Make a copy using the clone( ) method. Use the Arrays.toString( ) method on
    the new array to verify that the original array was copied.
 */
        String[] strArray = {"red", "green", "blue", "yellow"};
        System.out.println(strArray.length);
        String[] strArrayClone = strArray.clone();
        System.out.println(Arrays.toString(strArray) + " " + Arrays.toString(strArrayClone));
    }

    static void fnFour() {
/*  Write a program that creates an integer array with 5 elements (i.e., numbers). The numbers can be any integers.
    Print out the value at the first index and the last index using length - 1 as the index. Now try printing the value
    at index = length ( e.g., myArray[myArray.length ] ).  Notice the type of exception which is produced. Now try to
    assign a value to the array index 5. You should get the same type of exception.
 */
        int[] intArray = {11, 22, 33, 44, 55};
        System.out.println(intArray[0] + " " + intArray[intArray.length - 1]);

        // Below line throws ArrayIndexOutOfBoundsException
        //System.out.println(intArray[intArray.length]);

        // Below line also throws ArrayIndexOutOfBoundsException
        //intArray[5] = 66;
    }

    static void fnFive() {
/*  Write a program where you create an integer array with a length of 5. Loop through the array and assign the value
    of the loop control variable (e.g., i) to the corresponding index in the array.
 */
        int[] intArray = new int[5];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }
        System.out.println(Arrays.toString(intArray));
    }

    static void fnSix() {
/*  Write a program where you create an integer array of 5 numbers. Loop through the array and assign the value of the
    loop control variable multiplied by 2 to the corresponding index in the array.
 */
        int[] intArray = new int[5];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 2;
        }
        System.out.println(Arrays.toString(intArray));
    }

    static void fnSeven() {
/*  Write a program where you create an array of 5 elements. Loop through the array and print the value of each element,
    except for the middle (index 2) element.
 */
        int[] intArray = {11, 22, 33, 44, 55};
        for (int i = 0; i < intArray.length; i++) {
            if (i == intArray.length / 2) {
                continue;
            }
            else {
                System.out.println(intArray[i]);
            }
        }
    }

    static void fnEight() {
/*  Write a program that creates a String array of 5 elements and swaps the first element with the middle element
    without creating a new array.
 */
        String[] strArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println(Arrays.toString(strArray));
        String temp = strArray[0];
        strArray[0] = strArray[strArray.length/2];
        strArray[strArray.length/2] = temp;
        System.out.println(Arrays.toString(strArray));
    }

    static void fnNine() {
/*  Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. Print the array in
    ascending order, print the smallest and the largest element of the array. The output will look like the following:
    Array in ascending order: 0, 1, 2, 4, 9, 13
    The smallest number is 0
    The biggest number is 13
 */
        int[] intArray = {4, 2, 9, 13, 1, 0};
        System.out.println("Original array: " + Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.print("Array in ascending order: ");
        for (int num: intArray) {
            System.out.print(num + ", ");
        }
        System.out.println("\nThe smallest number is " + intArray[0]);
        System.out.println("The biggest number is " + intArray[intArray.length - 1]);
    }

    static void fnTen(){
/*  Create an array that includes an integer, 3 strings, and 1 double. Print the array.
*/
        Object[] objArray = {11, "aaa", "bbb", "ccc", 3.4};
        System.out.println(Arrays.toString(objArray));
    }
}
