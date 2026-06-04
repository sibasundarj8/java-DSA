package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-difference-of-zeros-and-ones-in-binary-string4111/1
 *
 * # Substring with Max Zero-One Diff
 *
 *   Q. Given a binary string s consisting of 0s and 1s. Find the maximum difference of the number of 0s and the number of
 *      1s (number of 0s – number of 1s) in a substring of the string.
 *
 *      Note: In the case of all 1s, the answer will be -1.
 *
 *    Ex.
 *      Input : s = "11000010001"
 *      Output : 6
 *      Explanatio: From index 2 to index 9, there are 7 0s and 1 1s, so number of 0s - number of 1s is 6.
 *
 *  Constraints:
 *          1 ≤ s.size() ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Substring_with_Max_Zero_One_Diff {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary string consists of only 0's and 1's: ");
        String s = sc.next();

        System.out.println("Maximum difference of the number of 0s and 1's in a substring: ");
        System.out.println(maxSubstring(s));
    }

    /// Solution
    static int maxSubstring(String s) {
        // potd.code.hub
        int n = s.length();
        int max = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '0') ? 1 : -1;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        return max;
    }
}
