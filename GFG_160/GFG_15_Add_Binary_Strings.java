package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/add-binary-strings3805/1
 *
 * # Add Binary Strings
 *
 *   Q. Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after
 *      adding the two Binary Strings.
 *
 *      Note: The input strings may contain leading zeros but the output string should not have any leading
 *            zeros.
 *    Ex.
 *      Input : s1 = "1101"
 *              s2 =  "111"
 *      Output: 10100
 *      Explanation:   1 1 0 1
 *               +       1 1 1
 *                   1 0 1 0 0
 */

import java.util.Scanner;

public class GFG_15_Add_Binary_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("B1: ");
        String s1 = sc.next();

        System.out.println("B2: ");
        String s2 = sc.next();

        System.out.println(addBinary(s1, s2));
    }

    /// Solution
    static String addBinary(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        StringBuilder ans = new StringBuilder();
        s1 = reverse(s1, n);
        s2 = reverse(s2, m);

        int i = 0, carry = 0;
        while (i < n || i < m){
            int c1 = 0;
            int c2 = 0;
            if (i < n) c1 = s1.charAt(i) - '0';
            if (i < m) c2 = s2.charAt(i) - '0';

            int temp = c1 + c2 + carry;
            if (temp == 1) {
                ans.append(1);
                carry = 0;
            } 
            else if (temp == 2) {
                ans.append(0);
                carry = 1;
            } 
            else if (temp == 3) {
                ans.append(1);
                carry = 1;
            } 
            else {
                ans.append(0);
            }
            i++;
        }
        ans.append(carry);

        String res = ans.reverse().toString();
        for (i = 0;i < res.length();i++) {
            if (res.charAt(i) != '0') {
                break;
            }
        }

        return res.substring(i);
    }
    static String reverse (String s, int n){
        StringBuilder ans = new StringBuilder();

        for (int i = n-1;i >= 0;i--) {
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
