package Contest.weekly_518;/*
 *
 * https://leetcode.com/contest/weekly-contest-518/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/
 *
 * # Q1_Count_Rotations_With_Exactly_K_Equal_Adjacent_Pairs. Count Rotations With Exactly K Equal Adjacent Pairs
 *
 *   Q. You are given a string s of length n and an integer k.
 *
 *      A cyclic rotation of s is obtained by choosing a prefix of s whose length is between 0 and n - 1 (inclusive),
 *      and moving it to the end of the string while preserving the order of all characters.
 *
 *      For every cyclic rotation of s, let its score be the number of indices i such that 0 <= i < n - 1 and the
 *      characters at positions i and i + 1 are equal.
 *
 *      Return the number of cyclic rotations of s whose score equals k.
 *
 *      A prefix of a string is a substring that starts from the beginning of the string and extends to any point
 *      within it.
 *
 *      A substring is a contiguous sequence of characters within a string, which may be empty.
 *
 *    Ex.
 *      Input : s = "aab", k = 1
 *      Output: 2
 *      Explanation:
 *              The cyclic rotations of s are:
 *                ◦ "aab": The characters at positions 0 and 1 are equal, so score = 1.
 *                ◦ "aba": No two adjacent characters are equal, so score = 0.
 *                ◦ "baa": The characters at positions 1 and 2 are equal, so score = 1.
 *
 *              Since score equals k for 2 cyclic rotations of s, the answer is 2.
 *
 *  Constraints:
 *        ◦ 2 <= n == s.length <= 100
 *        ◦ s only consists of lowercase English letters.
 *        ◦ 0 <= k <= n - 1
 */

public class Q1_Count_Rotations_With_Exactly_K_Equal_Adjacent_Pairs {

    /// Solution
    public int countRotations(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int score = 0;

        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == chars[i]) {
                score++;
            }
        }

        int last = n - 1;
        int count = (score == k) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (chars[last] == chars[i - 1]) score++;
            if (chars[i - 1] == chars[i]) score--;
            if (score == k) count++;
            last = i - 1;
        }

        return count;
    }
}
