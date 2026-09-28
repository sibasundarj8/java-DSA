package SegmentTree;/*
 *
 * https://www.geeksforgeeks.org/problems/range-gcd-queries3654/1
 *
 * # Range GCD Queries
 *
 *   Q. Given an integer array arr[] and a 2D array queries[][] containing q queries, where each query is one of
 *      the following two types:
 *        ◦ Type 1: [0, l, r] -> Return the GCD of all elements in the range [l, r] (both inclusive).
 *        ◦ Type 2: [1, index, value] -> Update arr[index] to value.
 *
 *      Return an array containing the answers to all Type 1 queries in the order they appear in queries[][].
 *
 *      Note: Use 0-based indexing.
 *
 *    Ex.
 *      Input : arr[] = [2, 3, 4, 6, 8, 16],
 *      q = 3,
 *      queries[][] = [[0, 0, 2],
 *                     [1, 3, 8],
 *                     [0, 2, 5]]
 *      Output: [1, 4]
 *      Explanation: Initially, arr[] = [2, 3, 4, 6, 8, 16].
 *                   Query [0, 0, 2]: Find the GCD of the subarray arr[0...2] = [2, 3, 4]. The GCD is 1.
 *                   Query [1, 3, 8]: Update arr[3] from 6 to 8. The array becomes [2, 3, 4, 8, 8, 16].
 *                   Query [0, 2, 5]: Find the GCD of the subarray arr[2...5] = [4, 8, 8, 16]. The GCD is 4.
 *                   Therefore, the answers to all Type 0 queries are [1, 4].
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ q ≤ 10⁵
 *      0 ≤ l, r, index ≤ arr.size()-1
 *      1 ≤ arr[i], value ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q07_Range_GCD_Queries {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();
        int[][] queries = new int[q][3];

        System.out.print("""
                Enter queries:
                0 --> range gcd    [0, left, right]
                1 --> update       [1, idx, val]
                """);
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        System.out.print("Result: ");
        System.out.println(processQueries(arr, queries));
    }

    /// Solution
    static ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        // pod.code.hub
        int n = arr.length;
        SegmentTree segmentTree = new SegmentTree(arr);
        ArrayList<Integer> res = new ArrayList<>();

        for (int[] query : queries) {
            switch (query[0]) {
                case 0 -> res.add(segmentTree.findRangeGCD(0, 0, n - 1, query[1], query[2]));
                case 1 -> segmentTree.updatePoint(0, 0, n - 1, query[1], query[2]);
            }
        }

        return res;
    }

    // segment tree Implementation
    private static class SegmentTree {
        private final int[] T;

        SegmentTree(int[] arr) {
            int n = arr.length;
            T = new int[n << 2];
            buildTree(0, 0, n - 1, arr);
        }

        void buildTree(int id, int l, int r, int[] arr) {
            // base case
            if (l == r) {
                T[id] = arr[l];
                return;
            }

            // recursive case
            int mid = l + ((r - l) >> 1);
            int lId = (id << 1) + 1;
            int rId = (id << 1) + 2;

            buildTree(lId, l, mid, arr);
            buildTree(rId, mid + 1, r, arr);

            // self work
            T[id] = gcd(T[lId], T[rId]);
        }

        int findRangeGCD(int id, int l, int r, int qL, int qR) {
            // base case
            if (qR < l || r < qL) return 0;
            if (qL <= l && r <= qR) return T[id];

            // recursive work
            int mid = l + ((r - l) >> 1);
            int lId = (id << 1) + 1;
            int rId = (id << 1) + 2;

            int left = findRangeGCD(lId, l, mid, qL, qR);
            int right = findRangeGCD(rId, mid + 1, r, qL, qR);

            return gcd(left, right);
        }

        void updatePoint(int id, int l, int r, int qIdx, int qVal) {
            // base case
            if (l == r) {
                T[id] = qVal;
                return;
            }

            // recursive case
            int mid = l + ((r - l) >> 1);
            int lId = (id << 1) + 1;
            int rId = (id << 1) + 2;

            if (qIdx <= mid) updatePoint(lId, l, mid, qIdx, qVal);
            else updatePoint(rId, mid + 1, r, qIdx, qVal);

            // self work
            T[id] = gcd(T[lId], T[rId]);
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int t = b;
                b = a % b;
                a = t;
            }

            return a;
        }
    }
}
