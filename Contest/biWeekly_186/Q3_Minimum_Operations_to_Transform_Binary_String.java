package Contest.biWeekly_186;/*
 *
 * https://leetcode.com/contest/biweekly-contest-186/problems/minimum-operations-to-transform-binary-string/
 *
 * # Q3. Minimum Operations to Transform Binary String
 *
 *   Q. You are given two binary strings s1 and s2 of the same length n.
 *
 *      You can perform the following operations on s1 any number of times, in any order:
 *        ◦ Choose an index i such that s1[i] is '0' and change it to '1'.
 *        ◦ Choose an index i such that 0 <= i < n - 1, and both s1[i] and s1[i + 1] are '1'. Change both
 *          characters to '0'.
 *
 *      Return the minimum number of operations required to make s1 equal to s2. If it is impossible to make s1 equal
 *      to s2, return -1.
 *
 *    Ex.
 *      Input : s1 = "01", s2 = "10"
 *      Output: 3
 *      Explanation:
 *              Change index 0 from '0' to '1', so "01" becomes "11".
 *              Change indices 0 and 1 from '1' to '0', so "11" becomes "00".
 *              Change index 0 from '0' to '1', so "00" becomes "10".
 *              Thus, the answer is 3.
 *
 *  Constraints:
 *      1 <= n == s1.length == s2.length <= 10⁵
 *      s1 and s2 consist only of '0' and '1'.
 */

public class Q3_Minimum_Operations_to_Transform_Binary_String {

    /// Solution
    public int minOperations(String s1, String s2) {
        int n = s1.length();

        if (n == 1 && !s1.equals(s2) && s1.charAt(0) == '1') return -1;

        int ops = 0;

        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 == '0' && ch2 == '1') ops++;
            else if (ch1 == '1' && ch2 == '0') {
                if (i < n - 1 && s1.charAt(i + 1) == '1' && s2.charAt(i + 1) == '0') {
                    ops++;
                    i++;
                }
                else ops += 2;
            }
        }

        return ops;
    }
}