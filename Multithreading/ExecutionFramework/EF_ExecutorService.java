package Multithreading.Execution_Framework;

//  # Executors Framework

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class EF_ExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> task1 = () -> {
            System.out.println("task-1");
            return factorial(10);
        };
        Callable<Integer> task2 = () -> {
            Thread.sleep(200);
            System.out.println("task-2");
            return 2;
        };
        Callable<Integer> task3 = () -> {
            Thread.sleep(500);
            System.out.println("task-3");
            return 3;
        };
        List<Callable<Integer>> task = Arrays.asList(task1,task2,task3);
        List<Future<Integer>> future = executorService.invokeAll(task);
        for (Future<Integer> f : future){
            System.out.println(f.get());
        }
        executorService.shutdown();
        System.out.printf("Time taken : %.1f SEC",((float)(System.currentTimeMillis() - startTime)/1000));
    }
    static int factorial (int n){
        int ans = 1;
        for (int i = 1;i <= n;i++){
            try {
                Thread.sleep(150);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            ans *= i;
        }
        return ans;
    }
}