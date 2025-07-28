package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/ascii-range-sum/1
 *
 * # ASCII Range Sum
 *
 *   Q. Given a string s consisting of lowercase English letters, for every character whose first and last
 *      occurrences are at different positions, calculate the sum of ASCII values of characters strictly
 *      between its first and last occurrence.
 *      Return all such non-zero sums (order does not matter).
 *   Ex.
 *      Input: s = "abacab"
 *      Output: [293, 294]
 *      Explanation: characters 'a' and 'b' appear more than once:
 *                   'a' : between positions 1 and 5 → characters are b, a, c and ascii sum is 98 + 97 + 99 = 294.
 *                   'b' : between positions 2 and 6 → characters are a, c, a and ascii sum is 97 + 99 + 97 = 293.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q03_ASCII_Range_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = sc.next();

        System.out.println("ASCII range: " + asciiRange(s));
    }

    /// Solution
    private static class Occurrence {
        int first, last, fSum, lSum;
    }

    static ArrayList<Integer> asciiRange(String s) {
        // potd.code.hub
        int n = s.length();
        int sum = 0;
        Occurrence[] freq = new Occurrence[26];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            sum += s.charAt(i);

            if (freq[idx] == null) {
                freq[idx] = new Occurrence();
                freq[idx].first = i;
                freq[idx].fSum = sum;
            }

            freq[idx].last = i;
            freq[idx].lSum = sum;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (freq[i] != null && freq[i].first != freq[i].last) {
                sum = freq[i].lSum - (97 + i) - freq[i].fSum;
                if (sum != 0) ans.add(sum);
            }
        }

        return ans;
    }
}
