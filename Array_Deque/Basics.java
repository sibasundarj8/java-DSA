package Array_Deque;


import java.util.ArrayDeque;
import java.util.Deque;

public class Basics {
    public static void main(String[] args) {
   /*
    *   This is a special kind of array that grows and allows users to add or remove an element
    *   from both sides of the queue.
    */
        Deque<Integer>ad = new ArrayDeque<>();
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
    }
}