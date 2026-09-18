package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 *
 * LC. 1520. Maximum Number of Non-Overlapping Substrings
 *
 *   Q. Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that
 *      meet the following conditions:
 *        ◦ The substrings do not overlap, that is for any two substrings s[i..j] and s[x..y], either j < x or i > y
 *          is true.
 *        ◦ A substring that contains a certain character c must also contain all occurrences of c.
 *
 *      Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the
 *      same number of substrings, return the one with minimum total length. It can be shown that there exists a unique
 *      solution of minimum total length.
 *
 *      Notice that you can return the substrings in any order.
 *
 *    Ex.
 *      Input : s = "adefaddaccc"
 *      Output: ["e","f","ccc"]
 *      Explanation: The following are all the possible substrings that meet the conditions:
 *                      [
 *                        "adefaddaccc"
 *                        "adefadda",
 *                        "ef",
 *                        "e",
 *                        "f",
 *                        "ccc",
 *                      ]
 *
 *                   If we choose the first string, we cannot choose anything else, and we'd get only 1.
 *                   If we choose "adefadda", we are left with "ccc" which is the only one that doesn't overlap,
 *                   thus obtaining 2 substrings.
 *
 *                   Notice also, that it's not optimal to choose "ef" since it can be split into two. Therefore,
 *                   the optimal way is to choose ["e","f","ccc"] which gives us 3 substrings. No other solution
 *                   of the same number of substrings exist.
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 10⁵
 *        ◦ s contains only lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1520_Maximum_Number_of_Non_Overlapping_Substrings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S : ");
        String s = sc.next();

        System.out.println("result: ");
        System.out.println(maxNumOfSubstrings(s));
    }

    /// Solution
    static List<String> maxNumOfSubstrings(String s1) {
        // potd.code.hub
        char[] s = s1.toCharArray();
        int n = s.length;

        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc, -1);

        // getting first and last occurrence of every character.
        for (int i = 0; i < n; i++) {
            int idx = s[i] - 'a';

            if (firstOcc[idx] == -1) {
                firstOcc[idx] = i;
            }

            lastOcc[idx] = i;
        }

        int[] validLen = new int[26];

        // checking the smallest non-overlapping valid substring.
        for (int i = n - 1; i >= 0; i--) {
            int startIdx = s[i] - 'a';
            int l = firstOcc[startIdx];
            int r = lastOcc[startIdx];

            if (l != i) continue;

            boolean flag = true;

            for (int x = i + 1; x < r; x++) {
                int idx = s[x] - 'a';

                if (firstOcc[idx] < l || validLen[idx] > 0) {
                    flag = false;
                    break;
                }

                if (lastOcc[idx] > r) {
                    r = lastOcc[idx];
                }
            }

            validLen[startIdx] = (flag) ? r - l + 1 : -1;
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (validLen[i] > 0) {
                res.add(String.valueOf(s, firstOcc[i], validLen[i]));
            }
        }

        return res;
    }
}
