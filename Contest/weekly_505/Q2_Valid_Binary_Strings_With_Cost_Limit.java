package Contest.weekly_505;/*
 *
 * https://leetcode.com/problems/valid-binary-strings-with-cost-limit/
 *
 * # Q2. Valid Binary Strings With Cost Limit
 *
 *   Q. You are given two integers n and k.
 *      The cost of a binary string s is defined as the sum of all indices i (0-based) such that s[i] == '1'.
 *
 *      A binary string is considered valid if:
 *        ◦ It does not contain two consecutive '1' characters.
 *        ◦ Its cost is less than or equal to k.
 *        ◦ Return a list of all valid binary strings of length n in any order.
 *
 *    Ex.
 *      Input : n = 3, k = 1
 *      Output: ["000","010","100"]
 *      Explanation:
 *              The binary strings of length 3 without consecutive '1' characters are:
 *                ◦ "000" : cost = 0
 *                ◦ "100" : cost = 0
 *                ◦ "010" : cost = 1
 *                ◦ "001" : cost = 2
 *                ◦ "101" : cost = 0 + 2 = 2
 *              Among these, the strings with cost less than or equal to k = 1 are "000", "010" and "100".
 *
 *  Constraints:
 *      1 <= n <= 12
 *      0 <= k <= n * (n - 1) / 2
 */

import java.util.ArrayList;
import java.util.List;

public class Q2_Valid_Binary_Strings_With_Cost_Limit {

    /// Solution
    public List<String> generateValidStrings(int n, int k) {
        // potd.code.hub
        List<String> ans = new ArrayList<String>();

        solve(0, 0, 0, new StringBuilder(), n, k, ans);

        return ans;
    }

    private void solve(int idx, int prev, int cost, StringBuilder sb, int n, int k, List<String> res) {
        // base case
        if (idx == n) {
            res.add(sb.toString());
            return;
        }

        // recursive work
        if (cost + idx <= k && prev != 1) {
            sb.append(1);
            solve(idx + 1, 1, cost + idx, sb, n, k, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(0);
        solve(idx + 1, 0, cost, sb, n, k, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}