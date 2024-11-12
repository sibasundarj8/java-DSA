package Multithreading;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteCounter{
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    int getCount(){
        readLock.lock();
        try{
            return count;
        } finally {
            readLock.unlock();
        }
    }
    void increment(){
        writeLock.lock();
        try{
            count++;
            Thread.sleep(5);
        }
        catch (Exception e){
            Thread.currentThread().interrupt();
        }
        finally {
            writeLock.unlock();
        }
    }
}
public class Locks_Read_Write_Lock {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = () -> {
            for (int i = 0;i < 5;i++){
                System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
            }
        };
        Runnable writeTask = () -> {
            for (int i = 0;i < 5;i++){
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " incremented.");
            }
        };

        Thread write = new Thread(writeTask);
        Thread read1 = new Thread(readTask);
        Thread read2 = new Thread(readTask);

        read1.start();
        read2.start();
        write.start();


        write.join();
        read1.join();
        read2.join();

        System.out.println("Final count : " + counter.getCount());
    }
}