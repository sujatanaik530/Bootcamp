package TheScannerClass;

public class StringDemo {
    public static void main(String[] args) {
        // st is a string literal
        String st = "Welcome to Java!";

        // using a constructor
        String st1 = new String("Welcome to TEKGlobal");
        System.out.println("\n--------String immutability------------");
        System.out.println("\n--------String.replace()------------");

        System.out.println("Before replace st: ");
        System.out.println(st);

        // String is immutable, so result has to be a new String.
        String st2 = st.replace("Java", "Python");

        // No compiler error/warning here!
        // But this is not good practice. Use StringBuffer instead.
        st = st.replace("Java", "Python");

        System.out.println("After replace (on self) st: ");
        System.out.println(st);
        System.out.println("After replace st2: ");
        System.out.println(st2);

        System.out.println("\n--------String.length()------------");
        int stLen = st.length();
        System.out.println("Length of " + st + " is " + stLen + ".");

        System.out.println("\n--------String.concat()------------");
        System.out.println(st.concat(st1));

        System.out.println("\n--------String.charAt()------------");
        System.out.println(st.charAt(0));

        System.out.println("\n--------String.indexOf()------------");
        System.out.println(st.indexOf('W'));

        System.out.println("\n--------String.lastIndexOf()------------");
        System.out.println(st.lastIndexOf('a'));

        String s1 = "Test String";
        String s2 = "Test String 1";

        System.out.println("\n--------String.compareTo()------------");
        System.out.println(s1.compareTo(s2));

        System.out.println("\n--------String.equals()------------");
        System.out.println(s1.equals(s2));

        System.out.println("\n--------String.toUpperCase()------------");
        System.out.println(s1.toUpperCase());

        System.out.println("\n--------String.substring()------------");
        System.out.println(st.substring(8, 15));

        System.out.println("\n--------Integer.parseInt()------------");
        String stNum = "20";
        int numSt = Integer.parseInt(stNum);
        System.out.println("String " + stNum + " = " + numSt);

        System.out.println("\n--------String.valueOf()------------");
        Integer numStObj = Integer.valueOf(stNum);
        System.out.println("String " + stNum + " = " + numStObj);

        System.out.println("\n--------Two ways to use toString()------------");
        Double d = 30.55;
        System.out.println("String of  " + d + " = " + d.toString());
        System.out.println("String of  " + d + " = " + Double.toString(d));
    }
}
