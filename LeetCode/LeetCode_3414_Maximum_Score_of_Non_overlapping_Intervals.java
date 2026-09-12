package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
 *
 * # LC. 3414. Maximum Score of Non-overlapping Intervals [HARD]
 *
 *   Q. You are given a 2D integer array intervals, where intervals[i] = [l-i, r-i, weight-i]. Interval 'i' starts at
 *      position l-i and ends at r-i, and has a weight of weight-i. You can choose up to 4 non-overlapping intervals.
 *      The score of the chosen intervals is defined as the total sum of their weights.
 *
 *      Return the lexicographically smallest array of at most 4 indices from intervals with maximum score,
 *      representing your choice of non-overlapping intervals.
 *
 *      Two intervals are said to be non-overlapping if they do not share any points. In particular, intervals sharing
 *      a left or right boundary are considered overlapping.
 *
 *    Ex.
 *      Input : intervals = [[1, 3, 2],
 *                           [4, 5, 2],
 *                           [1, 5, 5],
 *                           [6, 9, 3],
 *                           [6, 7, 1],
 *                           [8, 9, 1]]
 *      Output: [2, 3]
 *      Explanation:
 *              You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.
 *
 *  Constraints:
 *        ◦ 1 <= intevals.length <= 5 * 10⁴
 *        ◦ intervals[i].length == 3
 *        ◦ intervals[i] = [l-i, r-i, weight-i]
 *        ◦ 1 <= l-i <= r-i <= 10⁹
 *        ◦ 1 <= weight-i <= 10⁹
 */

import java.util.*;

public class LeetCode_3414_Maximum_Score_of_Non_overlapping_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of intervals: ");
        int n = sc.nextInt();

        List<List<Integer>> intervals = new ArrayList<>();

        System.out.println("Enter intervals: [start, end, weight]");
        for (int i = 0; i < n; i++) {
            List<Integer> interval = new ArrayList<>();

            interval.add(sc.nextInt());
            interval.add(sc.nextInt());
            interval.add(sc.nextInt());

            intervals.add(interval);
        }

        System.out.print("""
                lexicographically smallest array of at most 4 indices from intervals with maximum score,
                representing your choice of non-overlapping intervals:
                """);
        int[] ans = maximumWeight(intervals);
        System.out.println(Arrays.toString(ans));
    }

    /// Solution
    private static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    private static final State EMPTY = new State(0, new int[0]);

    private static int[] insertInSortedArray(int[] array, int value) {
        int n = array.length;

        if (n == 0) {
            return new int[]{value};
        }

        int[] res = new int[n + 1];
        int idx = 0;

        while (idx < n && array[idx] <= value) {
            res[idx] = array[idx++];
        }

        res[idx++] = value;

        while (idx <= n) {
            res[idx] = array[idx - 1];
            idx++;
        }

        return res;
    }

    private static int[] lexicographicallySmaller(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;

        while (i < n && j < m && a[i] == b[j]) {
            i++;
            j++;
        }

        if (i == n) return a;
        if (j == m) return b;

        return (a[i] < b[j]) ? a : b;
    }

    private static int lowerBound(int[][] temp, int i, int j, int target) {
        while (i <= j) {
            int mid = i + ((j - i) >> 1);

            if (temp[mid][0] >= target) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }

/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n log n + 4n) + extra recursive stack space
SC : O(4n)
*/
    static int[] memoization(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] temp = new int[n][4];

        for (int i = 0; i < n; i++) {
            temp[i][0] = intervals.get(i).get(0);
            temp[i][1] = intervals.get(i).get(1);
            temp[i][2] = intervals.get(i).get(2);
            temp[i][3] = i;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = lowerBound(temp, i + 1, n - 1, temp[i][1] + 1);
        }

        return solve(0, 4, n, temp, next, new State[n][5]).indices;
    }

    private static State solve(int i, int k, int n, int[][] temp, int[] next, State[][] dp) {
        // base case
        if (k == 0 || i == n) return EMPTY;
        if (dp[i][k] != null) return dp[i][k];

        // recursive case simulation
        State skip = solve(i + 1, k, n, temp, next, dp);
        State pick = solve(next[i], k - 1, n, temp, next, dp);

        long pickScore = pick.score + temp[i][2];
        int[] pickIndices;

        // self work
        State res;

        if (pickScore > skip.score) {
            pickIndices = insertInSortedArray(pick.indices, temp[i][3]);
            res = dp[i][k] = new State(pickScore, pickIndices);

        } else if (pickScore < skip.score) {
            res = dp[i][k] = skip;

        } else {
            pickIndices = insertInSortedArray(pick.indices, temp[i][3]);
            int[] ansIndices = lexicographicallySmaller(pickIndices, skip.indices);

            if (ansIndices == skip.indices) res = dp[i][k] = skip;
            else res = dp[i][k] = new State(pickScore, ansIndices);
        }

        return dp[i][k] = res;
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC : O(n log n + 4n)
SC : O(4n)
*/
    static int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] temp = new int[n][4];

        for (int i = 0; i < n; i++) {
            temp[i][0] = intervals.get(i).get(0);
            temp[i][1] = intervals.get(i).get(1);
            temp[i][2] = intervals.get(i).get(2);
            temp[i][3] = i;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = lowerBound(temp, i + 1, n - 1, temp[i][1] + 1);
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) dp[i][0] = EMPTY;
        for (int k = 0; k <= 4; k++) dp[n][k] = EMPTY;

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                // recursive case simulation
                State skip = dp[i + 1][k];
                State pick = dp[next[i]][k - 1];

                long pickScore = pick.score + temp[i][2];
                int[] pickIndices;

                // self work
                if (pickScore > skip.score) {
                    pickIndices = insertInSortedArray(pick.indices, temp[i][3]);
                    dp[i][k] = new State(pickScore, pickIndices);

                } else if (pickScore < skip.score) {
                    dp[i][k] = skip;

                } else {
                    pickIndices = insertInSortedArray(pick.indices, temp[i][3]);
                    int[] ansIndices = lexicographicallySmaller(pickIndices, skip.indices);

                    if (ansIndices == skip.indices) dp[i][k] = skip;
                    else dp[i][k] = new State(pickScore, ansIndices);
                }
            }
        }

        return dp[0][4].indices;
    }
}
