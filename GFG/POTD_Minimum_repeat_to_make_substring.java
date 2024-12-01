package GFG;/*
 * https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170645/1
 *
 * #Minimum repeat to make substring
 *
 *   Q. Given two strings s1 and s2. Return a minimum number of times s1 has to be repeated such that s2 is a
 *      substring of it. If s2 can never be a substring then return -1.
 *    Ex.
 *      Input : s1 = "abcd",
 *              s2 = "cdabcdab"
 *      Output: 3
 *      Explanation: Repeating s1 three times (abcdabcdabcd), s2 is a substring of it. s2 is not a substring of
 *                   s2 when it is repeated less than 3 times.
 */
import java.util.Scanner;

public class POTD_Minimum_repeat_to_make_substring {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter S1: ");
        String s1 = sc.next();

        System.out.println("Enter S2: ");
        String s2 = sc.next();

        System.out.printf("After %d times", minRepeats(s1, s2));
    }

    /// Solution
    static int minRepeats(String s1, String s2) {
        // potd.code.hub
        for (int i = 0;i < s2.length();i++){
            if (!s1.contains(String.valueOf(s2.charAt(i)))){
                return -1;
            }
        }
        StringBuilder s = new StringBuilder();
        int ans = 0;
        while(s.length() < s2.length()){
            s.append(s1);
            ans++;
        }
        if (s.toString().contains(s2)) return ans;
        s.append(s1);
        return s.toString().contains(s2) ? ans : -1;
    }
}