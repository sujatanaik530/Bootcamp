package FIDemo4;

public class Runnable {
    public static void main(String[] args) {
        MyFirstFunctionalInterface mffi = new MyFirstFunctionalInterface() {
            @Override
            public void firstWork() {
                System.out.println("mffi:firstWork");
            }
        };
        mffi.firstWork();
        mffi.doSomeMoreWork1();
        mffi.doSomeMoreWork2();
    }
}
