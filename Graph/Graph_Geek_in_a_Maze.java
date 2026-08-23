package Graph;/* 
 *
 * https://www.geeksforgeeks.org/problems/geek-in-a-maze--170637/1
 *
 * # Geek in a Maze
 *
 *   Q. Given a maze mat[][] of size n × m, where each cell is either:
 *            ◦ '.' representing an empty cell, or
 *            ◦ '#' representing an obstacle.
 *
 *      Geek starts from the cell (r, c). In one move, he can move to any of the four adjacent cells (up, down, left,
 *      or right), provided the destination cell lies inside the maze and is not an obstacle. Geek can make at most u
 *      upward moves and at most d downward moves. There is no limit on the number of left or right moves.
 *
 *      Return the number of distinct empty cells that Geek can visit. If the starting cell is an obstacle, return 0.
 *
 *    Ex.
 *      Input : r = 1, c = 0, u = 1, d = 1,
 *              mat = [['.', '.', '.'],             . . .
 *                     ['.', '#', '.'],             . # .
 *                     ['#', '.', '.']]             # . .
 *      Output: 5
 *      Explanation: Geek starts from (1, 0) and follows the path (1,0)->(0,0)->(0,1)->(0,2)->(1,2). The cells (1,1)
 *                   and (2,0) are obstacles, so they cannot be visited. Hence, Geek can visit 5 distinct empty cells.
 *
 *  Constraints:
 *        ◦ 1 ≤ n * m ≤ 10⁶
 *        ◦ 0 ≤ r, c < 10⁶
 *        ◦ 0 ≤ u, d ≤ 10⁶
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class Graph_Geek_in_a_Maze {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of maze: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] maze = new char[n][m];

        System.out.print("""
                Enter maze data:
                  ◦ '.' representing an empty cell, or
                  ◦ '#' representing an obstacle.
                """);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.next().charAt(0);
                if (maze[i][j] != '#' && maze[i][j] != '.') {
                    throw new IllegalArgumentException("only . and # are allowed");
                }
            }
        }

        System.out.print("r: ");
        int r = sc.nextInt();

        System.out.print("c: ");
        int c = sc.nextInt();

        System.out.print("u: ");
        int u = sc.nextInt();

        System.out.print("d: ");
        int d = sc.nextInt();

        int res = numberOfCells(r, c, u, d, maze);
        System.out.println("Geek can reach " + res + " cells.");
    }

    /// Solution
    private static class Pair {
        int up;
        int down;
        public Pair(int up, int down) {
            this.up = up;
            this.down = down;
        }
    }

    static int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;

        if (r >= n || c >= m || mat[r][c] == '#') {
            return 0;
        }

        Pair[][] delta = new Pair[n][m];
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                delta[i][j] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }

        delta[r][c].up = 0;
        delta[r][c].down = 0;
        queue.add(new int[]{r, c, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[2] > u || cur[3] > d) continue;

            for (int x = 0; x < 4; x++) {
                int nr = cur[0] + dRow[x];
                int nc = cur[1] + dCol[x];
                int up = cur[2];
                int down = cur[3];

                if (0 <= nr && nr < n && 0 <= nc && nc < m && mat[nr][nc] != '#') {

                    if (x == 0) up++;
                    else if (x == 2) down++;

                    if (delta[nr][nc].up <= up) continue;
                    if (delta[nr][nc].down <= down) continue;

                    if (x == 0 || x == 2) {
                        queue.addLast(new int[]{nr, nc, up, down});
                    } else {
                        queue.addFirst(new int[]{nr, nc, up, down});
                    }

                    delta[nr][nc].up = up;
                    delta[nr][nc].down = down;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (delta[i][j].up <= u && delta[i][j].down <= d) {
                    count++;
                }
            }
        }

        return count;
    }
}
