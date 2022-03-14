package ThreadsDemo2;

import java.util.Random;

public class JoinExample implements Runnable {
    private Random rand = new Random(System.currentTimeMillis());
    public void run() {
        // keep the CPU busy
        for (int i = 0; i < 100_000_000; i++) {
            rand.nextInt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "].");
    }

    public static void main (String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "jointhread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] All threads have finished.");
    }
}
