package OS_Problems;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class OS_01_Producer_Consumer_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of buffer");
        int size = sc.nextInt();

        Buffer buffer = new Buffer(size);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            Thread.sleep(3000);
            consumerThread.interrupt();
            producerThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

// producer which produces item.
class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while(true) {
            try {
                buffer.produce();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

// consumer which consumes item
class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true){
            try {
                buffer.consume();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

// buffer in which we produce and consume item synchronously.
class Buffer {
    private int in;
    private int out;
    private final int capacity;
    private final int[] buffer;
    private final Semaphore mutex;
    private final Semaphore full;
    private final Semaphore empty;

    public Buffer(int size) {
        in = 0;
        out = 0;
        capacity = size;
        buffer = new int[size];
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    void produce() throws InterruptedException {
        int item = ThreadLocalRandom.current().nextInt(1, 100);

        empty.acquire();
        mutex.acquire();

        buffer[in] = item;
        System.out.println("[Producer]: " + item);
        in = (in + 1) % capacity;

        mutex.release();
        full.release();
    }

    void consume() throws InterruptedException{
        full.acquire();
        mutex.acquire();

        int item = buffer[out];
        buffer[out] = 0;
        System.out.println("[Consumer]: " + item);
        out = (out + 1) % capacity;

        mutex.release();
        empty.release();
    }
}
