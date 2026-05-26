package LeetCode;/*
 *
 * https://leetcode.com/problems/count-the-number-of-special-characters-i/
 *
 * # 3120. Count the Number of Special Characters I
 *
 *   Q. You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
 *      Return the number of special letters in word.
 *
 *    Ex.
 *      Input : word = "aaAbcBC"
 *      Output: 3
 *      Explanation:
 *              The special characters in word are 'a', 'b', and 'c'.
 *
 *  Constraints:
 *          1 <= word.length <= 50
 *          word consists of only lowercase and uppercase English letters.
 */

import java.util.Scanner;

public class LeetCode_3120_Count_the_Number_of_Special_Characters_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = sc.next();

        System.out.println("Number of special characters: ");
        System.out.println(numberOfSpecialChars(word));
    }

    /// Solution
    static int numberOfSpecialChars(String word) {
        int n = word.length();
        int count = 0;
        boolean[] visited = new boolean[128];

        for (int i = 0; i < n; i++) {
            visited[word.charAt(i)] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (visited['A' + i] && visited['a' + i]) {
                count++;
            }
        }

        return count;
    }
}
