package FIDemo3;

public class Runnable {
    public static void main(String[] args) {
        InterfacesExample1 ex1 = new InterfacesExample1() {
            @Override
            public void print() {
                System.out.println("Functional interface ex1");
            }
        };

        InterfacesExample1 ex2 = new InterfacesExample1() {
            @Override
            public void print() {
                System.out.println("Functional interface ex2");
            }
        };
        ex1.print();
        ex2.print();
    }
}
