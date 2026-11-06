package LeetCode;/*
 *
 * https://leetcode.com/problems/count-zero-request-servers/
 *
 * # LC. 2747. Count Zero Request Servers
 *
 *   Q. You are given an integer n denoting the total number of servers and a 2D 0-indexed integer array logs, where
 *      logs[i] = [server_id, time] denotes that the server with id server_id received a request at time.
 *
 *      You are also given an integer x and a 0-indexed integer array queries.
 *
 *      Return a 0-indexed integer array arr of length queries.length where arr[i] represents the number of servers
 *      that did not receive any requests during the time interval [queries[i] - x, queries[i]].
 *
 *      Note that the time intervals are inclusive.
 *
 *    Ex.
 *      Input : n = 3,
 *              logs = [[1, 3],
 *                      [2, 6],
 *                      [1, 5]],
 *              x = 5,
 *              queries = [10, 11]
 *      Output: [1, 2]
 *      Explanation:
 *              For queries[0]: The servers with ids 1 and 2 get requests in the duration of [5, 10]. Hence, only
 *              server 3 gets zero requests.
 *
 *              For queries[1]: Only the server with id 2 gets a request in duration of [6,11]. Hence, the servers
 *              with ids 1 and 3 are the only servers that do not receive any requests during that time period.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 *        ◦ 1 <= logs.length <= 10⁵
 *        ◦ 1 <= queries.length <= 10⁵
 *        ◦ logs[i].length == 2
 *        ◦ 1 <= logs[i][0] <= n
 *        ◦ 1 <= logs[i][1] <= 10⁶
 *        ◦ 1 <= x <= 10⁵
 *        ◦ x < queries[i] <= 10⁶
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LeetCode_2747_Count_Zero_Request_Servers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("logs length: ");
        int len = sc.nextInt();

        int[][] logs = new int[len][2];

        System.out.println("Enter logs[]: {server_id, time}");

        for (int i = 0; i < len; i++) {
            int serverId = sc.nextInt();
            int time = sc.nextInt();

            if (serverId < 1 || serverId > n)
                throw new IllegalArgumentException("serverId must be between 1 and " + (n - 1));

            logs[i][0] = serverId;
            logs[i][1] = time;
        }

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.print("number of queries: ");
        int q = sc.nextInt();

        int[] queries = new int[q];

        System.out.print("queries: ");

        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }

        System.out.print("""
                    number of servers that did not receive any requests during
                    the time interval [queries[i] - x, queries[i]] :
                """);
        System.out.println(Arrays.toString(countServers(n, logs, x, queries)));
    }

    /// Solution
    static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // potd.code.hub
        int log_len = logs.length;
        int queries_len = queries.length;
        int[] server_status = new int[n + 1];
        Integer[] query_indices = new Integer[queries_len];

        for (int i = 0; i < queries_len; i++) {
            query_indices[i] = i;
        }

        Arrays.sort(logs, Comparator.comparingInt(l -> l[1]));
        Arrays.sort(query_indices, Comparator.comparingInt(qi -> queries[qi]));

        int l = 0;
        int r = 0;
        int server_alive = 0;
        int[] res = new int[queries_len];

        for (int i = 0; i < queries_len; i++) {
            while (r < log_len && logs[r][1] <= queries[query_indices[i]]) {
                int server_id = logs[r][0];

                if (server_status[server_id] == 0) {
                    server_alive++;
                }

                server_status[server_id]++;
                r++;
            }

            while (l < log_len && logs[l][1] < queries[query_indices[i]] - x) {
                int server_id = logs[l][0];
                server_status[server_id]--;

                if (server_status[server_id] == 0) {
                    server_alive--;
                }

                l++;
            }

            res[query_indices[i]] = n - server_alive;
        }

        return res;
    }
}
