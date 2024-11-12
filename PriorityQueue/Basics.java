package Priority_Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Basics {
    public static void main(String[] args) {

        // Prioritize minimum value
        Queue<Integer>pq = new PriorityQueue<>();
        pq.offer(40);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);
        // [12, 36, 24, 40]
        System.out.println(pq);

        pq.poll();
        // [24, 36, 40]
        System.out.println(pq);

        // Prioritize minimum value
        Queue<Integer>qp = new PriorityQueue<>(Comparator.reverseOrder());
        qp.offer(40);
        qp.offer(12);
        qp.offer(24);
        qp.offer(36);
        // [40, 36, 24, 12]
        System.out.println(qp);

        qp.poll();
        // [36, 12, 24]
        System.out.println(qp);
    }
}