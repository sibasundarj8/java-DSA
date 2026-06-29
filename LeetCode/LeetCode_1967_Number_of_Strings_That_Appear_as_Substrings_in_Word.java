package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 *
 * # LC. 1967. Number of Strings That Appear as Substrings in Word
 *
 *   Q. Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a
 *      substring in word.
 *
 *      A substring is a contiguous sequence of characters within a string.
 *
 *    Ex.
 *      Input : patterns = ["a","abc","bc","d"], word = "abc"
 *      Output: 3
 *      Explanation:
 *              - "a" appears as a substring in "abc".
 *              - "abc" appears as a substring in "abc".
 *              - "bc" appears as a substring in "abc".
 *              - "d" does not appear as a substring in "abc".
 *              3 of the strings in patterns appear as a substring in word.
 *
 *  Constraints:
 *      1 <= patterns.length <= 100
 *      1 <= patterns[i].length <= 100
 *      1 <= word.length <= 100
 *      patterns[i] and word consist of lowercase English letters.
 */

import java.util.Scanner;

public class LeetCode_1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter strings for pattern[]: ");
        String[] patterns = sc.nextLine().split(" ");

        System.out.println("Word: ");
        String word = sc.next();

        System.out.println("number of strings in patterns that exist as a substring in word: ");
        System.out.println(numOfStrings(patterns, word));
    }

    /// Solution
    static int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String s : patterns) {
            if (word.contains(s)) {
                count++;
            }
        }

        return count;
    }
}
