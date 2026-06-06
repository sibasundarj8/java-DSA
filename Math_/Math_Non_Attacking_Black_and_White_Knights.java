package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/black-and-white-1587115620/1
 *
 * # Non-Attacking Black and White Knights
 *
 *   Q. Given two integers n and m representing the dimensions of a chessboard, find the number of ways to place one black
 *      knight and one white knight on the chessboard such that they cannot attack each other.
 *
 *      Note:
 *          ◦ The knights have to be placed on different squares.
 *          ◦ A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically
 *            and one square horizontally (L shaped).
 *          ◦ The knights attack each other if one can reach the other in one move.
 *
 *    Ex.
 *      Input : n = 2, m = 3
 *      Output: 26
 *      Explanation: There are 26 ways we can place a black and a white Knight on this chessboard such that they cannot
 *                   attack each other.
 *
 *  Constraints:
 *          1 ≤ n * m ≤ 45000
 */

import java.util.Scanner;

public class Math_Non_Attacking_Black_and_White_Knights {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of chess board: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println("number of ways to place two different knights such that they cannot attack each other: ");
        System.out.println(numOfWays(n, m));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--Counting-Valid-Knight-Moves--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n * m)
SC : O(1)
*/
    static int approach_1(int n, int m) {
        // potd.code.hub
        int totalCells = n * m;
        int count = 0;
        int[] dr = {1, -1, -2, -2, -1, 1, 2, 2};
        int[] dc = {-2, -2, -1, 1, 2, 2, 1, -1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int canAttack = 1;

                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (0 <= nr && nr < n && 0 <= nc && nc < m)
                        canAttack++;
                }

                count += (totalCells - canAttack);
            }
        }

        return count;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--Mathematical-Formula--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(1)
SC : O(1)
*/
    static int numOfWays(int n, int m) {
        long total_cells = (long) n * m;
        long total_ways = (total_cells - 1) * total_cells;

        // check if the board is large enough to hold at-least one block
        long number_of_2_by_3_blocks = (n >= 2 && m >= 3) ? (n - 1L) * (m - 2L) : 0;
        long number_of_3_by_2_blocks = (n >= 3 && m >= 2) ? (n - 2L) * (m - 1L) : 0;

        // Every 2×3 and 3×2 block can hold 4 different positions which attack each other.
        long total_red_zoned_blocks = (number_of_2_by_3_blocks + number_of_3_by_2_blocks) * 4;

        return (int) (total_ways - total_red_zoned_blocks);
    }
}
