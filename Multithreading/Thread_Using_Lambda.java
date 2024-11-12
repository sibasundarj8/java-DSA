package Multithreading;


class MyThreads implements Runnable{
    @Override
    public void run() {
        System.out.println("Without using Lambda");
    }
}
public class Thread_Using_Lambda {
    public static void main(String[] args) {

        // 8 lines of Code to create Thread
        MyThreads task = new MyThreads();
        Thread t1 = new Thread(task);

        // Single line Thread creation
        Thread t2 = new Thread(()-> System.out.println("Using Lambda"));

        t1.start();
        t2.start();
    }
}