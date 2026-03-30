package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-connect-all-houses-in-a-city/1
 *
 * # Minimum cost to connect all houses in a city
 *
 *   Q. Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location
 *      of each house, the task is to find the minimum cost to connect all the houses of the city.
 *
 *      The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e.,
 *      |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.
 *
 *    Ex.
 *      Input : n = 5 houses[][] = [[0, 7], [0, 9], [20, 7], [30, 7], [40, 70]]
 *      Output: 105
 *      Explanation:
 *              Connect house 1 (0, 7) and house 2 (0, 9) with cost = 2
 *              Connect house 1 (0, 7) and house 3 (20, 7) with cost = 20
 *              Connect house 3 (20, 7) with house 4 (30, 7) with cost = 10
 *              At last, connect house 4 (30, 7) with house 5 (40, 70) with cost 73.
 *              All the houses are connected now.
 *              The overall minimum cost is 2 + 10 + 20 + 73 = 105.
 *                                                                           (40,70)
 *                                                                              5
 *                                                                              |
 *                                                                             73
 *                                                                              |
 *                                                                   (20,7)     4 (30,7)
 *                                                                       3 -----+
 *                                                                        \     10
 *                                                                         \
 *                             Edge weights:                               20
 *                             1 --2--> 2                                   \
 *                             1 --20--> 3                                   1 (0,7)
 *                             3 --10--> 4                                    \
 *                             4 --73--> 5                                     2
 *                                                                           (0,9)
 *  Constraint:
 *          1 ≤ n ≤ 10³
 *          0 ≤ houses[i][j] ≤ 10³
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph_Minimum_cost_to_connect_all_houses_in_a_city {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of houses: ");
        int n = sc.nextInt();

        int[][] houses = new int[n][2];

        System.out.println("Enter the positions of houses: ");
        for (int i = 0; i < n; i++) {
            houses[i][0] = sc.nextInt();
            houses[i][1] = sc.nextInt();
        }

        System.out.println("Minimum cost to join all the houses: ");
        System.out.println(minCost(houses));
    }

    /// Solution
    static int minCost(int[][] houses) {
        // potd.code.hub
        int n = houses.length;
        int sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
        boolean[] visited = new boolean[n];

        // 0th house with total sum 0
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;

            if (visited[u]) continue;

            sum += cur.wt;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (v != u){
                    int wt = getManhattanDistance(houses[cur.v][0], houses[cur.v][1], houses[v][0], houses[v][1]);
                    pq.add(new Node(v, wt));
                }
            }
        }

        return sum;
    }

    private static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private record Node(int v, int wt) {}
}
