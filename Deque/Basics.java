package Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;

public class Basics {
    public static void main(String[] args) throws InterruptedException {
        /*
         *   This is a special kind of array that grows and allows users to add or remove an element
         *   from both sides of the queue.
         */
        Deque<Integer> ad = new ArrayDeque<>();
        ad.offer(8); // add in last position
        ad.offerFirst(9);
        ad.offerLast(6);
        // [9, 8, 6]
        System.out.println(ad);

        System.out.println(ad.peek());      // 9 (First)
        System.out.println(ad.peekFirst()); // 9 (First)
        System.out.println(ad.peekLast());  // 6 (First)

        ad.add(1);  // [9, 8, 6, 1]
        ad.poll();
        // [8, 6, 1]
        System.out.println(ad);
        ad.pollFirst();
        // [6, 1]
        System.out.println(ad);
        ad.pollLast();
        // [6]
        System.out.println(ad);


        System.out.println("Blocking Queue");

        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        q.add(5);
        q.add(8);

        System.out.println("Insert using Offer(): " + q.offer(10));

        System.out.println(q);

        // thread removes one element to free up the queue after 2 sec.
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                q.poll();
                System.out.println("Polled by T1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();

        // immediately putting 10 element into the queue but waiting until t1 free the space
        q.put(10);
        System.out.println(q);
    }
}
