package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/choose-and-swap0531/1
 *
 * # Choose and Swap
 *
 *   Q. Given a string s of lowercase English letters, you can swap all occurrences of any two distinct characters at most
 *      once. Return the lexicographically smallest string after this operation.
 *
 *    Ex.
 *      Input: s = "ccad"
 *      Output: "aacd"
 *      Explanation: In ccad, we choose a and c and after doing the replacement operation once, we get aacd and this is
 *                   the lexicographically smallest string possible.
 *
 *  Constraints:
 *      1 ≤ |s| ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S18_Choose_and_Swap {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = sc.next();

        System.out.println("lexicographically smallest string possible after swapping: ");
        System.out.println(chooseSwap(word));
    }

    /// Solution
    static String chooseSwap(String s) {
        // potd.code.hub
        int n = s.length();
        int[] firstOcc = new int[26];
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.fill(firstOcc, -1);

        // first occurrence
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (firstOcc[idx] == -1) {
                firstOcc[idx] = i;
                list.add(idx);
            }
        }

        // check for first swap
        for (int cur : list) {
            for (int j = 0; j < cur; j++) {
                if (firstOcc[j] > firstOcc[cur]) {
                    return swap((char) (cur + 'a'), (char) (j + 'a'), s);
                }
            }
        }

        return s;
    }

    private static String swap(char a, char b, String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == a) sb.append(b);
            else if (ch == b) sb.append(a);
            else sb.append(ch);
        }

        return sb.toString();
    }
}
