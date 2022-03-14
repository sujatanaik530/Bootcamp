package LambdaDemo1;

public class Runnable {
    public static void main(String[] args) {
        MyFI msg = () -> {
            return "Hello";
        };
        System.out.println(msg.sayHello());

        System.out.println();

        MyFI1 incBy5 = (num) -> {
            return (num+5);
        };
        System.out.println(incBy5.incrementByFive(10));

        System.out.println();

        MyFI2 sdc = (s1, s2) -> {
            return s1 + "-" + s2;
        };
        System.out.println(sdc.sdashconcat("Sujata", "Naik"));
    }
}
