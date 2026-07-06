package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-unblocked-submatrix/1
 *
 * # Largest Unblocked Submatrix
 *
 *   Q. You are given integers n and m, and an array arr[][] of size k, where arr[i] = [r, c] represents a blocked cell
 *      in an n × m grid.
 *
 *      Each blocked cell blocks its entire row and column. Find the largest continuous unblocked area in the grid.
 *
 *      Note: No two blocked cells are in the same row or the same column.
 *
 *    Ex.
 *      Input : n = 3, m = 3, k = 1, arr[][] = [[3, 3]]
 *      Output: 4
 *      Explanation: The cells (1,1), (1,2), (2,1) and (2,2) are free hence answer is 4.
 *
 *  Constraints:
 *        1 ≤ n, m ≤ 10⁴
 *        0 ≤ k ≤ min(n, m)
 *        1 ≤ r ≤ n
 *        1 ≤ c ≤ m
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Sorting_Largest_Unblocked_Submatrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("m: ");
        int m = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();
        int[][] arr = new int[k][2];

        System.out.println("Enter blocked cell positions: ");
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r <= 0 || r > n || c <= 0 || c > m) {
                throw new IllegalArgumentException("Invalid cell position");
            }

            arr[i][0] = r;
            arr[i][1] = c;
        }

        System.out.println("Size of largest continuous unblocked area in the grid: ");
        System.out.println(largestArea(n, m, k, arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-graph-traversal-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n × m)
SC : O(n × m)
*/
    static int approach_1(int n, int m, int ignored, int[][] arr) {
        // potd.code.hub
        int largestArea = 0;
        boolean[][] visited = new boolean[n][m];
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int[] blockedCell : arr) {
            row.add(blockedCell[0] - 1);
            col.add(blockedCell[1] - 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row.contains(i) || col.contains(j)) continue;
                if (visited[i][j]) continue;
                visited[i][j] = true;
                largestArea = Math.max(largestArea, getComponentSize(i, j, n, m, visited, row, col));
            }
        }

        return largestArea;
    }

    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    private static int getComponentSize(int i, int j, int n, int m, boolean[][] visited, HashSet<Integer> row, HashSet<Integer> col) {
        int count = 0;

        for (int x = 0; x < 4; x++) {
            int ni = i + dRow[x];
            int nj = j + dCol[x];
            if (0 <= ni && ni < n && 0 <= nj && nj < m && !row.contains(ni) && !col.contains(nj) && !visited[ni][nj]) {
                visited[ni][nj] = true;
                count += 1 + getComponentSize(ni, nj, n, m, visited, row, col);
            }
        }

        return count;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Sorting-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(k log k)
SC : O(k)
*/
    static int largestArea(int n, int m, int k, int[][] arr) {
        // code here
        int[] row = new int[k + 2];
        int[] col = new int[k + 2];

        row[0] = col[0] = -1;
        row[k + 1] = n;
        col[k + 1] = m;

        for (int i = 1; i <= k; i++) {
            row[i] = arr[i - 1][0] - 1;
            col[i] = arr[i - 1][1] - 1;
        }

        Arrays.sort(row);
        Arrays.sort(col);

        int maxRowGap = 0;
        int maxColGap = 0;

        for (int i = 1; i < k + 2; i++) {
            maxRowGap = Math.max(maxRowGap, row[i] - row[i - 1] - 1);
            maxColGap = Math.max(maxColGap, col[i] - col[i - 1] - 1);
        }

        return maxRowGap * maxColGap;
    }
}
