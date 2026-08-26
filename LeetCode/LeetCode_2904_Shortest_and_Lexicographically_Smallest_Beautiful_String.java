package LeetCode;/*
 *
 * https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 *
 * # LC. 2904. Shortest and Lexicographically Smallest Beautiful String
 *
 *   Q. You are given a binary string s and a positive integer k.
 *
 *      A substring of s is beautiful if the number of 1's in it is exactly k.
 *
 *      Let len be the length of the shortest beautiful substring.
 *
 *      Return the lexicographically smallest beautiful substring of string s with length equal to len. If s doesn't
 *      contain a beautiful substring, return an empty string.
 *
 *      A string 'a' is lexicographically larger than a string b (of the same length) if in the first position where
 *      a and b differ, a has a character strictly larger than the corresponding character in b.
 *
 *      For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the
 *      fourth character, and d is greater than c.
 *
 *    Ex.
 *      Input : s = "100011001", k = 3
 *      Output: "11001"
 *      Explanation: There are 7 beautiful substrings in this example:
 *                      1. The substring "100011001".
 *                      2. The substring "100011001".
 *                      3. The substring "100011001".
 *                      4. The substring "100011001".
 *                      5. The substring "100011001".
 *                      6. The substring "100011001".
 *                      7. The substring "100011001".
 *                   The length of the shortest beautiful substring is 5.
 *                   The lexicographically smallest beautiful substring with length 5 is the substring "11001".
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 100
 *        ◦ 1 <= k <= s.length
 */

import java.util.Scanner;

public class LeetCode_2904_Shortest_and_Lexicographically_Smallest_Beautiful_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Lexicographically smallest beautiful substring: ");
        System.out.println(shortestBeautifulSubstring(s, k));
    }

    /// Solution
/*
-------------------------------------------------------brute-force---------------------------------------------------------
TC : 𝛳(n²) average case
SC : O(1)
*/
    static String bruteForce(String s, int k) {
        int curLen;
        Boolean smaller;
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean found = false;
        int firstIdx = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int x = firstIdx;
            smaller = null;

            if (chars[i] == '0') continue;

            for (int j = i; j < n; j++) {
                if (chars[j] == '1') count++;

                if (chars[x] != chars[j] && smaller == null) {
                    smaller = chars[j] < chars[x];
                }

                if (count == k) {
                    curLen = j - i + 1;

                    if (curLen < len) {
                        firstIdx = i;
                        len = curLen;
                    } else if (curLen == len && smaller != null && smaller) {
                        firstIdx = i;
                        len = curLen;
                    }

                    found = true;
                    break;
                }

                x++;
            }
        }

        if (!found) return "";
        return String.valueOf(chars, firstIdx, len);
    }

/*
-----------------------------------------------------sliding-window-----------------------------------------------------
TC : O(n²) worst case
SC : O(1)
*/
    static String shortestBeautifulSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int count = 0;
        int resFirstIdx = -1;
        int resLen = -1;

        for (int right = 0; right < n; right++) {
            if (chars[right] == '1') count++;
            if (count < k) continue;

            // shrinking the window
            while (chars[left] == '0' || count > k) {
                count -= (chars[left] - '0');
                left++;
            }

            int len = right - left + 1;

            if ((resFirstIdx == -1) || (len < resLen) || (len == resLen && isSmaller(chars, resFirstIdx, left, resLen))) {
                resFirstIdx = left;
                resLen = right - left + 1;
            }
        }

        return resFirstIdx == -1 ? "" : String.valueOf(chars, resFirstIdx, resLen);
    }

    private static boolean isSmaller(char[] chars, int oldStart, int newStart, int len) {
        for (int i = 0; i < len; i++) {
            if (chars[oldStart + i] != chars[newStart + i]) {
                return chars[newStart + i] < chars[oldStart + i];
            }
        }

        return false;
    }
}
