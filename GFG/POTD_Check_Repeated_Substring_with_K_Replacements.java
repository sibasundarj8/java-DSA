package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/check-if-a-string-is-repetition-of-its-substring-of-k-length3302/1
 * 
 * # Check Repeated Substring with K Replacements
 *
 *   Q. Given a string s and an integer k, check if it is possible to convert s to a string that is repetition of a
 *      substring with k characters else returns false. In order to convert we can replace one substring of length k
 *      with any k characters.
 *
 *    Ex.
 *      Input : s = "abcbedabcabc",
 *              k = 3
 *      Output: true
 *      Explanation: Replace "bed" with "abc" so that the whole string becomes repetition of "abc".
 *
 *  Constraints:
 *      2 ≤ k ≤ s.size() ≤ 10⁵
 */

import java.util.HashMap;
import java.util.Scanner;

public class POTD_Check_Repeated_Substring_with_K_Replacements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("can we convert this in such a string which can be divided equal k length substrings : ");
        System.out.println(kSubstr(s, k));
    }

    /// Solution
    static boolean kSubstr(String s, int k) {
        // potd.code.hub
        int n = s.length();

        if (n % k != 0) return false;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i += k) {
            String temp = s.substring(i, i + k);
            map.put(temp, map.getOrDefault(temp, 0) + 1);

            if (map.size() > 2) return false;
        }

        for (int freq : map.values()) {
            if (freq == 1) return true;
        }

        return (map.size() == 1);
    }
}
