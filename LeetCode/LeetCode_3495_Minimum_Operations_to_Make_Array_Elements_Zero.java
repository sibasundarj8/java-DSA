package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/
 *
 * # 3495. Minimum Operations to Make Array Elements Zero (Hard)
 *
 *   Q. You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array
 *      of integers nums consisting of elements ranging from l to r, both inclusive.
 *
 *      In one operation, you can:
 *        •  Select two integers a and b from the array.
 *        •  Replace them with floor(a / 4) and floor(b / 4).
 *
 *      Your task is to determine the minimum number of operations required to reduce all elements of the array to
 *      zero for each query. Return the sum of the results for all queries.
 *
 *   Ex.
 *      Input : queries = [[1,2],[2,4]]
 *      Output: 3
 *      Explanation:
 *          For queries[0]:
 *            •  The initial array is nums = [1, 2].
 *            •  In the first operation, select nums[0] and nums[1]. The array becomes [0, 0].
 *            •  The minimum number of operations required is 1.
 *
 *          For queries[1]:
 *            •  The initial array is nums = [2, 3, 4].
 *            •  In the first operation, select nums[0] and nums[2]. The array becomes [0, 3, 1].
 *            •  In the second operation, select nums[1] and nums[2]. The array becomes [0, 0, 0].
 *            •  The minimum number of operations required is 2.
 *            •  The output is 1 + 2 = 3.
 *
 *   Constraints:
 *      1 <= queries.length <= 105
 *      queries[i].length == 2
 *      queries[i] == [l, r]
 *      1 <= l < r <= 109
 */

import java.util.Scanner;

public class LeetCode_3495_Minimum_Operations_to_Make_Array_Elements_Zero {
    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of queries: ");
        int n = sc.nextInt();

        int[][] queries = new int[n][2];

        System.out.println("Enter Queries: ");
        for (int i = 0;i < n;i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println("Minimum operation: " + minOperations(queries));
    }

    ///  Solution
/*******************************************************Approach-1*******************************************************/
    static long minOperations(int[][] queries) {
        long ans = 0;

        for (int[] arr : queries)
            ans += numberOfOperation(arr[0], arr[1]);

        return ans;
    }

    private static long numberOfOperation(int l, int r) {
        long i = log4(l);
        long n = log4(r) - 1;
        long start = (long) Math.pow(4, i - 1);

        // return if range is in same box
        if (n < i) return (i * (r - l + 1) + 1) / 2;

        // answer first box
        long ans = i * (start * 4 - l);

        // middle answer calculated using 4 power
        while (i < n) {
            start *= 4;
            long end = start * 4;
            ans += (i + 1) * (end - start);
            i++;
        }

        // answer of last box
        ans += ((n + 1) * ((r - start) + 1));

        return (ans + 1) / 2;
    }

    private static long log4(int n) {
        return (long) (Math.log(n) / Math.log(4) + 1);
    }

/*******************************************************Approach-2*******************************************************/
    static long minOperations1(int[][] queries) {
        long ans = 0;

        for (int[] arr : queries)
            ans += minOperation(arr);

        return ans;
    }

    static long minOperation(int[] query) {
        long ans = 0;
        long begin = (long) Math.pow(4, logBase4(query[0]));
        long end = (long) Math.pow(4, logBase4(query[1]) + 1);

        while (begin < end) {
            long first = Math.max(begin, query[0]);
            long last = Math.min(query[1], begin * 4 - 1);
            ans += (logBase4(first) + 1) * ((last - first) + 1);

            begin *= 4;
        }

        return (ans + 1) / 2;
    }

    private static long logBase4(long n) {
        return (long) (Math.log(n) / Math.log(4));
    }
}
