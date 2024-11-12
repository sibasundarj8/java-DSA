package Multithreading;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount{

    private int balance = 100000;

    private final Lock lock = new ReentrantLock();

    public void withdraw (int amount){
        System.out.printf("%s attempting to withdraw %d/-\n",Thread.currentThread().getName(),amount);
        try{
            if (lock.tryLock(2, TimeUnit.SECONDS)){
                try{
                    if (amount <= balance){
                        System.out.print("Processing ");
                        for (int i = 0;i < 2;i++){
                            try{
                                Thread.sleep(500);
                            }
                            catch (Exception e){
                                System.out.println("Technical issue.");
                                Thread.currentThread().interrupt();
                            }
                            System.out.print(". ");
                        }
                        System.out.println();
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Successfully Transacted " + amount + "/-.\nNow balance " + balance + "/-");
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + " Insufficient balance.");
                        System.out.printf("Your balance: %d/-\n",balance);
                    }
                }
                finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try again later");
            }
        }
        catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
public class Locks_in_java {
    public static void main(String[] args) throws InterruptedException {

        BankAccount boi = new BankAccount();

        Runnable task = () -> {
            int amount = 40000;
            boi.withdraw(amount);
        };

        Thread t1 = new Thread(task,"Siba");
        Thread t2 = new Thread(task,"Anu");
        Thread t3 = new Thread(task,"Subrat");

        t1.start();
        t2.start();
        t3.start();
    }
}