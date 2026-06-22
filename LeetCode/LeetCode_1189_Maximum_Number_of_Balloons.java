package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-number-of-balloons/
 *
 * # LC. 1189. Maximum Number of Balloons
 *
 *   Q. Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as
 *      possible. You can use each character in text at most once. Return the maximum number of instances that can be
 *      formed.
 *
 *    Ex.
 *      Input : text = "loonbalxballpoon"
 *      Output: 2
 *
 *  Constraints:
 *          1 <= text.length <= 10⁴
 *          text consists of lower case English letters only.
 */

import java.util.Scanner;

public class LeetCode_1189_Maximum_Number_of_Balloons {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String text = sc.next();

        System.out.println("word 'balloon' can be formed " + maxNumberOfBalloons(text) + "\ntimes using \"" + text + "\"");
    }

    /// Solution
    static int maxNumberOfBalloons(String text) {
        int len = text.length();
        int[] freq = new int[5];

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);

            switch (ch) {
                case 'a' -> freq[0]++;
                case 'b' -> freq[1]++;
                case 'l' -> freq[2]++;
                case 'o' -> freq[3]++;
                case 'n' -> freq[4]++;
            }
        }

        freq[2] = freq[2] >> 1;
        freq[3] = freq[3] >> 1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            min = Math.min(min, freq[i]);
        }

        return min;
    }
}
