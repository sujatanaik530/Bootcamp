package ThreadsDemo4;

import ThreadsDemo3.NotSync;

public class Sync extends Thread{
    private static int counter = 0;
    public void run() {
        while (counter < 10) {
            synchronized (Sync.class) {
                System.out.println(Thread.currentThread().getName() + " before " + counter);
                counter++;
                System.out.println(Thread.currentThread().getName() + " after " + counter);
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Sync(), "thread-" + i);
            threads[i].start();
        }
    }
}
