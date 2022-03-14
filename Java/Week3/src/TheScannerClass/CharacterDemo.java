package TheScannerClass;

public class CharacterDemo {
    public static void main(String[] args) {
        System.out.println("\n----------Character class instantiation--------");
        // initialize with a character literal
        Character letter = 'A';
        System.out.println(letter);

        // initialize with a number (ASCII value)
        Character asciiNumber = 97;
        System.out.println(asciiNumber);

        // initialize with a Unicode value
        Character unicodeNumber = '\u0031';
        System.out.println(unicodeNumber);

        Character Obj1 = 'B';
        Character Obj2 = 'A';
        System.out.println("\n----------Character.compareTo()--------");
        int iresult = Obj1.compareTo(Obj2);
        System.out.println(iresult);

        System.out.println("\n----------Character.equals()--------");
        boolean bresult = Obj1.equals(Obj2);
        System.out.println(bresult);

        System.out.println("\n----------Character.isLetter()--------");
        bresult = Obj1.isLetter(Obj2);
        System.out.println(bresult);

        System.out.println("\n----------Character.isDigit()--------");
        bresult = Obj1.isDigit(Obj2);
        System.out.println(bresult);

        System.out.println("\n----------Character.valueOf()--------");
        System.out.println(Obj1.valueOf('A'));
    }
}
