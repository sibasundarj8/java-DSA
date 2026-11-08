package LeetCode;/*
 *
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 * # LC. 1267. Count Servers that Communicate
 *
 *   Q. You are given a map of a server center, represented as an m * n integer matrix grid, where 1 means that on
 *      that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they
 *      are on the same row or on the same column.
 *
 *      Return the number of servers that communicate with any other server.
 *
 *    Ex.
 *      Input : grid = [[1, 1, 0, 0],
 *                      [0, 0, 1, 0],
 *                      [0, 0, 1, 0],
 *                      [0, 0, 0, 1]]
 *      Output: 4
 *      Explanation: The two servers in the first row can communicate with each other. The two servers in the third
 *                   column can communicate with each other. The server at right bottom corner can't communicate with
 *                   any other server.
 *
 *  Constraints:
 *        ◦ m == grid.length
 *        ◦ n == grid[i].length
 *        ◦ 1 <= m <= 250
 *        ◦ 1 <= n <= 250
 *        ◦ grid[i][j] == 0 or 1
 */

import java.util.Scanner;

public class LeetCode_1267_Count_Servers_that_Communicate {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("grid dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("elements: (1-servers, 0-empty cell)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = sc.nextInt();

                if (val != 1 && val != 0) {
                    throw new IllegalArgumentException("Invalid input");
                }

                grid[i][j] = val;
            }
        }

        System.out.println("number of servers that communicate with any other server:");
        System.out.println(countServers(grid));
    }

    /// Solution
    static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row = new int[n];
        int[] col = new int[m];
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                col[j] += grid[i][j];
                row[i] += grid[i][j];
                total += grid[i][j];
            }
        }

        int isolated = 0;

        for (int i = 0; i < n; i++) {
            if (row[i] == 1) {

                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        if (col[j] == 1) isolated++;
                        break;
                    }
                }

            }
        }

        return total - isolated;
    }
}
