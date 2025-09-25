package Deque;/*
 *
 * https://www.geeksforgeeks.org/problems/design-minmax-queue/1
 *
 * # Design MinMax Queue (medium)
 *
 *   Q. Design a SpecialQueue data structure that functions like a normal queue but with additional support
 *      for retrieving the minimum and maximum element efficiently.
 *
 *      The SpecialQueue must support the following operations:
 *        • enqueue(x): Insert an element x at the rear of the queue.
 *        • dequeue(): Remove the element from the front of the queue.
 *        • getFront(): Return the front element without removing.
 *        • getMin(): Return the minimum element in the queue in O(1) time.
 *        • getMax(): Return the maximum element in the queue in O(1) time.
 *
 *      There will be a sequence of queries[][]. The queries are represented in numeric form:
 *        • 1 x : Call enqueue(x)
 *        • 2:    Call dequeue()
 *        • 3:    Call getFront()
 *        • 4:    Call getMin()
 *        • 5:    Call getMax()
 *
 *      The driver code will process the queries, call the corresponding functions, and print the outputs
 *      of getFront(), getMin(), getMax() operations.
 *
 *      You only need to implement the above five functions.
 *
 *  Constraints:
 *      1 ≤ queries.size() ≤ 10⁵
 *      0 ≤ values in the queue ≤ 10⁹
 */

import java.util.LinkedList;
import java.util.Scanner;

public class DQ_01_Design_MinMax_Queue {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SpecialQueue q = new SpecialQueue();

        System.out.println("""
                • 1 x : Call enqueue(x)
                • 2:    Call dequeue()
                • 3:    Call getFront()
                • 4:    Call getMin()
                • 5:    Call getMax()
                • any number: EXIT
                >>>""");

        while (true) {
            int x = sc.nextInt();

            switch (x) {
                case 1 -> q.enqueue(sc.nextInt());
                case 2 -> q.dequeue();
                case 3 -> {
                    int t = q.getFront();
                    System.out.println("Front: " + t);
                }
                case 4 -> {
                    int t = q.getMin();
                    System.out.println("Min: " + t);
                }
                case 5 -> {
                    int t = q.getMax();
                    System.out.println("Max: " + t);
                }
                default -> {
                    return;
                }
            }
        }
    }
}

/// Solution
class SpecialQueue {
    static LinkedList<Integer> q;       // queue
    static LinkedList<Integer> dqMax;   // deque
    static LinkedList<Integer> dqMin;   // deque

    // Define Data Structures
    public SpecialQueue() {
        q = new LinkedList<>();
        dqMin = new LinkedList<>();
        dqMax = new LinkedList<>();
    }

    // Insert element into the queue
    public void enqueue(int x) {
        q.add(x);

        // update min element
        while (!dqMin.isEmpty() && dqMin.peekLast() > x) dqMin.pollLast();
        dqMin.addLast(x);

        // update right element
        while (!dqMax.isEmpty() && dqMax.peekLast() < x) dqMax.pollLast();
        dqMax.addLast(x);
    }

    // Remove element from the queue
    public void dequeue() {
        if (isEmpty(q)) return;
        int x = q.poll();

        // update min element
        if (!dqMin.isEmpty() && x == dqMin.peekFirst()) dqMin.pollFirst();

        // update max element
        if (!dqMax.isEmpty() && x == dqMax.peekFirst()) dqMax.pollFirst();
    }

    // Get front element
    public int getFront() {
        if (isEmpty(q)) return -1;
        return q.peek();
    }

    // Get minimum element
    public int getMin() {
        if (isEmpty(dqMin)) return -1;
        return dqMin.peekFirst();
    }

    // Get maximum element
    public int getMax() {
        if (isEmpty(dqMax)) return -1;
        return dqMax.peekFirst();
    }

    // private method to check isEmpty
    private boolean isEmpty(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.err.print("[EXCEPTION]: Queue is empty \t");
            return true;
        }

        return false;
    }
}
