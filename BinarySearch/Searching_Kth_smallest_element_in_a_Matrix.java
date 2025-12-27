package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1
 *
 * # Kth smallest element in a Matrix
 *
 *   Q. Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest
 *      element in the matrix.
 *    Ex.
 *      Input : mat[][] = [[10, 20, 30, 40], k = 7
 *                         [15, 25, 35, 45],
 *                         [24, 29, 37, 48],
 *                         [32, 33, 39, 50]]
 *      Output: 30
 *      Explanation: 30 is the 7th smallest element.
 *
 *  Constraints:
 *          1 ≤ n ≤ 500
 *          1 ≤ mat[i][j] ≤ 10⁴
 *          1 ≤ k ≤ n*n
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Searching_Kth_smallest_element_in_a_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of square matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Enter Elements: (must be sorted in both row and column wise)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
                if (i > 0 && mat[i][j] < mat[i - 1][j]) return;
                if (j > 0 && mat[i][j] < mat[i][j - 1]) return;
            }
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("K th smallest element: " + kthSmallest(mat, k));
    }

    /// Solution
/*
⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ Using-PriorityQueue ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐
*/
    static int usingMinHeap(int[][] mat, int k) {
        // @sibasundarj8
        int n = mat.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> mat[a[0]][a[1]]));

        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (k-- > 1) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r + 1 < n && !vis[r + 1][c]) {
                q.add(new int[]{r + 1, c});
                vis[r + 1][c] = true;
            }
            if (c + 1 < n && !vis[r][c + 1]) {
                q.add(new int[]{r, c + 1});
                vis[r][c + 1] = true;
            }
        }

        int[] pos = q.poll();

        return mat[pos[0]][pos[1]];
    }

/*
⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ ⇒ Using-Binary-Search ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐ ⇐
*/
    static int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int i = mat[0][0];
        int j = mat[n - 1][n - 1];
        int ans = j;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int count = countSmaller(mat, mid);

            if (count >= k) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }

    private static int countSmaller(int[][] mat, int x) {
        int n = mat.length;
        int i = 0;
        int j = n - 1;
        int count = 0;

        while (i < n && j >= 0) {
            if (mat[i][j] <= x) {
                count += (j + 1);
                i++;
            } else j--;
        }

        return count;
    }
}
