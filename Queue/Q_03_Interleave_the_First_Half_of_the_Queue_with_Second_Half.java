package Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/interleave-the-first-half-of-the-queue-with-second-half/1
 *
 *   Q. Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.
 *
 *      Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
 *      In other words, Interleaving means place the first element from the first half and then first element from the 2nd half
 *      and again second element from the first half and then second element from the 2nd half and so on....
 *   Ex.
 *      Input : q[] = [2, 4, 3, 1]
 *      Output: [2, 3, 4, 1]
 *      Explanation: We place the first element of the first half 2 and after that
 *                   place the first element of second half 3 and after that repeat
 *                   the same process one more time so the resulting queue will be [2, 3, 4, 1]
 *
 *  Constraints:
 *          1 ≤ queue.size() ≤ 10³
 *          1 ≤ queue[i] ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q_03_Interleave_the_First_Half_of_the_Queue_with_Second_Half {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the queue: ");
        int n = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();

        System.out.println("Enter the elements of the queue: ");
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        rearrangeQueue(q);

        System.out.println("Queue after interleaving its first half with the second half: ");
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }

    /// Solution
    static void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int i = 0; i < n / 2; i++) {
            q2.add(q.poll());
        }

        while (!q2.isEmpty()) {
            q.add(q2.poll());
            q.add(q.poll());
        }
    }
}
