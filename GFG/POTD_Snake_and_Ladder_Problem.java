package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1
 *
 * # Snake and Ladder Problem
 *
 *   Q. Given an integer n such that there is n × n Snakes and Ladders board with cells numbered from 1 to n*n, find the
 *      minimum number of dice throws required to reach cell n*n starting from cell 1.
 *
 *      Given two arrays of even length:
 *        ◦ lad[], where each pair (lad[2*i], lad[2*i + 1]) represents the start and end of a ladder.
 *        ◦ sn[], where each pair (sn[2*i], sn[2*i + 1]) represents the start and end of a snake.
 *
 *      If you land on the start cell of a snake or ladder, you must immediately move to its corresponding end cell.
 *
 *      You have complete control over the outcome of each dice throw i.e., in a single move,  you can move forward
 *      by any number of cells from 1 to 6.
 *
 *      If it is impossible to reach cell n*n, return -1.
 *
 *    Ex.
 *      Input : n = 6,
 *              lad[] = [3, 22, 5, 8, 11, 35, 20, 32],
 *              sn[] = [17, 4, 19, 7, 34, 1, 21, 9]
 *      Output: 3
 *      Explanation: For the 6 × 6 board, the minimum number of dice throws needed to reach cell 36 from cell 1 is 3.
 *                   One optimal path is:
 *                      ◦ Throw 4 to move from 1 to 5, then take the ladder to 8
 *                      ◦ Throw 3 to move from 8 to 11, then take the ladder to 35
 *                      ◦ Throw 1 to move from 35 to 36
 *                   So the destination is reached in 3 dice throws.
 *
 *  Constraints:
 *      1 ≤ n ≤ 10³
 *      1 ≤ lad.size(), sn.size(), lad[i], sn[i] ≤ n²
 */

import java.util.*;

public class POTD_Snake_and_Ladder_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("ld[]: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.print("sn[]: ");
        String[] s2 = sc.nextLine().split(" ");

        int m = s1.length;
        int[] ld = new int[m];
        for (int i = 0; i < m; i++) {
            ld[i] = Integer.parseInt(s1[i]);
        }

        m = s2.length;
        int[] sn = new int[m];
        for (int i = 0; i < m; i++) {
            sn[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("Minimum number of dice throws required to reach: n×n");
        System.out.println(minThrows(n, ld, sn));
    }

    /// Solution
    static int minThrows(int n, int[] lad, int[] snk) {
        // potd.code.hub
        int dst = n * n;
        boolean[] visited = new boolean[dst + 1];
        List<Integer>[] moves = new ArrayList[dst + 1];
        Queue<Integer> q = new ArrayDeque<>();

        int m = lad.length;
        for (int i = 0; i < m; i += 2) {
            int u = lad[i];
            int v = lad[i + 1];

            if (moves[u] == null) {
                moves[u] = new ArrayList<>();
            }

            moves[u].add(v);
        }

        m = snk.length;
        for (int i = 0; i < m; i += 2) {
            int u = snk[i];
            int v = snk[i + 1];

            if (moves[u] == null) {
                moves[u] = new ArrayList<>();
            }

            moves[u].add(v);
        }

        q.add(1);
        visited[1] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                int cur = q.poll();

                if (cur == dst) return count;

                boolean flag = true;
                int limit = Math.min(dst, cur + 6);

                for (int i = limit; i >= cur + 1; i--) {
                    List<Integer> nxt = moves[i];

                    if (nxt != null) {
                        for (int j : nxt) {
                            if (!visited[j]) {
                                visited[j] = true;
                                q.add(j);
                            }
                        }
                    } else if (flag && !visited[i]) {
                        flag = false;
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}
