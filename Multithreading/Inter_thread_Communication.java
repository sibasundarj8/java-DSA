package Multithreading;

import static java.lang.Thread.sleep;

public class Inter_thread_Communication {
    public static void main(String[] args) {
        Company com = new Company();
        Producer p = new Producer(com);
        Consumer c = new Consumer(com);
        p.t1.start();
        c.t2.start();
    }
}
class Company{
    boolean flag = false;
    int n;

    // False Time to produce
    public synchronized void produceItem(int n){
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.n = n;
        System.out.println("Produced Item : " + this.n);
        flag = true;
        notify();
    }

    // True time to consume
    public synchronized void consumeItem(){
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumed Item : " + this.n);
        flag = false;
        notify();
    }
}
class Producer{
    Company c;
    Producer(Company c){
        this.c = c;
    }
    Thread t1 = new Thread(()->{
        int i = 1;
        while (true){
            this.c.produceItem(i++);
            try{
                sleep(1000);
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    });
}
class Consumer{
    Company c;
    Consumer(Company c){
        this.c = c;
    }
    Thread t2 = new Thread(()->{
        while (true){
            this.c.consumeItem();
            try {
                sleep(1000);
            }
            catch (Exception e){
                throw new RuntimeException();
            }
        }
    });
}