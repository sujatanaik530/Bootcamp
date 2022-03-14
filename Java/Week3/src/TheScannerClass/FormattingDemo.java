package TheScannerClass;

public class FormattingDemo {
    public static void main(String[] args) {
        System.out.println("\nPrinting static string...");
        String msg = "Hello, user! Your order was placed successfully! Total amount is $600 and tax is 2.5%.";
        System.out.println(msg);

        System.out.println("\nPrinting dynamic string...");
        int orderAmt = 600;
        float tax = 2.5f;
        String userName = "Sujata";
        System.out.println("\nPrinting with %s, %d, %f in format string...");
        System.out.format("Hello, %s! Your order was placed successfully! Total amount is $%d and tax is %.2f.\n", userName, orderAmt, tax);

        // This works! %s in place of any data type
        System.out.println("\nPrinting with %s for every data type...");
        System.out.format("Hello, %s! Your order was placed successfully! Total amount is $%s and tax is %s.", userName, orderAmt, tax);
    }
}
