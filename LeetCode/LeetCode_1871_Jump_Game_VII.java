package LeetCode;/*
 *
 * https://leetcode.com/problems/jump-game-vii/
 *
 * # 1871. Jump Game VII
 *
 *   Q. You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing
 *      at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:
 *        ◦ i + minJump <= j <= min(i + maxJump, s.length - 1), and
 *        ◦ s[j] == '0'.
 *
 *      Return true if you can reach index s.length - 1 in s, or false otherwise.
 *
 *    Ex.
 *      Input : s = "011010", minJump = 2, maxJump = 3
 *      Output: true
 *      Explanation:
 *              In the first step, move from index 0 to index 3.
 *              In the second step, move from index 3 to index 5.
 *
 *  Constraints:
 *      2 <= s.length <= 10⁵
 *      s[i] is either '0' or '1'.
 *      s[0] == '0'
 *      1 <= minJump <= maxJump < s.length
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1871_Jump_Game_VII {
    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 0 indexed string: ");
        String s = sc.next();

        System.out.println("Min jump : ");
        int minJump = sc.nextInt();

        System.out.println("Max jump : ");
        int maxJump = sc.nextInt();

        System.out.println("Can reach last index starting from first index : ");
        System.err.println(canReach(s, minJump, maxJump) ? "YES" : "NO");
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-Graph-Traversal-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n²) worst case
SC : O(n)

Reason:
- We store all reachable '0' indices.
- For each index, we may scan many future indices.
*/
    static boolean bruteForce(String s, int minJump, int maxJump) {
        // potd.code.hub
        int n = s.length();
        List<Integer> list = new ArrayList<>();

        if (s.charAt(0) != '0' || s.charAt(n - 1) != '0') {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                list.add(i);
            }
        }

        int len = list.size();
        boolean[] visited = new boolean[len];
        visited[0] = true;

        for (int i = 0; i < len; i++) {
            if (visited[i]) {

                for (int x = i + 1; x < len; x++) {
                    int dist = list.get(x) - list.get(i);

                    if (dist < minJump) continue;
                    if (dist > maxJump) break;
                    if (list.get(x) == n - 1) return true;

                    visited[x] = true;
                }

            }
        }

        return false;
    }

/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-DP-Memoization-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒

TC : O(n²)
SC : O(n)

Reason:
- Each index is computed once.
- Each computation may scan up to O(n) next states.
- Recursion stack + memo array consume linear space.
*/
    static boolean memoization(String s, int minJump, int maxJump) {
        // potd.code.hub
        int n = s.length();
        Boolean[] dp = new Boolean[n];

        return dfs(0, n, s, minJump, maxJump, dp);
    }

    private static boolean dfs(int src, int n, String s, int minJump, int maxJump, Boolean[] dp) {
        // base case
        if (src == n - 1) return true;
        if (dp[src] != null) return dp[src];

        // recursive work
        int target = Math.min(n - 1, src + maxJump);

        for (int i = src + minJump; i <= target; i++) {
            if (s.charAt(i) == '0' && dp[i] == null && dfs(i, n, s, minJump, maxJump, dp)) {
                return dp[src] = true;
            }
        }

        return dp[src] = false;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Difference-Array-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(n)

Reason:
- Every index is processed once.
- Reachability propagation is done using O(1) range updates.
- Prefix sum tracks active reachable ranges.
*/
    static boolean canReach(String s, int minJump, int maxJump) {
        // potd.code.hub
        int n = s.length();
        int[] reachable = new int[n + 1];

        if (s.charAt(0) != '0' || s.charAt(n - 1) != '0') {
            return false;
        }

        reachable[minJump]++;
        reachable[maxJump + 1]--;

        for (int i = minJump; i < n; i++) {
            reachable[i] += reachable[i - 1];

            if (i + minJump >= n) continue;

            if (s.charAt(i) == '0' && reachable[i] > 0) {
                int rangeI = i + minJump;
                int rangeJ = Math.min(n - 1, i + maxJump);

                reachable[rangeI]++;
                reachable[rangeJ + 1]--;
            }
        }

        return reachable[n - 1] > 0;
    }
}
