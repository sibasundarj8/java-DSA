package Multithreading;

class Counter{
    private int count = 0;
    private int cOut = 0;
    void increment(){
        count++;
        synchronized (this) {
            cOut++;
        }
    }
    int getCount(){
        return count;
    }
    int getcOut(){
        return cOut;
    }
}
class NewThread extends Thread{

    private final Counter counter;

    NewThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            counter.increment();
        }
    }
}
public class Synchronization_in_java {
    public static void main(String[] args) {
        Counter counter = new Counter();

        NewThread t1 = new NewThread(counter);
        NewThread t2 = new NewThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        // Not Synchronized
        System.out.println(counter.getCount());
        // Synchronized
        System.out.println(counter.getcOut());
    }
}