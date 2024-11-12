package Multithreading.Execution_Framework;

import java.util.concurrent.*;

public class EF_ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduler  = Executors.newScheduledThreadPool(3);

        ScheduledFuture<Integer> scheduledFuture;


        /// schedule() Method
        scheduledFuture = scheduler.schedule(()-> {
            System.out.println("schedule");
            return 5;
        },1,TimeUnit.SECONDS);

        scheduledFuture.get();
        System.out.println("Completed");


        /// scheduleWithFixedDelay() Method
        scheduler.scheduleWithFixedDelay(()-> {     // No Overlapping of tasks
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception Caught: " + e);
            }
            System.out.println("scheduleWithFixedDelay");
        },1,1,TimeUnit.SECONDS);


        /// scheduleAtFixedRate() Method
        scheduler.scheduleAtFixedRate(()-> {       // Overlapping of tasks
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception Caught: " + e);
            }
            System.out.println("scheduleAtFixedRate");
        },1,1,TimeUnit.SECONDS);
                                                   // Shutting Down after 10 seconds
        scheduler.schedule(scheduler::shutdown,10,TimeUnit.SECONDS);
    }
}