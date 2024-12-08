package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170645/0
 *
 * # Minimum repeat to make substring
 *
 *   Q. Given two strings s1 and s2. Return a minimum number of times s1 has to be repeated such that s2
 *      is a substring of it. If s2 can never be a substring then return -1.
 *
 *      Note: Both the strings contain only lowercase letters.
 *    Ex.
 *      Input : s1 = "abcd", s2 = "cdabcdab"
 *      Output: 3
 *      Explanation: Repeating s1 three times "abcdabcdabcd", s2 is a substring of it. s2 is not a substring
 *                   of s1 when it is repeated less than 3 times.
 */
import java.util.Scanner;

public class String_04_Minimum_repeat_to_make_substring {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("s1: ");
        String s1 = sc.next();

        System.out.println("s2: ");
        String s2 = sc.next();

        System.out.println(minRepeats(s1, s2));
    }

    /// Solution
    static int minRepeats(String s1, String s2) {
        // potd.code.hub
        for (int i = 0;i < s2.length();i++) {
            if (!s1.contains(String.valueOf(s2.charAt(i)))) {
                return -1;
            }
        }

        StringBuilder s = new StringBuilder();
        int ans = 0;
        while(s.length() < s2.length()){
            s.append(s1);
            ans++;
        }

        if (search(s.toString(), s2)) return ans;

        s.append(s1);

        return search(s.toString(), s2) ? ans+1 : -1;
    }
    private static boolean search(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();

        int[] lps = new int[m];
        lpsArray(s2, lps, m);

        int i = 0, j = 0;
        while (i < n){
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
                i++;
                if (j == m) return true;
            }
            else if (j == 0) i++;
            else j = lps[j-1];
        }
        return false;
    }
    private static void lpsArray(String s, int[]lps, int n){
        int i = 0, j = 1;
        while (j < n){
            if (s.charAt(i) == s.charAt(j)) lps[j++] = ++i;
            else if (i == 0) lps[j++] = 0;
            else i = lps[i-1];
        }
    }
}
