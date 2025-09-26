package Deque;/*
 *
 * https://www.geeksforgeeks.org/problems/rotate-deque-by-k/1
 *
 * # Rotate Deque By K
 *
 *   Q. You are given a deque dq[] (double-ended queue) containing non-negative integers, along with two
 *      positive integer type and k. The task is to rotate the deque circularly by k positions.
 *
 *      There are two types of rotation operations:
 *
 *        • Right Rotation (Clockwise): If type = 1, rotate the deque to the right. This means moving the
 *          last element to the front, and repeating the process k times.
 *
 *        • Left Rotation (Anti-Clockwise): If type = 2, rotate the deque to the left. This means moving
 *          the first element to the back, and repeating the process k times.
 *
 *    Ex.
 *      Input : dq = [10, 20, 30, 40, 50], type = 2, k = 3
 *      Output: [40, 50, 10, 20, 30]
 *      Explanation: The type is 2 and k is 3. So, we need to left rotate dequeue by 3 times.
 *                   In first left rotation we get [20, 30, 40, 50, 10].
 *                   In second left rotation we get [30, 40, 50, 10, 20].
 *                   In third left rotation we get [40, 50, 10, 20, 30].
 *
 *  Constraints:
 *          1 ≤ dq.size() ≤ 10⁵
 *          1 ≤ k ≤ 10⁵
 *          1 ≤ type ≤ 2
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DQ_02_Rotate_Deque_By_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();

        System.out.println("Insert elements in Deque: ");
        String[] s = sc.nextLine().split(" ");
        Arrays.stream(s).forEach(x -> dq.add(Integer.parseInt(x)));

        System.out.println("""
                Enter type:
                 •  1 : clockwise
                 •  2 : anti-clockwise
                >>>""");
        int type = sc.nextInt();

        System.out.print("K: ");
        int k = sc.nextInt();

        rotateDeque(dq, type, k);

        System.out.println("After rotation:\n" + dq);
    }

    /// Solution
    static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // potd.code.hub
        int n = dq.size();
        k %= n;

        if (k * 2 > n) {
            k = n - k;
            type = (type % 2) + 1;
        }

        switch (type) {
            case 1: {
                rotateClockwise(dq, k);
                break;
            }
            case 2: {
                rotateAntiClockwise(dq, k);
                break;
            }
        }
    }

    // Rotating clockwise
    private static void rotateClockwise(Deque<Integer> dq, int k) {
        while (k-- > 0) dq.addFirst(dq.pollLast());
    }

    // Rotating anti-clockwise
    private static void rotateAntiClockwise(Deque<Integer> dq, int k) {
        while (k-- > 0) dq.addLast(dq.pollFirst());
    }
}
