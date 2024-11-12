package Multithreading;


class SharedResource{

    private boolean hasData;

    synchronized void produce(int data){
        // hasData = true, Wait for the consumer to consume.
        if (hasData){
            try{
                wait();
            }
            catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }

        hasData = true;
        System.out.println("Produced : " + data);
        notify();
    }

    synchronized void consume(int value){
        // hasData = false, Wait for the producer to produce.
        if (!hasData){
            try{
                wait();
            }
            catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }

        hasData = false;
        System.out.println("Consumed : " + value);
        notify();
    }
}
class ResProducer implements Runnable{

    SharedResource resource;

    ResProducer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i =0;i < 10;i++){
            resource.produce(i);
        }
    }
}
class ResConsumer implements Runnable{

    SharedResource resource;

    ResConsumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            resource.consume(i);
        }
    }
}
public class ThreadCommunication_Engineer_Digest {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new ResProducer(resource));
        Thread consumerThread = new Thread(new ResConsumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}