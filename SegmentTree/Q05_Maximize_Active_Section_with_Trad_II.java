package SegmentTree;/*
 *
 * https://leetcode.com/problems/maximize-active-section-with-trade-ii/
 *
 * # LC. 3501. Maximize Active Section with Trade II
 *
 *   Q. You are given a binary string s of length n, where:
 *        ◦ '1' represents an active section.
 *        ◦ '0' represents an inactive section.
 *
 *      You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
 *        ◦ Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
 *        ◦ Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
 *
 *      Additionally, you are given a 2D array queries, where queries[i] = [lₗ, rₗ] represents a substring s[lₗ...rₗ].
 *
 *      For each query, determine the maximum possible number of active sections in s after making the optimal trade on
 *      the substring s[lₗ...rₗ].
 *
 *      Return an array answer, where answer[i] is the result for queries[i].
 *
 *      Note:
 *        ◦ For each query, treat s[lₗ...rₗ] as if it is augmented with a '1' at both ends,
 *          forming t = '1' + s[lₗ...rₗ] + '1'. The augmented '1's do not contribute to the final count.
 *        ◦ The queries are independent of each other.
 *
 *    Ex.
 *      Input : s = "1000100",
 *              queries = [[1, 5],
 *                         [0, 6],
 *                         [0 ,4]]
 *      Output: [6,7,2]
 *      Explanation:
 *            ◦ Query [1, 5] → Substring "00010" → Augmented to "1000101"
 *              Choose "00010", convert "00010" → "00000" → "11111".
 *              The final string without augmentation is "1111110". The maximum number of active sections is 6.
 *
 *            ◦ Query [0, 6] → Substring "1000100" → Augmented to "110001001"
 *              Choose "000100", convert "000100" → "000000" → "111111".
 *              The final string without augmentation is "1111111". The maximum number of active sections is 7.
 *
 *            ◦ Query [0, 4] → Substring "10001" → Augmented to "1100011"
 *              Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 2.
 *
 *  Constraints:
 *       ◦ 1 <= n == s.length <= 10⁵
 *       ◦ 1 <= queries.length <= 10⁵
 *       ◦ s[i] is either '0' or '1'.
 *       ◦ queries[i] = [lₗ, rₗ]
 *       ◦ 0 <= lₗ <= rₗ < n
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q05_Maximize_Active_Section_with_Trad_II {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        System.out.println("Enter the binary string: ");
        String s = br.readLine().trim();

        System.out.println("Enter number of queries: ");
        int q = Integer.parseInt(br.readLine().trim());
        int[][] queries = new int[q][2];

        System.out.println("Enter range queries: ");
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine().trim());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(maxActiveSectionsAfterTrade(s, queries).toString());
        bw.close();
    }

    /// Solution
    static List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int size = s.length();
        int zeroCount = 0;
        int oneCount = 0;
        List<Integer> start = new ArrayList<>(); // starting position of a block of zeros
        List<Integer> end = new ArrayList<>();   // ending position of a block of zeros

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '0') {
                if (zeroCount == 0) start.add(i);
                zeroCount++;
            } else {
                if (zeroCount != 0) end.add(i - 1);
                zeroCount = 0;
                oneCount++;
            }
        }
        if (zeroCount != 0) end.add(size - 1);

        if (start.size() <= 1) { // no more blocks to calculate
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                res.add(oneCount);
            }
            return res;
        }

        int n = start.size() - 1;
        int[] pairSum = new int[n]; // consecutive pair sum

        for (int i = 0; i < n; i++) {
            pairSum[i] = size(i, start, end) + size(i + 1, start, end);
        }

        int[] st = new int[n << 2]; // segment tree
        buildTree(0, 0, n - 1, pairSum, st);

        List<Integer> res = new ArrayList<>(); // store result array

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int firstBlockId = lowerBound(end, l, n + 1);
            int lastBlockId = upperBound(start, r, n + 1);
            int maxPairSum = 0;

            if (firstBlockId < lastBlockId) {
                int firstBlock = end.get(firstBlockId) - Math.max(start.get(firstBlockId), l) + 1;
                int lastBlock = Math.min(r, end.get(lastBlockId)) - start.get(lastBlockId) + 1;

                if (lastBlockId - firstBlockId == 1) { // exactly 2 blocks
                    maxPairSum = firstBlock + lastBlock;
                } else {
                    int firstPair = firstBlock + size(firstBlockId + 1, start, end);
                    int lastPair = lastBlock + size(lastBlockId - 1, start, end);
                    int remaining = query(0, 0, n - 1, firstBlockId + 1, lastBlockId - 2, st);
                    maxPairSum = Math.max(firstPair, Math.max(lastPair, remaining));
                }
            }

            res.add(maxPairSum + oneCount);
        }

        return res;
    }

    private static int upperBound(List<Integer> list, int target, int n) {
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (list.get(mid) <= target) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }

    private static int lowerBound(List<Integer> list, int target, int n) {
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (list.get(mid) >= target) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }

    private static int size(int i, List<Integer> start, List<Integer> end) {
        return end.get(i) - start.get(i) + 1;
    }

    private static void buildTree(int id, int l, int r, int[] arr, int[] st) {
        // base case
        if (l == r) {
            st[id] = arr[l];
            return;
        }

        // recursive case
        int mid = l + ((r - l) >> 1);
        int ll = (id << 1) + 1;
        int rr = (id << 1) + 2;

        buildTree(ll, l, mid, arr, st);
        buildTree(rr, mid + 1, r, arr, st);

        // self work
        st[id] = Math.max(st[ll], st[rr]);
    }

    private static int query(int id, int l, int r, int ql, int qr, int[] st) {
        // base case
        if (r < ql || qr < l) return Integer.MIN_VALUE;
        if (ql <= l && r <= qr) return st[id];

        // recursive case
        int mid = l + ((r - l) >> 1);
        int ll = (id << 1) + 1;
        int rr = (id << 1) + 2;

        int left = query(ll, l, mid, ql, qr, st);
        int right = query(rr, mid + 1, r, ql, qr, st);

        // self work
        return Math.max(left, right);
    }
}