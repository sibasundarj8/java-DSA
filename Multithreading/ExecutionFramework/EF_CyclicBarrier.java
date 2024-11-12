package Multithreading.Execution_Framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EF_CyclicBarrier {

    /// Runnable Task
    static class SubSystem implements Runnable{
        private final String name;
        private final int initializationTime;
        private final CyclicBarrier barrier;
        SubSystem(String name, int initializationTime, CyclicBarrier barrier){
            this.name = name;
            this.initializationTime = initializationTime;
            this.barrier = barrier;
        }

        @Override
        public void run(){
            try{
                System.out.println(name + " Initializing...");
                Thread.sleep(initializationTime);
                System.out.println(name + " Completed." + Thread.currentThread().getName());
                barrier.await();
            }
            catch (InterruptedException | BrokenBarrierException e){
                System.out.println("Exception caught: " + e);
            }
        }
    }

    /// Main Method
    public static void main(String[] args) {
        int numOfThreads = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        CyclicBarrier barrier = new CyclicBarrier(numOfThreads, ()->
                System.out.println("System startup Completed.\nLast Thread: " + Thread.currentThread().getName()));
        executorService.submit(new SubSystem("Web Server",2000, barrier));
        executorService.submit(new SubSystem("Database",4000, barrier));
        executorService.submit(new SubSystem("Cache",3000, barrier));
        executorService.submit(new SubSystem("Messaging Service",3500, barrier));
        System.out.println("Starting Main Thread...");
        executorService.shutdown();
    }
}