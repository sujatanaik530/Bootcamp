package TheScannerClass;

public class WhileLoopDemo {
    public static void main(String[] args) {
        // while loops
        System.out.println("\nWhile loops");
        int i = 0;
        while (i <= 10) {
            System.out.println(i + " Hello!");
            i++;
        }

        // do while loops
        // the loop body will execute at least once.
        System.out.println("\nDo while loops");
        int a = 10;
        do {
            System.out.println(a + " Hello!");
            a++;
        } while (a < 10);
        System.out.println("\nAnother do while loop");
        int x = 21, sum = 0;
        do {
            sum += x;
            x--;
        } while (x > 10);
        System.out.println("sum = " + sum);
    }
}
