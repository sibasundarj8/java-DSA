package Multithreading;


public class Creating_Threads{
    // Define a class that extends Thread
    static class MyThread extends Thread{
        public void run(){
            // Code to be executed by the thread
            System.out.println("Thread Running : " + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        // Create an instance of MyThread
        MyThread thread = new MyThread();
        System.out.println("state : " + thread.getState());
        thread.start();
        System.out.println("state : " + thread.getState());
        thread.interrupt();

        // Lambda Expression
        Thread obj2 = new Thread(() -> {
            System.out.println("Thread 2 Running : " + Thread.currentThread().getName());
        });
        obj2.start();

        Runnable obj = () -> {
            System.out.println("Thread 3 Started : " + Thread.currentThread().getName());
            System.out.println("\nProcessing...\n");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 Completed");
        };
        Thread thread3 = new Thread(obj);
        thread3.start();
    }
}