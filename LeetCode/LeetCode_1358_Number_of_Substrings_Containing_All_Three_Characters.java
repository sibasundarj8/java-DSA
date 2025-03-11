package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * # 1358. Number of Substrings Containing All Three Characters
 *
 *   Q. Given a string s consisting only of characters a, b and c.
 *
 *      Return the number of substrings containing at least one occurrence of all these characters
 *      a, b and c.
 *   Ex.
 *      Input: s = "aaacb"
 *      Output: 3
 *      Explanation: The substrings containing at least one occurrence of the characters a, b and
 *                   c are "aaacb", "aacb" and "acb".
 */
import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1358_Number_of_Substrings_Containing_All_Three_Characters {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word which should only contains 'a', 'b', 'c'.");
        String s = sc.next();

        System.out.println(numberOfSubstrings(s));
    }

    /// Solution
    static int numberOfSubstrings(String s) {
        // @ sibasundarj8@gmail.com
        int n = s.length(), ans = 0;
        int[] freq = new int[3];
        Arrays.fill(freq, -1);

        for (int i = 0;i < n;i++){
            freq[s.charAt(i) - 'a'] = i;
            ans += 1 + Math.min(freq[0], Math.min(freq[1], freq[2]));
        }

        return ans;
    }
}
