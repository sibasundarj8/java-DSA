package SegmentTree;/*
 *
 * https://www.geeksforgeeks.org/problems/prefix-sum-range-query/1
 *
 * # Prefix Sum Range Query
 *
 *   Q. Given an array arr[] of integers and a list of q queries[][], where each query is in the form [L, R],
 *      compute the sum of elements from index L to R (both inclusive) for each query.
 *
 *    Ex.
 *      Input : arr[] = [2, 4, 6, 8, 10],
 *              queries[][] = [[1, 3],
 *                             [0, 2]]
 *      Output: [18, 12]
 *      Explanation:
 *              Query [1, 3] -> 4 + 6 + 8 = 18
 *              Query [0, 2] -> 2 + 4 + 6 = 12
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ -104 ≤ arr[i] ≤ 10⁴
 *        ◦ 1 ≤ q ≤ 10⁵
 *        ◦ 0 ≤ queries[i][j]
 *        ◦ queries.rows ≤ q
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q01_Prefix_Sum_Range_Query {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println("Enter the elements of array: ");
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Enter the number of queries: ");
        int q = Integer.parseInt(br.readLine().trim());
        int[][] queries = new int[q][2];

        System.out.println("Enter the range of queries: ");
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine().trim());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(rangeSumQueries(arr, queries).toString());
        bw.close();
        br.close();
    }

    /// Solution
    static ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        initialize(n);
        buildTree(0, 0, n - 1, arr);

        for (int[] query : queries) {
            int rangeSum = query(0, 0, n - 1, query[0], query[1]);
            res.add(rangeSum);
        }

        return res;
    }

    private static int[] t;

    private static void initialize(int size) {
        t = new int[size << 2];
    }

    private static void buildTree(int id, int l, int r, int[] arr) {
        // base case
        if (l == r) {
            t[id] = arr[l];
            return;
        }

        // recursive work
        int mid = (l + r) >> 1;
        buildTree((id << 1) + 1, l, mid, arr);
        buildTree((id << 1) + 2, mid + 1, r, arr);

        // self work
        t[id] = t[(id << 1) + 1] + t[(id << 1) + 2];
    }

    private static int query(int id, int l, int r, int ql, int qr) {
        // base case
        if (r < ql || qr < l) return 0;
        if (ql <= l && r <= qr) return t[id];

        int mid = (l + r) >> 1;
        int left = query((id << 1) + 1, l, mid, ql, qr);
        int right = query((id << 1) + 2, mid + 1, r, ql, qr);

        return left + right;
    }
}
