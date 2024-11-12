package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks_Reentrant_Lock {
    public static void main(String[] args) {
        Locks_Reentrant_Lock obj = new Locks_Reentrant_Lock();
        obj.outerMethod();
    }
    private final Lock lock = new ReentrantLock();
    void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Locked ");
            innerMethod();
        }
        finally {
            System.out.println("Outer Unlocked");
            lock.unlock();
        }
    }
    void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner Locked ");
        }
        finally {
            System.out.println("Inner Unlocked");
            lock.unlock();
        }
    }
}