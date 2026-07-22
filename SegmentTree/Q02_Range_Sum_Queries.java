package SegmentTree;/*
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
 *  Expected Time Complexity: O(Q*Log(N)).
 *  Expected Auxiliary Space: O(1).
 */

public class Q02_Range_Sum_Queries {

    /// main Method
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 3, 5, 7, 9, 11};
        long[] st = new long[n << 2];
        buildTree(0, 0, n - 1, arr, st);

        System.out.println(getSum(st, n, 0, 2));
        updateValue(arr, st, n, 3, 17);
        System.out.println(getSum(st, n, 0, 5));
    }

    private static void buildTree(int id, int l, int r, int[] arr, long[] st) {
        // base case
        if (l == r) {
            st[id] = arr[l];
            return;
        }

        // recursive case
        int mid = (l + r) >> 1;
        buildTree((id << 1) + 1, l, mid, arr, st);
        buildTree((id << 1) + 2, mid + 1, r, arr, st);

        // self work
        st[id] = st[(id << 1) + 1] + st[(id << 1) + 2];
    }

    /// Solution
    static void updateValue(int[] arr, long[] st, int n, int index, int val) {
        updateValue(0, 0, n - 1, index, val, arr, st);
    }

    public static long getSum(long[] st, int n, int l, int r) {
        return getSum(0, 0, n - 1, l, r, st);
    }

    private static long getSum(int id, int l, int r, int ql, int qr, long[] st) {
        // base case
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) return st[id];

        // recursive case
        int mid = (l + r) >> 1;
        long left = getSum((id << 1) + 1, l, mid, ql, qr, st);
        long right = getSum((id << 1) + 2, mid + 1, r, ql, qr, st);

        // self word
        return left + right;
    }

    private static void updateValue(int id, int l, int r, int idx, int val, int[] arr, long[] st) {
        // base case
        if (l == r) {
            if (l == idx) {
                st[id] = val;
                arr[idx] = val;
            }
            return;
        }

        // recursive work
        int mid = (l + r) >> 1;
        if (idx <= mid) updateValue((id << 1) + 1, l, mid, idx, val, arr, st);
        else updateValue((id << 1) + 2, mid + 1, r, idx, val, arr, st);

        // self work
        st[id] = st[(id << 1) + 1] + st[(id << 1) + 2];
    }
}