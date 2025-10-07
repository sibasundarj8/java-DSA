package LeetCode;/*
 *
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 *
 * # 1488. Avoid Flood in The City
 *
 *   Q. Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains
 *      over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water,
 *      there will be a flood. Your goal is to avoid floods in any lake.
 *
 *      Given an integer array rains where:
 *       •  rains[i] > 0 means there will be rains over the rains[i] lake.
 *       •  rains[i] == 0 means there are no rains this day, and you can choose one lake this day and dry it.
 *
 *      Return an ans[] where:
 *       •  ans.length == rains.length
 *       •  ans[i] == -1 if rains[i] > 0.
 *       •  ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 *
 *      If there are multiple valid answers return any of them. If it is impossible to avoid flood return an
 *      empty array.
 *
 *      Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake,
 *       nothing changes.
 *   Ex.
 *      Input : rains = [1, 2, 0, 0, 2, 1]
 *      Output: ans[] = [-1,-1,2, 1,-1,-1]
 *      Explanation: After the first day full lakes are [1]
 *                   After the second day full lakes are [1,2]
 *                   After the third day, we dry lake 2. Full lakes are [1]
 *                   After the fourth day, we dry lake 1. There is no full lakes.
 *                   After the fifth day, full lakes are [2].
 *                   After the sixth day, full lakes are [1,2].
 *
 *              It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
 *
 * Constraints:
 *      •  1 <= rains.length <= 10⁵
 *      •  0 <= rains[i] <= 10⁹
 */

import java.util.*;

public class LeetCode_1488_Avoid_Flood_in_The_City {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rains[] ele: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] rains = new int[n];
        for (int i = 0; i < n; i++) rains[i] = Integer.parseInt(s[i]);

        System.out.println("Dry to avid Flood: ");
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    /// Solution
    // TC : O(n)
    // SC : O(n)
    static int[] avoidFlood(int[] rains) {
        int n = rains.length;

        int[] ans = new int[n];
        int[] nextZero = new int[n];
        Map<Integer, Integer> filledLake = new HashMap<>();

        nextZero[n - 1] = (rains[n - 1] == 0) ? n - 1 : n;
        for (int i = n - 2; i >= 0; i--) {
            if (rains[i] == 0) nextZero[i] = i;
            else nextZero[i] = nextZero[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) ans[i] = 1;
            else if (filledLake.containsKey(rains[i])) {
                int duplicate = filledLake.get(rains[i]);
                int[] next = {nextZero[duplicate]};  // next dry day
                update(duplicate, n, nextZero, next);// getting next dry day with path compression using DSU
                if (next[0] > i) return new int[]{}; // what if there is no dry day before today
                ans[next[0]] = rains[i];
                ans[i] = -1;
                filledLake.put(rains[i], i);
            } else {
                ans[i] = -1;
                filledLake.put(rains[i], i);
            }
        }

        return ans;
    }

    // helper method (DSU)
    private static int update(int i, int n, int[] next, int[] ans) {
        // base case
        if (i == n) return ans[0] = n;
        if (i == next[i]) {
            ans[0] = i;
            return next[i] = (i == n - 1) ? n : next[i + 1];
        }

        // recursive work and updating parent
        return next[i] = update(next[i], n, next, ans);
    }
}
