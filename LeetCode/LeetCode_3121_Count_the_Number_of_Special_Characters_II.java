package LeetCode;/*
 *
 * https://leetcode.com/problems/count-the-number-of-special-characters-ii/
 *
 * # 3121. Count the Number of Special Characters II
 *
 *   Q. You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word,
 *      and every lowercase occurrence of c appears before the first uppercase occurrence of c.
 *
 *      Return the number of special letters in word.
 *
 *    Ex.
 *      Input : word = "AbBCab"
 *      Output: 0
 *      Explanation: here are no special characters in word.
 *
 *  Constraints:
 *          1 <= word.length <= 2 * 10⁵
 *          word consists of only lowercase and uppercase English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3121_Count_the_Number_of_Special_Characters_II {

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
        // potd.code.hub
        int n = word.length();
        int count = 0;
        int[] indices = new int[128];

        Arrays.fill(indices, -1);

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                if (indices[ch] == -1) {
                    indices[ch] = i;
                }
            } else {
                indices[ch] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            int lower = indices[i + 'a'];
            int upper = indices[i + 'A'];

            if (lower == -1 || upper == -1 || lower > upper) {
                continue;
            }

            count++;
        }

        return count;
    }
}
