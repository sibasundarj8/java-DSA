package SegmentTree;/*
 *
 * https://www.geeksforgeeks.org/problems/range-min-max-queries4557/1
 *
 * # Range Min Max Queries
 *
 *   Q. You are given an array of integers of size N and Q queries.
 *
 *      Your task is to complete the following functions:
 *        ◦ getMinMax(L,R): return the minimum and maximum in the given range [L,R]
 *        ◦ updateValue(index,value): update arr[index] to value.
 *
 *      Note: 0-based indexing is used.
 *
 *    Ex.
 *      Input : N = 6, Q = 3
 *              arr[] = [11, 3, 7, 5, 9, 1]
 *              queries = getMinMax(0,2)
 *                        updateValue(3,17)
 *                        getMinMax(0,5)
 *      Output:
 *              3 11
 *              1 17
 *      Explanation: There are 3 queries:
 *                      Query 1 : Min(0, 1, 2) = 3,
 *                                Max(0, 1, 2) = 11
 *                      Query 2 : 5 changes to 17, arr[] = [11, 3, 7, 17, 9, 1]
 *                      Query 3 : Min(0, 1, 2, 3, 4, 5) = 1,
 *                                Max(0, 1, 2, 3, 4, 5) = 17.
 *
 *  Constraints:
 *        1 ≤ N, Q ≤ 10⁵
 *        0 ≤ L ≤ R, index < N
 *        1 ≤ arr[i], value ≤ 10⁵
 */

import java.util.Arrays;

public class Q04_Range_Min_Max_Queries {

    /// main Method
    public static void main(String[] args) {
        int n = 6;

        int[] arr = {11, 3, 7, 5, 9, 1};
        int[][] st = constructTree(n, arr);

        int[] a = getMinMax(arr, 0, 2, st);
        updateValue(arr, 3, 17, st);
        int[] b = getMinMax(arr, 0,5, st);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    /// Solution
    static int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        // potd.code.hub
        int n = arr.length;
        return getMinMax(0, 0, n - 1, L, R, segTree).clone();
    }

    static void updateValue(int[] arr, int index, int value, int[][] segTree) {
        // potd.code.hub
        int n = arr.length;
        updateValue(0, 0, n - 1, index, value, segTree, arr);
    }

    private static int[][] constructTree(int n, int[] arr) {
        int[][] st = new int[n << 2][2];
        buildTree(0, 0, n - 1, arr, st);
        return st;
    }

    private static void buildTree(int id, int l, int r, int[] arr, int[][] st) {
        // base case
        if (l == r) {
            st[id][0] = st[id][1] = arr[l];
            return;
        }

        // recursive case
        int ll = (id << 1) + 1;
        int rr = (id << 1) + 2;
        int mid = l + ((r - l) >> 1);

        buildTree(ll, l, mid, arr, st);
        buildTree(rr, mid + 1, r, arr, st);

        // self work
        st[id][0] = Math.min(st[ll][0], st[rr][0]);
        st[id][1] = Math.max(st[ll][1], st[rr][1]);
    }

    private static int[] getMinMax(int id, int l, int r, int ql, int qr, int[][] st) {
        // base case
        if (r < ql || qr < l) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (ql <= l && r <= qr) return st[id];

        // recursive case
        int ll = (id << 1) + 1;
        int rr = (id << 1) + 2;
        int mid = l + ((r - l) >> 1);

        int[] left = getMinMax(ll, l, mid, ql, qr, st);
        int[] right = getMinMax(rr, mid + 1, r, ql, qr, st);

        // self work
        return new int[]{
                Math.min(left[0], right[0]),
                Math.max(left[1], right[1])
        };
    }

    private static void updateValue(int id, int l, int r, int idx, int val, int[][] st, int[] arr) {
        // base case
        if (l == r) {
            if (idx == r) {
                arr[idx] = val;
                st[id][0] = st[id][1] = val;
            }
            return;
        }

        // recursive case
        int mid = l + ((r - l) >> 1);
        int ll = (id << 1) + 1;
        int rr = (id << 1) + 2;

        if (idx <= mid) updateValue(ll, l, mid, idx, val, st, arr);
        else updateValue(rr, mid + 1, r, idx, val, st, arr);

        // self work
        st[id][0] = Math.min(st[ll][0], st[rr][0]);
        st[id][1] = Math.max(st[ll][1], st[rr][1]);
    }
}