package PriorityQueue;/* 
 *
 * https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
 *
 * # LC. 1606. Find Servers That Handled Most Number of Requests
 *
 *   Q. You have k servers numbered from 0 to k-1 that are being used to handle multiple requests simultaneously.
 *      Each server has infinite computational capacity but cannot handle more than one request at a time.
 *
 *      The requests are assigned to servers according to a specific algorithm:
 *        ◦ The ith (0-indexed) request arrives.
 *        ◦ If all servers are busy, the request is dropped (not handled at all).
 *        ◦ If the (i % k)th server is available, assign the request to that server.
 *        ◦ Otherwise, assign the request to the next available server (wrapping around the list of servers and
 *          starting from 0 if necessary). For example, if the ith server is busy, try to assign the request to
 *          the (i+1)th server, then the (i+2)th server, and so on.
 *
 *      You are given a strictly increasing array arrival of positive integers, where arrival[i] represents the
 *      arrival time of the ith request, and another array load, where load[i] represents the load of the i-th
 *      request (The time it takes to complete.) Your goal is to find the busiest server(s).
 *
 *      A server is considered busiest if it handled the most number of requests successfully among all the servers.
 *
 *      Return a list containing the IDs (0-indexed) of the busiest server(s). You may return the IDs in any order.
 *
 *    Ex.
 *      Input : k = 3,
 *              arrival = [1, 2, 3, 4, 5],
 *              load = [5, 2, 3, 3, 3]
 *      Output: [1]
 *      Explanation:
 *              All the servers start out available.
 *              The first 3 requests are handled by the first 3 servers in order.
 *              Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.
 *              Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped.
 *              Servers 0 and 2 handled one request each, while server 1 handled two requests.
 *              Hence, server 1 is the busiest server.
 *
 *  Constraints:
 *        ◦ 1 <= k <= 10⁵
 *        ◦ 1 <= arrival.length, load.length <= 10⁵
 *        ◦ arrival.length == load.length
 *        ◦ 1 <= arrival[i], load[i] <= 10⁹
 *        ◦ arrival is strictly increasing.
 */

import java.util.*;

public class PQ_Find_Servers_That_Handled_Most_Number_of_Requests {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("k: ");
        int k = sc.nextInt();

        sc.nextLine();

        System.out.print("arrival[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arrivals = new int[n];
        int[] load = new int[n];

        System.out.print("load[] : ");
        for (int i = 0; i < n; i++) {
            arrivals[i] = Integer.parseInt(s[i]);
            load[i] = sc.nextInt();
        }

        System.out.print("Busiest servers: ");
        System.out.println(busiestServers(k, arrivals, load));
    }

    /// Solution
    static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // potd.code.hub
        TreeSet<Integer> free = new TreeSet<>();
        PriorityQueue<Long> busy = new PriorityQueue<>(Long::compareUnsigned);
        /*
         * Busy queue should store finish_time and server_id and must sort based on finish_time.
         * so I use a bit-packing technique to pack finish_time and server_id in a single long.
         * left most 46 bit represent finish_time and right most 17 bit for server_id.
         */

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        int n = arrival.length;
        int max = 0;
        long mask = (1L << 18) - 1;
        int[] requestCount = new int[k];

        for (int i = 0; i < n; i++) {
            int task_start_time = arrival[i];
            int task_finish_time = task_start_time + load[i];
            int server_id = i % k;

            // free the servers from busy queue
            while (!busy.isEmpty() && busy.peek() >>> 18 <= task_start_time) {
                free.add((int) (busy.poll() & mask));
            }

            // now all free servers are in free queue, use the required one
            if (!free.isEmpty()) {
                Integer nextFreeServerId = free.ceiling(server_id);

                if (nextFreeServerId == null) {
                    nextFreeServerId = free.first();
                }

                free.remove(nextFreeServerId);
                busy.add((((long) task_finish_time << 18) | nextFreeServerId));

                requestCount[nextFreeServerId]++;
                max = Math.max(max, requestCount[nextFreeServerId]);
            }
        }

        List<Integer> busiestServerIds = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (requestCount[i] == max) {
                busiestServerIds.add(i);
            }
        }

        return busiestServerIds;
    }
}
