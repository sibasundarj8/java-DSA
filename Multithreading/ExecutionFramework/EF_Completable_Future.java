package Multithreading.Execution_Framework;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class EF_Completable_Future {
    public static void main(String[] args) {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println("Working...");
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                System.out.println();
            }
            return "Done";
        }).orTimeout(1, TimeUnit.SECONDS).exceptionally(s -> "Time Out");

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Hello").thenApply(s -> s + " World");

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);

        try{
            f.get();
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println("Exception caught: " + e);
        }
        System.out.println(f1.join());
        System.out.println(f2.join());
    }
}
