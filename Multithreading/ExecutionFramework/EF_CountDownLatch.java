package Multithreading.Execution_Framework;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EF_CountDownLatch {
    static class Task1 implements Runnable{
        private final CountDownLatch latch;
        Task1(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run(){
            try{
                System.out.println(Thread.currentThread().getName() + " Starting... ");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Ending...");
            }
            catch (InterruptedException e) {
                System.out.println("Exception caught: " + e);
            }
            finally {
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " count: " + latch.getCount());
            }
        }
    }
    static class Task2 implements Runnable{
        private final CountDownLatch latch;
        int n;
        Task2(int n, CountDownLatch latch){
            this.n = n;
            this.latch = latch;
        }
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " Starting... ");
            int ans = 1;
            try{
                for (int i = 1; i < n; i++) {
                    Thread.sleep(200);
                    ans *= i;
                }
                System.out.println(ans);
            }
            catch (InterruptedException e){
                System.out.println("Exception Caught: " + e);
            }
            finally {
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " count: " + latch.getCount());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        int numberOfTasks = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        executorService.submit(new Task1(latch));
        executorService.submit(new Task1(latch));
        executorService.submit(new Task2(5, latch));
        executorService.submit(new Task2(10, latch));

        latch.await();

        System.out.println("Main Unlocked.");
        executorService.shutdown();
    }
}