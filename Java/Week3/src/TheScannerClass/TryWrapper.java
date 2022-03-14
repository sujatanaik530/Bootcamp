package TheScannerClass;

public class TryWrapper {
    public static void main(String[] args) {
        int i1 = 1;

        // Creating object using literal
        Integer i2 = 4;

        // Creating object using new()
        Integer i3 = new Integer(7);

        System.out.println(i1 + i2 + i3);

        System.out.println("------------Auto-boxing----------");
        // auto-boxing: primitive -> non-primitive
        int a = 20;
        Integer aObj = a; // <- auto-boxing
        System.out.println(aObj.compareTo(10));

        char c = 'A';
        Character ch = c; // <- auto-boxing

        double d = 2563.32;
        Double dObj = d; // <- auto-boxing

        System.out.println("--------------Unboxing---------");
        int aa = aObj; // <- unboxing
        System.out.println(aa);
    }
}
