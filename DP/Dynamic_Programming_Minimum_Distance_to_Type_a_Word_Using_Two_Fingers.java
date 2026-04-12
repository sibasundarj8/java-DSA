package DP;/*
 *
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
 *
 * # 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 *   Q. You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter is located at some
 *      coordinate.
 *
 *      For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate (0, 1), the
 *      letter 'P' is located at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
 *
 *      Given the string word, return the minimum total distance to type such string using only two fingers.
 *
 *      The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.
 *
 *      Note that the initial positions of your two fingers are considered free so do not count towards your total distance,
 *      also your two fingers do not have to start at the first letter or the first two letters.
 *
 *    Ex.
 *      Input: word = "HAPPY"
 *      Output: 6
 *      Explanation: Using two fingers, one optimal way to type "HAPPY" is:
 *                    ◦ Finger 1 on letter 'H' -> cost = 0
 *                    ◦ Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
 *                    ◦ Finger 2 on letter 'P' -> cost = 0
 *                    ◦ Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
 *                    ◦ Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
 *
 *                   Total distance = 6
 *
 *  Constraints:
 *          2 <= word.length <= 300
 *          word consists of uppercase English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Minimum_Distance_to_Type_a_Word_Using_Two_Fingers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = sc.next();

        System.out.println("Minimum distance: ");
        System.out.println(minimumDistance(word));
    }

    /// Solution
/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-common-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
*/
    private static final int[][] keyboard = new int[27][2];

    static {
        int a = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (a > 26) break;
                keyboard[a][0] = i;
                keyboard[a][1] = j;
                a++;
            }
        }
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Memoization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n * 26 * 26)
SC : O(n * 26 * 26) + recursive stack space
*/
    static int memoization(String word) {
        int n = word.length();
        int[][][] dp = new int[n][27][27];

        for (int[][] mat : dp) {
            for (int[] arr : mat) {
                Arrays.fill(arr, -1);
            }
        }

        return rec(0, 0, 0, n, word, dp);
    }

    private static int rec(int idx, int finger1, int finger2, int n, String word, int[][][] dp) {
        // base case
        if (idx == n) return 0;
        if (dp[idx][finger1][finger2] != -1) return dp[idx][finger1][finger2];

        // recursive case
        int cur = word.charAt(idx) - 'A' + 1;
        int f1 = rec(idx + 1, cur, finger2, n, word, dp) + distanceMemo(finger1, cur);
        int f2 = rec(idx + 1, finger1, cur, n, word, dp) + distanceMemo(finger2, cur);

        return dp[idx][finger1][finger2] = Math.min(f1, f2);
    }

    private static int distanceMemo(int prev, int curr) {
        if (prev == 0 || curr == 0) return 0;
        int[] p = keyboard[prev];
        int[] c = keyboard[curr];

        return Math.abs(p[0] - c[0]) + Math.abs(p[1] - c[1]);
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Tabulation-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n * 26 * 26)
SC : O(n * 26 * 26)
*/
    static int tabulation(String word) {
        int n = word.length();
        int[][][] dp = new int[n+1][27][27];

        for (int idx = n-1; idx >= 0; idx--) {
            for (int finger1 = 26; finger1 >= 0; finger1--) {
                for (int finger2 = 26; finger2 >= 0; finger2--) {

                    int cur = word.charAt(idx) - 'A' + 1;
                    int f1 = dp[idx + 1][cur][finger2] + distanceTab(finger1, cur);
                    int f2 = dp[idx + 1][finger1][cur] + distanceTab(finger2, cur);

                    dp[idx][finger1][finger2] = Math.min(f1, f2);

                }
            }
        }

        return dp[0][0][0];
    }

    private static int distanceTab(int prev, int curr) {
        if (prev == 0 || curr == 0) return 0;
        int[] p = keyboard[prev];
        int[] c = keyboard[curr];

        return Math.abs(p[0] - c[0]) + Math.abs(p[1] - c[1]);
    }

/*
◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦-Space-Optimization-◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦◦
TC : O(n * 26 * 26)
SC : O(26 * 26)
*/
    static int minimumDistance(String word) {
        int n = word.length();
        int[][] curr = new int[27][27];
        int[][] next = new int[27][27];

        for (int idx = n-1; idx >= 0; idx--) {
            for (int finger1 = 26; finger1 >= 0; finger1--) {
                for (int finger2 = 26; finger2 >= 0; finger2--) {

                    int cur = word.charAt(idx) - 'A' + 1;
                    int f1 = next[cur][finger2] + distance(finger1, cur);
                    int f2 = next[finger1][cur] + distance(finger2, cur);

                    curr[finger1][finger2] = Math.min(f1, f2);
                }
            }
            int[][] temp = curr;
            curr = next;
            next = temp;
        }

        return next[0][0];
    }

    private static int distance(int prev, int curr) {
        if (prev == 0 || curr == 0) return 0;
        int[] p = keyboard[prev];
        int[] c = keyboard[curr];

        return Math.abs(p[0] - c[0]) + Math.abs(p[1] - c[1]);
    }
}
