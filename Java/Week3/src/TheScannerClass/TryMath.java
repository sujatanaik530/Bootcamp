package TheScannerClass;

public class TryMath {
    public static void main(String[] args) {
        int x = 10;
        int y = 4;

        System.out.format("x = %d, y = %d\n", x, y);

        // Math class cannot be instantiated. All methods are static.
        System.out.println("\nMath.max()...");
        System.out.println(Math.max(x, y));

        System.out.println("\nMath.sqrt()...");
        double sqrtx = Math.sqrt((double)x);
        System.out.println("Square root of " + x + " = " + sqrtx);

        System.out.println("\nMath.log()...");
        double log10x = Math.log10((double)x);
        System.out.println("Log to the base 10 of " + x + " = " + log10x);

        System.out.println("\nMath.pow()...");
        double powxy = Math.pow((double)x, (double)y);
        System.out.println(x + " to the power of " + y + " = " + powxy);

        System.out.println("\nMath ceil, floor, rint, round...");
        double d = 83.67;
        System.out.println("d = " + d);
        System.out.println("Output of ceil on d: " + Math.ceil(d));
        System.out.println("Output of floor on d: " + Math.floor(d));
        System.out.println("Output of rint on d: " + Math.rint(d));
        System.out.println("Output of round on d: " + Math.round(d));

        System.out.println("\nMath radians and degrees...");
        double degrees = 90;
        double radians = Math.toRadians(90);
        System.out.println(degrees + " degrees = " + radians + " radians");

        radians = Math.PI;
        degrees = Math.toDegrees(radians);
        System.out.println(radians + " radians = " + degrees + " degrees");
        System.out.println("Sin of " + radians + " = " + Math.sin(radians));

        System.out.println("\nMath.random() for number from 0 to 99...");
        System.out.println(Math.round((Math.random() * 100)));

        System.out.println("\nMath.random() for number from 0 to 59...");
        double dRandom = Math.random();
        double dR1 = dRandom * 60;
        int iRandom = (int) dR1;
        System.out.println("I got " + iRandom + " from " + dRandom);

    }
}
