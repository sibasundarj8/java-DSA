package SegmentTree;/*
 *
 * https://www.geeksforgeeks.org/problems/range-minimum-query/1
 *
 * # Range Minimum Query
 *
 *   Q. Given an array A[ ] and its size N your task is to complete two functions  a constructST  function which builds
 *      the segment tree  and a function RMQ which finds range minimum query in a range [a,b] of the given array.
 *
 *      Input :
 *         ◦ The task is to complete two functions constructST and RMQ.
 *
 *         ◦ The constructST function builds the segment tree and takes two arguments the array A[ ] and the size of the
 *           array N.
 *
 *         ◦ It returns a pointer to the first element of the segment tree array.
 *
 *         ◦ The RMQ function takes 4 arguments the first being the segment tree st constructed, second being the size N
 *           and then third and forth arguments are the range of query a and b. The function RMQ returns the min of the
 *           elements in the array from index range a and b. There are multiple test cases. For each test case, this
 *           method will be called individually.
 *
 *      Output:
 *         ◦ The function RMQ should return the min element in the array from range a to b.
 *
 *    Ex.
 *      Input (To be used only for expected output)
 *              1
 *              4
 *              1 2 3 4
 *              2
 *              0 2 2 3
 *      Output: 1 3
 *      Explanation:
 *              1. For query 1 ie 0 2 the element in this range are 1 2 3
 *                 and the min element is 1.
 *              2. For query 2 ie 2 3 the element in this range are 3 4
 *                 and the min element is 3.
 *
 *  Constraints:
 *        ◦ 1<=T<=100
 *        ◦ 1<=N<=10³+1
 *        ◦ 1<=A[i]<=10⁹
 *        ◦ 1<=Q(no of queries)<=10⁴
 *        ◦ 0<=a<=b
 */

public class Q03_Range_Minimum_Query {

    /// main Method
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        int q = 2;
        int[] queries = {0, 2, 2, 3};

        int[] st = constructST(arr, n);
        for (int i = 0; i < q; i++) {
            int l = queries[i << 1];
            int r = queries[(i << 1) + 1];
            System.out.println(RMQ(st, n, l, r));
        }
    }

    /// Solution
    static int[] constructST(int[] arr, int n) {
        int[] st = new int[n << 2];
        buildTree(0, 0, n - 1, arr, st);
        return st;
    }

    static int RMQ(int[] st, int n, int l, int r) {
        return getMin(0, 0, n - 1, l, r, st);
    }

    private static void buildTree(int id, int l, int r, int[] arr, int[] st) {
        // base case
        if (l == r) {
            st[id] = arr[l];
            return;
        }

        // recursive work
        int mid = (l + r) >> 1;
        buildTree((id << 1) + 1, l, mid, arr, st);
        buildTree((id << 1) + 2, mid + 1, r, arr, st);

        // self work
        st[id] = Math.min(st[(id << 1) + 1], st[(id << 1) + 2]);
    }

    private static int getMin(int id, int l, int r, int ql, int qr, int[] st) {
        // base case
        if (r < ql || qr < l) return Integer.MAX_VALUE;
        if (ql <= l && r <= qr) return st[id];

        // recursive case
        int mid = (l + r) >> 1;
        int left = getMin((id << 1) + 1, l, mid, ql, qr, st);
        int right = getMin((id << 1) + 2, mid + 1, r, ql, qr, st);

        // self work
        return Math.min(left, right);
    }
}