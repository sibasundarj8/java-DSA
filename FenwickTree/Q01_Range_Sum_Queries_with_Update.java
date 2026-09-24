package FenwickTree;/*
 *
 * https://www.geeksforgeeks.org/problems/range-sum-queries2353/1
 *
 * # Range Sum Queries
 *
 *   Q. You are given an array arr[] of size N and Q queries.
 *        ◦ getSum(L,R):  return the sum of range [L,R]
 *        ◦ updateValue(index,value): update arr[index] to value.
 *
 *      You need to calculate the answer for Type-1 queries and do the update in the segment tree for Type-2 queries.
 *
 *      Note: 0-based indexing is used.
 *
 *    Ex.
 *      Input : N = 6, Q = 3
 *              arr[] = {1, 3, 5, 7, 9, 11}
 *              Queries = getSum(0, 2)
 *                        updateValue(3, 17)
 *                        getSum(0, 5)
 *      Output: 9
 *              46
 *      Explanation: There are 3 queries:
 *                     ◦ Query 1: 1 + 3 + 5 = 9
 *                     ◦ Query 2: 7 changes to 17
 *                     ◦ Query 3: 1 + 3 + 5 + 17 + 9 + 11= 46
 *
 *  Constraints:
 *        ◦ 1 ≤ n, q ≤ 10⁵, where n is the size of the array
 *        ◦ 1 ≤ arr[i], value ≤ 10⁴
 *        ◦ 0 ≤ l ≤ r < n
 *        ◦ 0 ≤ index < n
 *
 *  Expected Time Complexity: O(Q*Log(N)).
 *  Expected Auxiliary Space: O(1).
 */

import java.util.ArrayList;

public class Q01_Range_Sum_Queries_with_Update {

    /// main Method
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int[][] queries = {
                {1, 0, 2},
                {2, 3, 17},
                {1, 0, 5}
        };

        System.out.println("ans: " + rangeSumQueries(arr, queries));
    }

    /// Solution
    private static class FenwickTree {
        private final int[] BIT;
        private final int N;

        public FenwickTree(int[] arr) { // O(n)
            N = arr.length + 1;
            BIT = new int[N];

            for (int i = 1; i < N; i++) {
                BIT[i] = BIT[i - 1] + arr[i - 1];
            }

            for (int i = N - 1; i > 0; i--) {
                int idx = i - (i & -i);
                BIT[i] -= BIT[idx];
            }
        }

        void update(int idx, int val) { // O(log n)
            while (idx < N) {
                BIT[idx] += val;
                idx += (idx & -idx); // adding 1 to the least significant set bit.
            }
        }

        int query(int l, int r) { // O(2log n)
            return getPrefixSum(r) - getPrefixSum(l - 1);
        }

        int getPrefixSum(int idx) { // (log n)
            if (idx == 0) return 0;
            int ans = 0;

            while (idx > 0) {
                ans += BIT[idx];
                idx -= (idx & -idx); // setting least significant set bit 0.
            }

            return ans;
        }
    }

    static ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        // pod.code.hub
        FenwickTree ft = new FenwickTree(arr);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) { // O(q log n)
            switch (query[0]) {
                case 1 -> ans.add(ft.query(query[1] + 1, query[2] + 1));
                case 2 -> {
                    int idx = query[1];
                    int val = query[2];
                    ft.update(idx + 1, -arr[idx] + val);
                    arr[idx] = val;
                }
            }
        }

        return ans;
    }
}
