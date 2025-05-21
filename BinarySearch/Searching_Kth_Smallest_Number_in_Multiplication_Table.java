package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-smallest-number-in-multiplication-table/1
 *
 * # Kth Smallest Number in Multiplication Table
 *
 *   Q. Given three integers m, n and k. Consider a grid of m * n, where mat[i][j] = i * j (1 based index).
 *      The task is to return the kth smallest element in the m * n multiplication table.
 *
 *    Ex.
 *      Input : m = 3
 *              n = 3
 *              k = 5
 *      Output: 3
 *      Explanation:        1  2  3
 *                          2  4  6
 *                          3  6  9
 *                  -> 1, 2, 2, 3, 3, 4, 6, 6, 9
 *          The 5th smallest element is 3.
 */

import java.util.Scanner;

public class Searching_Kth_Smallest_Number_in_Multiplication_Table {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("m: ");
        int m = sc.nextByte();

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Kth smallest: " + kthSmallest(m, n, k));
    }

    /// Solution
    static int kthSmallest(int m, int n, int k) {
        // potd.code.hub
        int i = 0, j = n * m;
        int ans = j;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            boolean isPos = smaller(m, n, mid, k);

            if (!isPos) {
                i = mid + 1;
            } else {
                j = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }

    private static boolean smaller(int m, int n, int num, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, num / i);
        }
        return count >= k;
    }
}
