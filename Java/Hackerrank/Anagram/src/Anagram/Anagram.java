package Anagram;

import java.util.Scanner;

public class Anagram {
        static boolean isAnagram(String a, String b) {
            if (a.length() != b.length()) {
                return false;
            }
            // Complete the function
            char[] arrayA = a.toLowerCase().toCharArray();
            char[] arrayB = b.toLowerCase().toCharArray();
            char[] sortedA = sortCharArray(arrayA);
            char[] sortedB = sortCharArray(arrayB);

            System.out.println(String.valueOf(sortedA) + " " + String.valueOf(sortedB));

            String newA = new String(sortedA);
            String newB = new String(sortedB);
            if (newA.compareTo(newB) == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        static char[] sortCharArray(char[] inArray) {
            char temp;
            int i = 0;
            while (i < inArray.length) {
                int j = i + 1;
                while (j < inArray.length) {
                    if (inArray[j] < inArray[i]) {
                        temp = inArray[i];
                        inArray[i] = inArray[j];
                        inArray[j] = temp;
                    }
                    j += 1;
                }
                i += 1;
            }
            return inArray;
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            String b = scan.next();
            scan.close();
            //String a = "SRN";
            //String b = "NRS";
            boolean ret = isAnagram(a, b);
            System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        }
}
