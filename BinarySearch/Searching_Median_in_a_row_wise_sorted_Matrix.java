package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 *
 * # Median in a row-wise sorted Matrix
 *
 *   Q. Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd.
 *      Return the median of the matrix.
 *   Ex.
 *      Input : mat[][] = [[1, 3, 5],
 *                         [2, 6, 9],
 *                         [3, 6, 9]]
 *      Output: 5
 *      Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
 *
 *   Constraints:
 *       1 ≤ n, m ≤ 400
 *       1 ≤ mat[i][j] ≤ 2000
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Searching_Median_in_a_row_wise_sorted_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension: (row and col both must be odd)");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Enter Elements: (must be sorted row-wise)");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Median: " + median(mat));
    }

    // Solution
/*
......................................................Priority-Queue......................................................
TC : O(n * m log(n))
SC : O(n)
*/
    private static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int pq(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(p -> mat[p.r][p.c]));

        // adding first col to min-heap
        for (int i = 0; i < n; i++) {
            q.offer(new Pair(i, 0));
        }

        // there must be (n * m) / 2 smaller numbers then meadian
        int count = n * m / 2;

        // eliminating smaller numbers (technique is a little bit similar to BFS)
        while (count > 0) {
            count--;
            Pair pair = q.poll();
            pair.c++;
            if (pair.c < m) q.offer(pair);
        }

        return mat[q.peek().r][q.peek().c];
    }

/*
......................................................Binary-Search......................................................
TC : O(n log(m) * log(max - min))
SC : O(1)
*/
    static int median(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;
        int min = mat[0][0];
        int max = mat[n - 1][m - 1];
        int ans = -1;
        int medianPos = n * m / 2 + 1;

        // setting-up the search space
        for (int[] arr : mat) {
            min = Math.min(min, arr[0]);
            max = Math.max(max, arr[m - 1]);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (smallerEquals(mat, mid) >= medianPos) {
                ans = mid;
                max = mid - 1;
            } else min = mid + 1;
        }

        return ans;
    }

    // getting number of smaller or equals to target present in the array
    private static int smallerEquals(int[][] mat, int target) {
        int count = 0;

        for (int[] arr : mat) {
            count += lowerBound(arr, target + 1);
        }

        return count;
    }

    // lower bound using binary search
    private static int lowerBound(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int ans = e + 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }

        return ans;
    }
}
