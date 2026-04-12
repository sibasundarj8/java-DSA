package Contest.Weekly_497;/*
 *
 * https://leetcode.com/contest/weekly-contest-497/problems/find-the-degree-of-each-vertex/
 *
 * # Q1. Find the Degree of Each Vertex
 *
 *   Q. You are given a 2D integer array matrix of size n x n representing the adjacency matrix of an undirected graph with
 *      n vertices labeled from 0 to n - 1.
 *
 *      matrix[i][j] = 1 indicates that there is an edge between vertices i and j.
 *      matrix[i][j] = 0 indicates that there is no edge between vertices i and j.
 *      The degree of a vertex is the number of edges connected to it.
 *
 *      Return an integer array 'ans' of size n where ans[i] represents the degree of vertex i.
 *
 *      Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
 *
 *    Ex.                                                       0
 *                                                            /   \
 *      Input : matrix = [[0,1,1],[1,0,1],[1,1,0]]           1 ⎯⎯ 2
 *      Output: [2,2,2]
 *      Explanation:
 *              Vertex 0 is connected to vertices 1 and 2, so its degree is 2.
 *              Vertex 1 is connected to vertices 0 and 2, so its degree is 2.
 *              Vertex 2 is connected to vertices 0 and 1, so its degree is 2.
 *              Thus, the answer is [2, 2, 2].
 *
 *            Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
 */

public class Q1_Find_the_Degree_of_Each_Vertex {

    /// Solution
    public int[] findDegrees(int[][] mat) {
        int n = mat.length;
        int[] degree = new int[n];

        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (mat[i][j] == 1) {
                    degree[i]++;
                    degree[j]++;
                }
            }
        }

        return degree;
    }
}
