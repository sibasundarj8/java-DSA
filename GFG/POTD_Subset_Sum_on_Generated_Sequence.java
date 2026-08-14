package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/tricky-subset-problem1557/1
 *
 * # Subset Sum on Generated Sequence
 *
 *    Q. There are n children standing in a queue, each assigned a number arr[i]. The teacher writes s on a paper and
 *      gives it to the first child.
 *
 *      Each child writes the sum of all numbers already on the paper and arr[i], then passes it to the next child.
 *
 *      Return true if x can be formed by adding some of the numbers written on the paper: else return false.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 4, 2], s = 1, x = 7
 *      Output: true
 *      Explanation: The first student gets 1 on paper and writes 2. The second student gets [1, 2] and writes 5.
 *                   The third student gets [1, 2, 5] and writes 12. The final sequence of numbers on the paper
 *                   is 1, 2, 5, 12, 22. Using 2 and 5 we can form 7.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁹
 *        ◦ 1 ≤ s ≤ 10⁹
 *        ◦ 0 ≤ x ≤ 10⁹
 */

import java.util.Scanner;

public class POTD_Subset_Sum_on_Generated_Sequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s1 = sc.nextLine().split(" ");

        int n = s1.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        System.out.print("s: ");
        int s = sc.nextInt();

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.print("x can be formed: ");
        System.out.println(isPossible(arr, s, x) ? "YES" : "NO");
    }

    /// Solution
    static boolean isPossible(int[] arr, int s, int x) {
        // potd.code.hub
        int n = arr.length;
        int end = n;
        long[] seq = new long[n + 1];
        long sum = seq[0] = s;

        for (int i = 0; i < n; i++) {
            seq[i + 1] = sum + arr[i];
            sum += seq[i + 1];

            if (seq[i + 1] >= x) {
                end = i + 1;
                break;
            }
        }

        for (int i = end; i >= 0; i--) {
            if (seq[i] <= x) x -= (int) seq[i];
            if (x == 0) break;
        }

        return x == 0;
    }
}
