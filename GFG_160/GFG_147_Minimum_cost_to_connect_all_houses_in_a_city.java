package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-connect-all-houses-in-a-city/1
 *
 * # Minimum cost to connect all houses in a city
 *
 *   Q. Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate
 *      represents the location of each house, the task is to find the minimum cost to connect
 *      all the houses of the city.
 *
 *      The cost of connecting two houses is the Manhattan Distance between the two points
 *      (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value
 *      of p.
 *   Ex.
 *      Input : n = 5
 *              houses[][] = [[ 0, 7],
 *                            [ 0, 9],
 *                            [20, 7],
 *                            [30, 7],
 *                            [40, 70]]
 *      Output: 105
 *      Explanation:
 *              Connect house 1 (0, 7) and house 2 (0, 9) with cost = 2
 *              Connect house 1 (0, 7) and house 3 (20, 7) with cost = 20
 *              Connect house 3 (20, 7) with house 4 (30, 7) with cost = 10
 *              At last, connect house 4 (30, 7) with house 5 (40, 70) with cost 73.
 *              All the houses are connected now.
 *              The overall minimum cost is 2 + 10 + 20 + 73 = 105.
 */
import java.util.PriorityQueue;

public class GFG_147_Minimum_cost_to_connect_all_houses_in_a_city {

    /// main Method
    public static void main(String[] args) {
        int[][] houses = {{ 0,  7},
                          { 0,  9},
                          {20,  7},
                          {30,  7},
                          {40, 70}};

        System.out.println(minCost(houses));
    }

    /// Solution
    static int minCost(int[][] houses) {
        // potd.code.hub
        int n = houses.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        boolean[] visited = new boolean[n];

        q.add(new Pair(0, 0));
        int sum = 0;

        while (!q.isEmpty()){
            Pair p = q.poll();
            if (visited[p.v]) continue;
            visited[p.v] = true;
            sum += p.w;
            for (int i = 0;i < n;i++){
                if (i == p.v) continue;
                if (!visited[i]){
                    int wt = weight(houses[p.v], houses[i]);
                    q.add(new Pair(i, wt));
                }
            }
        }

        return sum;
    }
    private static int weight (int[]i, int[]j){
        int x = Math.abs(i[0] - j[0]);
        int y = Math.abs(i[1] - j[1]);
        return x + y;
    }
    private static class Pair{
        int w, v;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
