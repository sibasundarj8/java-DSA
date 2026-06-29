package Contest.biWeekly_185;/*
 *
 * https://leetcode.com/contest/biweekly-contest-185/problems/finish-time-of-tasks-i/
 *
 * # Q3. Finish Time of Tasks I
 *
 *   Q. You are given an integer n representing the number of tasks in a project, numbered from 0 to n - 1. These tasks
 *      are connected as a tree rooted at task 0. This is represented by a 2D integer array edges of length n - 1, where
 *      edges[i] = [u_i, v_i] indicates that task u_i is the parent of task v_i.
 *
 *      You are also given an array baseTime of length n, where baseTime[i] represents the time to complete task i.
 *
 *      The finish time of each task is calculated as follows:
 *        ◦ Leaf task: The finish time is baseTime[i].
 *        ◦ Non-leaf task:
 *            ⎯ Let earliest be the minimum finish time among its children, and latest be the maximum finish time among
 *               its children.
 *            ⎯ Let ownDuration be (latest - earliest) + baseTime[i].
 *            ⎯ The finish time of task 'i' is latest + ownDuration.
 *
 *      Return the finish time of the root task 0.
 *
 *    Ex.
 *      Input : n = 3, edges = [[0, 1], [0, 2]], baseTime = [4, 7, 6]
 *      Output: 12
 *      Explanation:         0(4)
 *                          /    \
 *                       1(7)    2(6)
 *
 *              ◦ Task 1 is a leaf, so its finish time is baseTime[1] = 7.
 *              ◦ Task 2 is a leaf, so its finish time is baseTime[2] = 6.
 *              ◦ Task 0 has two children with finish times 7 and 6:
 *                  ⎯ earliest = 6, latest = 7
 *                  ⎯ ownDuration = (latest - earliest) + baseTime[0] = (7 - 6) + 4 = 5
 *                  ⎯ Finish time of task 0 is latest + ownDuration = 7 + 5 = 12
 *
 *  Constraints:
 *    ◦ 1 <= n <= 10⁵
 *    ◦ edges.length = n - 1
 *    ◦ edges[i] == [u_i, v_i]
 *    ◦ 0 <= u_i, v_i <= n - 1
 *    ◦ u_i != v_i
 *    ◦ The input is generated such that edges represents a valid tree.
 *    ◦ baseTime.length == n
 *    ◦ 1 <= baseTime[i] <= 10⁵
 */

import java.util.ArrayList;

public class Q3_Finish_Time_of_Tasks_I {

    /// Solution
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        // potd.code.hub
        int numberOfNodes = edges.length + 1;
        ArrayList<ArrayList<Integer>> adjacencyList = mapToAdjList(edges);
        boolean[] visited = new boolean[numberOfNodes];
        visited[0] = true;


        return solve(0, visited, baseTime, adjacencyList);
    }

    private long solve(int curr, boolean[] visited, int[] baseTime, ArrayList<ArrayList<Integer>> adjacencyList) {
        long time = baseTime[curr];
        long earliest = Long.MAX_VALUE; // min child
        long latest = Long.MIN_VALUE;   // max child

        for (int next : adjacencyList.get(curr)) {
            if (!visited[next]) {
                visited[next] = true;
                long childTime = solve(next, visited, baseTime, adjacencyList);
                earliest = Math.min(earliest, childTime);
                latest = Math.max(latest, childTime);
            }
        }

        if (earliest == Long.MAX_VALUE) earliest = 0;
        if (latest == Long.MIN_VALUE) latest = 0;
        time += (latest - earliest);

        return latest + time;
    }

    private ArrayList<ArrayList<Integer>> mapToAdjList(int[][] edges) {
        int numberOfNodes = edges.length + 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++)
            res.add(new ArrayList<>());

        for (int[] edge : edges) {
            res.get(edge[0]).add(edge[1]);
            res.get(edge[1]).add(edge[0]);
        }

        return res;
    }
}