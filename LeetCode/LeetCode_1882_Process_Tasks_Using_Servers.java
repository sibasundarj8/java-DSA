package LeetCode;/*
 *
 * https://leetcode.com/problems/process-tasks-using-servers/
 *
 * # LC. 1882. Process Tasks Using Servers
 *
 *   Q. You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively.
 *      servers[i] is the weight of the i-th server, and tasks[j] is the time needed to process the j-th
 *      task in seconds.
 *
 *      Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the
 *      queue is empty.
 *
 *      At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at
 *      second 0). As long as there are free servers and the queue is not empty, the task in the front of
 *      the queue will be assigned to a free server with the smallest weight, and in case of a tie, it is
 *      assigned to a free server with the smallest index.
 *
 *      If there are no free servers and the queue is not empty, we wait until a server becomes free and
 *      immediately assign the next task. If multiple servers become free at the same time, then multiple
 *      tasks from the queue will be assigned in order of insertion following the weight and index priorities
 *      above.
 *
 *      A server that is assigned task j at second t will be free again at second t + tasks[j].
 *
 *      Build an array ans of length m, where ans[j] is the index of the server the j-th task will be assigned to.
 *
 *      Return the array ans.
 *
 *    Ex.
 *      Input : servers = [5, 1, 4, 3, 2],
 *              tasks = [2, 1, 2, 4, 5, 2, 1]
 *      Output: [1, 4, 1, 4, 1, 3, 2]
 *      Explanation: Events in chronological order go as follows:
 *           - At second 0, task 0 is added and processed using server 1 until second 2.
 *           - At second 1, task 1 is added and processed using server 4 until second 2.
 *           - At second 2, servers 1 and 4 become free. Task 2 is added and processed using server 1 until second 4.
 *           - At second 3, task 3 is added and processed using server 4 until second 7.
 *           - At second 4, server 1 becomes free. Task 4 is added and processed using server 1 until second 9.
 *           - At second 5, task 5 is added and processed using server 3 until second 7.
 *           - At second 6, task 6 is added and processed using server 2 until second 7.
 *
 *  Constraints:
 *        ◦ servers.length == n
 *        ◦ tasks.length == m
 *        ◦ 1 <= n, m <= 2 * 10⁵
 *        ◦ 1 <= servers[i], tasks[j] <= 2 * 10⁵
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCode_1882_Process_Tasks_Using_Servers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("server: ");
        String[] s1 = sc.nextLine().split(" ");

        int n = s1.length;
        int[] servers = new int[n];
        for (int i = 0; i < n; i++) {
            servers[i] = Integer.parseInt(s1[i]);
        }

        System.out.print("tasks: ");
        String[] s2 = sc.nextLine().split(" ");

        int n2 = s2.length;
        int[] tasks = new int[n2];

        for (int i = 0; i < n2; i++) {
            tasks[i] = Integer.parseInt(s2[i]);
        }

        int[] res = assignTasks(servers, tasks);

        System.out.println("server assigned tasks: " + Arrays.toString(res));
    }

    /// Solution
    static int[] assignTasks(int[] servers, int[] tasks) {
        // potd.code.hub
        int n = servers.length;

        PriorityQueue<Node> free = new PriorityQueue<>((a, b) -> {
            if (a.wt == b.wt) return a.id - b.id;
            return a.wt - b.wt;
        });

        PriorityQueue<Node> occupied = new PriorityQueue<>(Comparator
                .comparingLong(node -> node.free_time));

        for (int i = 0; i < n; i++) {
            free.add(new Node(i, servers[i]));
        }

        int m = tasks.length;
        int[] result = new int[m];
        long cur_time = 0;

        for (int i = 0; i < m; i++) {
            if (free.isEmpty() && cur_time < occupied.peek().free_time) {
                cur_time = occupied.peek().free_time;
            } else cur_time = Math.max(cur_time, i);

            while (!occupied.isEmpty() && occupied.peek().free_time <= cur_time) {
                free.add(occupied.poll());
            }

            if (!free.isEmpty()) {
                Node server = free.poll();
                server.free_time = cur_time + tasks[i];
                occupied.add(server);
                result[i] = server.id;
            } else {
                cur_time = occupied.peek().free_time;
                i--;
            }
        }

        return result;
    }

    private static class Node {
        int id;
        int wt;
        long free_time;

        Node(int id, int wt) {
            this.id = id;
            this.wt = wt;
            this.free_time = 0;
        }
    }
}
