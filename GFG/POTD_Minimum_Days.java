package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-days--170646/1
 *
 * # Minimum Days
 *
 *   Q. Given a string s of length n containing only lowercase English letters, and a permutation array p[] of length
 *      n containing integers from 0 to n - 1.
 *
 *      On the (i + 1)th day, the character at index p[i] in the string is replaced with '?'. For example:
 *        ◦ On day 1, replace s[p[0]] with '?'.
 *        ◦ On day 2, replace s[p[1]] with '?'.
 *        ◦ On day 3, replace s[p[2]] with '?'.
 *        ◦ And so on.
 *
 *      Find the minimum number of days required so that no two adjacent characters in s are equal, unless at least
 *      one of them is '?'.
 *
 *      Formally, for every index i (0 <= i < n - 1), the string must satisfy: If s[i] != '?' and s[i+1] != '?',
 *      then s[i] != s[i+1].
 *
 *    Ex.
 *      Input : s = "aabb", p = [2, 1, 3, 0]
 *      Output: 2
 *      Explanation:
 *              On Day 1, we replace s[p[0]] (index 2) with '?'. String becomes "aa?b". Index 0 and 1 still have equal
 *              adjacent characters 'a'.
 *
 *              On Day 2, we replace s[p[1]] (index 1) with '?'. String becomes "a??b". Now no two adjacent non-'?'
 *              characters are equal.
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size() ≤ 10⁵
 *        ◦ 0 ≤ p[i] < s.size()
 *        ◦ s consists only of lowercase English alphabets
 *        ◦ p.size() = s.size()
 */

import java.util.Scanner;

public class POTD_Minimum_Days {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s : ");
        String s = sc.next();

        System.out.print("p[] : ");
        int n = s.length();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();

            if (val < 0 || val >= n) {
                throw new IllegalArgumentException("Invalid input");
            }

            p[i] = val;
        }

        System.out.println("Minimum number of days required so that no two adjacent characters in s are equal: ");
        System.out.println(getMinimumDays(s, p));
    }

    /// Solution
    static int getMinimumDays(String s1, int[] p) {
        // potd.code.hub
        char[] s = s1.toCharArray();
        int n = p.length;
        int time = 0;

        for (int i = 0; i < n; i++) {
            int pos = p[i];

            if ((pos > 0 && s[pos] == s[pos - 1]) || (pos < n - 1 && s[pos] == s[pos + 1])) {
                s[pos] = '?';
                time = i + 1;
            }
        }

        return time;
    }
}
