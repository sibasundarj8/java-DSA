package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/steps-by-knight5927/1
 *
 * # Min Steps by Knight
 *
 *   Q. Given a square chessboard of size n × n, the initial position knightPos and target position targetPos of a
 *      Knight are given. Find the minimum number of moves required for the Knight to reach targetPos.
 *
 *      A Knight moves in an L-shape, covering 2 cells in one direction and 1 cell perpendicular to it.
 *      From (x, y), it can move to: (x ± 2, y ± 1) and (x ± 1, y ± 2)
 *
 *      Note: The positions are given using 1-based indexing.
 *
 *    Ex.
 *      Input : n = 3,
 *              knightPos[] = [3, 3],
 *              targetPos[]= [1, 2]
 *      Output: 1
 *      Explanation: Knight takes 1 step to reach from (3, 3) to (1 ,2).
 *
 *  Constraints:
 *        ◦ n ≤ 1000
 *        ◦ 2 ≤ knightPos.size(), targetPos.size() ≤ 2
 *        ◦ 1 ≤ knightPos[i], targetPos[i] ≤ n
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Graph_Min_Steps_by_Knight {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter positions in 1-based indexing.");
        System.out.print("Start pos: ");
        int[] knightPos = {sc.nextInt(), sc.nextInt()};

        System.out.print("Target pos: ");
        int[] targetPos = {sc.nextInt(), sc.nextInt()};

        System.out.print("Chess board size: ");
        int n = sc.nextInt();

        if (knightPos[0] > n || knightPos[1] > n || targetPos[0] > n || targetPos[1] > n) {
            throw new IllegalArgumentException("Invalid input!!");
        }

        System.out.println("Minimum number of moves required to reach target position: ");
        System.out.println(minStepToReachTarget(knightPos, targetPos, n));
    }

    /// Solution
    private static final int[] dRow = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static final int[] dCol = {-1, 1, 2, 2, 1, -1, -2, -2};

    static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
        // potd.code.hub
        int count = 0;
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Long> q = new ArrayDeque<>();

        long node = ((long) knightPos[0] << 32) | knightPos[1];
        q.add(node);
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                node = q.poll();
                long r = node >> 32;
                long c = node & 0xFFFFFFFFL;

                if (r == targetPos[0] && c == targetPos[1]) {
                    return count;
                }

                for (int x = 0; x < 8; x++) {
                    long nr = r + dRow[x];
                    long nc = c + dCol[x];

                    if (0 < nr && nr <= n && 0 < nc && nc <= n && !visited[(int) nr][(int) nc]) {
                        visited[(int) nr][(int) nc] = true;
                        q.add((nr << 32) | nc);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}
