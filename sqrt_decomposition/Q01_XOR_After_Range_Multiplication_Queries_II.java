package sqrt_decomposition;/*
 *
 * https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/
 *
 * # 3655. XOR After Range Multiplication Queries II (LeetCode HARD)
 *
 *   Q. You are given an integer array nums of length n and a 2D integer array queries of size q,
 *      where queries[i] = [li, ri, ki, vi].
 *
 *      For each query, you must apply the following operations in order:
 *        ● Set idx = li.
 *        ● While idx <= ri:
 *            ○ Update: nums[idx] = (nums[idx] * vi) % (109 + 7).
 *            ○ Set idx += ki.
 *
 *      Return the bitwise XOR of all elements in nums after processing all queries.
 *
 *  Ex.
 *      Input : nums = [2, 3, 1, 5, 4],
 *              queries = [[1, 4, 2, 3], [0, 2, 1, 2]]
 *      Output: 31
 *      Explanation:
 *              The first query [1, 4, 2, 3] multiplies the elements at indices 1 and 3 by 3,
 *              transforming the array to [2, 9, 1, 15, 4].
 *
 *              The second query [0, 2, 1, 2] multiplies the elements at indices 0, 1, and 2 by 2,
 *              resulting in [4, 18, 2, 15, 4].
 *
 *              Finally, the XOR of all elements is 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31.
 *
 *  Constraints:
 *        ◦  1 <= n == nums.length <= 10⁵
 *        ◦  1 <= nums[i] <= 10⁹
 *        ◦  1 <= q == queries.length <= 10⁵
 *        ◦  queries[i] = [li, ri, ki, vi]
 *        ◦  0 <= li <= ri < n
 *        ◦  1 <= ki <= n
 *        ◦  1 <= vi <= 10⁵
 */

import java.util.*;

public class Q01_XOR_After_Range_Multiplication_Queries_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter number of queries: ");
        int m = sc.nextInt();

        int[][] queries = new int[m][4];

        System.out.println("""
                Enter queries in form of [L  R  K  V] :
                  L -> starting position (0 <= L < n)
                  R -> ending position (1 <= R < n)
                  K -> increment index by k steps (1 <= K <= n)
                  V -> value to be multiplied
                """);

        for (int i = 0; i < m; i++) {
            System.out.print("query " + (i + 1) + ": ");
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
            queries[i][3] = sc.nextInt();
        }

        System.out.println("bitwise XOR of all elements in array after processing all queries: ");
        System.out.println(xorAfterQueries(arr, queries));
    }

    /// Solution
    private final static int mod = (int) (1e9 + 7);

    static int xorAfterQueries(int[] nums, int[][] queries) {
        // potd.code.hub
        int n = nums.length;
        int xor = 0;
        int chunkSize = (int) Math.ceil(Math.sqrt(n));
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        // processing the query if k is large and storing the query in map if k is small.
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            if (k >= chunkSize) {
                // processing independent queries
                for (int i = l; i <= r; i += k) {
                    nums[i] = mul(nums[i], v);
                }
            } else {
                // setting longer queries for batch processing
                map.computeIfAbsent(k, key -> new ArrayList<>()).add(query);
            }
        }

        // processing the small k queries which we stored in map
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            int jump = entry.getKey();
            long[] diff = new long[n];
            Arrays.fill(diff, 1);

            // update difference for bulk update
            for (int[] query : entry.getValue()) {
                int l = query[0];
                int r = query[1];
                int v = query[3];

                diff[l] = mul(diff[l], v);

                int noOfJumps = (r - l) / jump;
                int last = l + (noOfJumps + 1) * jump;
                if (last < n) {
                    diff[last] = mul(diff[last], modInverse(v));
                }
            }

            // cumulative product
            for (int i = jump; i < n; i++) {
                diff[i] = mul(diff[i - jump], diff[i]);
            }

            // update nums array
            for (int i = 0; i < n; i++) {
                nums[i] = mul(nums[i], diff[i]);
            }
        }

        // calculating xor
        for (int ele : nums) {
            xor ^= ele;
        }

        return xor;
    }

    private static int mul(long a, long b) {
        return (int) ((a * b) % mod);
    }

    private static int modInverse(int x) {
        return pow(x, mod - 2);
    }

    private static int pow(int a, int n) {
        // base case
        if (n == 0) return 1;
        if (n == 1) return a;

        int half = pow(a, n / 2);
        int res = mul(half, half);

        if (n % 2 == 1) return mul(res, a);
        else return res;
    }
}
