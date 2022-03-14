package RunnableThreadsDemo;

public class MyRunnable implements Runnable{
    public void run() {
        System.out.println("Executing thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable(), "myRunnable");
        myThread.start();
    }
}
