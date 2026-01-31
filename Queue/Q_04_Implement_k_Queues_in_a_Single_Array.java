package Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/implement-k-queues-in-a-single-array/1
 *
 * # Implement k Queues in a Single Array
 *
 *   Q. You are given two integers n and k. Your task is to implement a class kQueues that uses a single array of size n
 *      to simulate k independent queues.
 *
 *      The class should support the following operations:
 *       1) enqueue(x, i) → Adds the element x into the i-th queue.
 *       2) dequeue(i) → Removes the front element from the i-th queue and returns it. Returns -1 if the queue is empty.
 *       3) isEmpty(i) → Returns true if i-th queue is empty, else return false.
 *       4) isFull() → Returns true if the array is completely full and no more elements can be inserted, otherwise false.
 *
 *      There will be a sequence of q queries represented as:
 *        ⇨ 1 x i : Call enqueue(x, i)
 *        ⇨ 2 i : Call dequeue(i)
 *        ⇨ 3 i : Call isEmpty(i)
 *        ⇨ 4 : Call isFull()
 *
 *      The driver code will process the queries, call the corresponding functions, and print the results of dequeue,
 *      isEmpty, and isFull operations. You only need to implement the above four functions.
 *
 *   Ex.
 *      Input : n = 4, k = 2, q = 8,
 *              queries = [[1, 5, 0],
 *                          [1, 3, 0],
 *                          [1, 1, 1],
 *                          [2, 0],
 *                          [1, 4, 1],
 *                          [1, 1, 0],
 *                          [3, 1],
 *                          [4]]
 *      Output: [5, false, true]
 *      Explanation: Queries on the queue are as follows:
 *                     enqueue(5, 0) → queue0 = [5]
 *                     enqueue(3, 0) → queue0 = [5, 3]
 *                     enqueue(1, 1) → queue1 = [1]
 *                     dequeue(0) → returns 5, queue0 = [3]
 *                     enqueue(4, 1) → queue1 = [1, 4]
 *                     enqueue(1, 0) → queue0 = [3, 1]
 *                     isEmpty(1) → false
 *                     isFull() → true
 *
 *  Constraints:
 *          1 ≤ q ≤ 10⁵
 *          1 ≤ k ≤ n ≤ 10⁵
 *          0 ≤ values on the queues ≤ 10⁹
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q_04_Implement_k_Queues_in_a_Single_Array {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();
        if (k > n) return;

        kQueues kq = new kQueues(n, k);

        System.out.print("Number of queries: ");
        int q = sc.nextInt();

        System.out.println("""
                Enter queries like this,
                •  1 x i : Call enqueue(x, i)
                •  2 i   : Call dequeue(i)
                •  3 i   : Call isEmpty(i)
                •  4     : Call isFull()""");

        while (q-- > 0) {
            int operation = sc.nextInt();
            switch (operation) {
                case 1 -> kq.enqueue(sc.nextInt(), sc.nextInt());
                case 2 -> System.out.println(kq.dequeue(sc.nextInt()));
                case 3 -> System.out.println(kq.isEmpty(sc.nextInt()));
                case 4 -> System.out.println(kq.isFull());
                default -> System.out.println("Invalid operation");
            }
        }
    }
}

// Solution
class kQueues {
    private final int k;

    // stores the index of next free spaces if available else -1.
    private int nextFree;

    // stores the actual elements of queues.
    private final int[] arr;

    // stores the front index of queues.
    private final int[] front;

    // stores the rear index of queues.
    private final int[] rear;

    // stores the next pointer or positon of every queue or free space like linked-list.
    private final int[] next;

    // constructor
    public kQueues(int n, int k) {
        // Initialize your data members
        this.k = k;
        this.arr = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];

        // initially every position are treated as free space, So first free space is 0 and next are linked to it.
        this.nextFree = 0;
        this.next[n - 1] = -1;

        for (int i = 0; i < n - 1; i++) {
            this.next[i] = i + 1;
        }

        // marking all the queues as empty (-1).
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
    }

    // private method to check if a valid queue request or not.
    private boolean isValidQueueRequest(int q) {
        return 0 <= q && q < this.k;
    }

    // enqueue element x into queue number 'q'
    public void enqueue(int x, int q) {
        // return is array is full means no free space left.
        if (!isValidQueueRequest(q) || isFull()) return;

        if (isEmpty(q)) {
            // if it is the first element of the queue then assign front and rear of the queue with free position.
            this.front[q] = this.nextFree;
            this.rear[q] = this.nextFree;
        } else {
            // otherwise update the next position of the rear of the queue with next free position
            this.next[rear[q]] = this.nextFree;
            this.rear[q] = this.next[rear[q]];
        }

        // now nextFree is occupied so we need to assign the next free position to nextFree.
        this.nextFree = this.next[nextFree];

        // adding the actual element in arr and marking the next of rear is -1.
        this.arr[rear[q]] = x;
        this.next[rear[q]] = -1;
    }

    // dequeue element from queue number 'q'
    public int dequeue(int q) {
        // return -1 if queue is already empty.
        if (!isValidQueueRequest(q) || isEmpty(q)) {
            return -1;
        }

        // storing the peek of the queue in a temporary variable to return further.
        int temp = this.front[q];

        if (this.next[front[q]] == -1) {
            // if it is the last element of the queue then assign the -1 to the rear of the queue
            this.front[q] = -1;
            this.rear[q] = -1;
        } else {
            // otherwise update the front to next peek position after poll.
            this.front[q] = this.next[front[q]];
        }

        // now we got a new free position, so we need the update the free list in next array.
        this.next[temp] = this.nextFree;
        this.nextFree = temp;

        // at the end return the element to be  polled.
        return arr[temp];
    }

    // check if queue 'q' is empty
    public boolean isEmpty(int q) {
        // invalid queue request means that queue is empty.
        if (!isValidQueueRequest(q)) return true;

        // both front and rear of a queue are -1 means that queue is empty.
        return (rear[q] == -1 && front[q] == -1);
    }

    // check if array is full
    public boolean isFull() {
        // next is -1 means there is no next free position.
        return nextFree == -1;
    }
}
