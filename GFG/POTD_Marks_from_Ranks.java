package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-marks-from-ranks/1
 *
 * # Marks from Ranks
 *
 *   Q. Consider an input where all marks obtained are divided into intervals of consecutive numbers represented as l[]
 *      and r[] where l[i] and r[i] represent the starting and ending marks (inclusive) of the i-th interval.
 *
 *      The intervals are sorted in increasing order and do not overlap.
 *
 *      The rank of a mark is defined by its position among all valid marks in increasing order, with the smallest mark
 *      assigned rank 1, the next smallest rank 2, and so on.
 *
 *      Given an array rank[]. for each value in rank[], find the corresponding mark and return as an array.
 *
 *    Ex.
 *      Input : l[] = [1, 6, 14],
 *              r[] = [3, 9, 15],
 *              rank[] = [2, 5, 8]
 *      Output: [2, 7, 14]
 *      Explanation: The valid marks are 1, 2, 3, 6, 7, 8, 9, 14, 15. Their corresponding ranks are 1 to 9 as there are
 *                   9 distinct marks. Therefore, rank 2 corresponds to mark 2, rank 5 corresponds to mark 7, and rank
 *                   8 corresponds to mark 14.
 *
 *  Constraints:
 *      1 ≤ l.size(), l[i], r.size(), r[i], rank.size(), rank[i] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class POTD_Marks_from_Ranks {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("l[]: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.print("r[]: ");
        int n = s1.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
            l[i] = Integer.parseInt(s1[i]);
        }

        sc.nextLine();

        System.out.print("rank[]: ");
        String[] s3 = sc.nextLine().split(" ");

        n = s3.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(s3[i]);
        }

        System.out.println("ans: " + getMarks(l, r, rank));
    }

    /// Solution
    static ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // potd.code.hub
        int n = l.length;
        int m = rank.length;
        ArrayList<Integer> ans = new ArrayList<>(m);

        Integer[] rankIdx = new Integer[m];
        for (int i = 0; i < m; i++) {
            rankIdx[i] = i;
            ans.add(-1);
        }

        Arrays.sort(rankIdx, Comparator.comparingInt(idx -> rank[idx]));

        int cnt = 0;
        int x = 0;
        int len, cur, idx;

        for (int i = 0; i < n; i++) {
            len = r[i] - l[i] + 1;
            cnt += len;

            while (x < m && rank[rankIdx[x]] <= cnt) {
                idx = rankIdx[x];
                cur = r[i] - cnt + rank[idx];
                ans.set(idx, cur);
                x++;
            }
        }

        return ans;
    }
}
