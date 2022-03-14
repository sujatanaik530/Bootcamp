package ThreadDemo1;

import ThreadsDemo.MyThread;

public class MainThread extends Thread{
    public void run() {
        System.out.println("Before sleep");
        try {
            Thread.sleep(Long.MAX_VALUE);
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("After sleep");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new MainThread(), "testthread");

        //testThread.start();
        //System.out.println("Thread is running");
        //testThread.interrupt();

        testThread.start();
        System.out.println("Thread is running");
        testThread.join();
        System.out.println("Thread has finished");
    }
}
