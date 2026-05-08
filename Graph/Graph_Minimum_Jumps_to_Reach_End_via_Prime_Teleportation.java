package Graph;/*
 *
 * https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/
 *
 * # 3629. Minimum Jumps to Reach End via Prime Teleportation
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      You start at index 0, and your goal is to reach index n - 1.
 *
 *      From any index i, you may perform one of the following operations:
 *        ◦ Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
 *        ◦ Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that
 *          nums[j] % p == 0.
 *
 *      Return the minimum number of jumps required to reach index n - 1.
 *
 *    Ex.
 *      Input : nums = [2, 3, 4, 7, 9]
 *      Output: 2
 *      Explanation:
 *              One optimal sequence of jumps is:
 *                ◦ Start at index i = 0. Take an adjacent step to index i = 1.
 *                ◦ At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9
 *                  is divisible by 3.
 *
 *              Thus, the answer is 2.
 *
 *  Constraints:
 *          1 <= n == nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁶
 */


import java.util.*;

public class Graph_Minimum_Jumps_to_Reach_End_via_Prime_Teleportation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Minimum jump to reach last position: ");
        System.out.println(minJumps(nums));
    }

    /// Solution
    private static final int SIZE = 1000001;
    private static final boolean[] sieve = new boolean[SIZE];

    static {
        sieve[0] = sieve[1] = true;
        for (int i = 2; i < SIZE; i++) {
            if (!sieve[i]) {
                for (long j = (long) i * i; j < SIZE; j += i) {
                    sieve[(int) j] = true;
                }
            }
        }
    }

    static int minJumps(int[] nums) {
        int n = nums.length;
        int step = 0;

        // pre-process prime's multiples
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> primeFactors = getPrimeFactors(nums[i]);

            for (int prime : primeFactors) {
                map.computeIfAbsent(prime, k -> new ArrayList<>()).add(i);
            }
        }

        // BFS from first
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        outer:
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int idx = q.poll();
                if (idx == n - 1) break outer;

                // can move previous element
                if (idx + 1 < n && !visited[idx + 1]) {
                    q.add(idx + 1);
                    visited[idx + 1] = true;
                }

                // can next element
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    q.add(idx - 1);
                    visited[idx - 1] = true;
                }

                // if it is prime it can move any multiple
                if (!sieve[nums[idx]]) {

                    for (int next : map.get(nums[idx])) {
                        if (!visited[next]) {
                            q.add(next);
                            visited[next] = true;
                        }
                    }

                    map.get(nums[idx]).clear();
                }
            }

            step++;
        }

        return step;
    }

    private static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        int x = 2;
        while (n > 1 && sieve[n]) {

            if (n % x == 0) {
                while (n % x == 0) n /= x;
                primeFactors.add(x);
            }

            if (x == 2) x++;
            else x += 2;
        }

        if (n > 1) primeFactors.add(n);

        return primeFactors;
    }
}
