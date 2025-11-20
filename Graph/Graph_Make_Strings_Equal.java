package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/make-strings-equal--150209/1
 *
 * # Make Strings Equal
 *
 *   Q. Given two strings s and t, consisting of lowercase English letters. You are also given, a 2D array transform[][],
 *      where each entry [x, y] means that you are allowed to transform character x into character y and an array cost[],
 *      where cost[i] is the cost of transforming transform[i][0] into transform[i][1]. You can apply any transformation
 *      any number of times on either string.
 *
 *      Your task is to find the minimum total cost required to make the strings identical. If it is impossible to make
 *      the two strings identical using the available transformations, return -1.
 *
 *    Ex.
 *      Input : s = "az",
 *              t = "dc",
 *              transform[][] = [['a', 'b'],
 *                               ['b', 'c'],
 *                               ['c', 'd'],
 *                               ['a', 'd'],
 *                               ['z', 'c']],
 *              cost[] = [5, 3, 2, 50, 10]
 *      Output: 20
 *      Explanation: We can convert both strings into "dc" with a cost of 20 using these operations:
 *                   transform at Position 0 in s: a -> d by path a -> b -> c -> d (cost 5 + 3 + 2 = 10)
 *                   transform at Position 1 in s: z -> c (cost 10)
 *
 *  Constraints:
 *          1 ≤ s.size() = t.size() ≤ 10⁵
 *          1 ≤ transform.size() = cost.size() ≤ 500
 *          'a' ≤ transform[i][0], transform[i][1] ≤ 'z'
 *          1 ≤ cost[i] ≤ 500
 */

public class Graph_Make_Strings_Equal {

    /// main Method
    public static void main(String[] args) {
        String s = "ehhefje";
        String t = "jjjiegh";

        char[][] transform = {
                {'f', 'e'},
                {'i', 'h'},
                {'f', 'i'},
                {'j', 'i'},
                {'g', 'f'},
                {'i', 'e'},
                {'f', 'f'},
                {'e', 'i'},
                {'f', 'j'},
                {'h', 'j'},
        };
        int[] cost = {3, 13, 14, 14, 10, 5, 8, 1, 6, 5};

        System.out.println("Minimum cost to make Identical: " + minCost(s, t, transform, cost));
    }

    /// Solution
    public static int minCost(String s, String t, char[][] transform, int[] cost) {
        // potd.code.hub
        int n = s.length();
        int totalCost = 0;
        int[][] adjMat = constructAdjMatrix(transform, cost);
        floydWarshall(adjMat);

        for (int i = 0; i < n; i++) {
            int src = s.charAt(i) - 'a';
            int dst = t.charAt(i) - 'a';
            int total = (int) 1e8;

            for (int x = 0; x < 26; x++) {
                int tar1 = adjMat[src][x];
                int tar2 = adjMat[dst][x];

                if (tar1 != 1e8 && tar2 != 1e8) total = Math.min(total, tar1 + tar2);
            }

            if (total == 1e8) return -1;
            totalCost += total;
        }

        return totalCost;
    }

    // getting shortest path from every node to another node using Floyd Warshall 
    // multi source shortest path finding algorithm.
    private static void floydWarshall(int[][] adjMatrix) {
        int n = 26;

        for (int via = 0; via < n; via++) {
            for (int u = 0; u < n; u++) {
                if (adjMatrix[u][via] == 1e8) continue;

                for (int v = 0; v < n; v++) {
                    if (adjMatrix[via][v] == 1e8) continue;

                    adjMatrix[u][v] = Math.min(adjMatrix[u][v], adjMatrix[u][via] + adjMatrix[via][v]);
                }
            }
        }
    }

    // constructing adjacency matrix.
    private static int[][] constructAdjMatrix(char[][] transform, int[] cost) {
        int n = transform.length;
        int[][] adjMat = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                adjMat[i][j] = (i == j) ? 0 : (int) 1e8;
            }
        }

        for (int i = 0; i < n; i++) {
            int u = transform[i][0] - 'a';
            int v = transform[i][1] - 'a';
            adjMat[u][v] = Math.min(adjMat[u][v], cost[i]);
        }

        return adjMat;
    }
}
