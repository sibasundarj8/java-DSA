package Pattern;/*
 * 
 * https://www.geeksforgeeks.org/problems/decode-the-pattern1138/1
 * 
 * # Look and Say Pattern
 * 
 *   Q. Given an integer n. Return the nth row of the following look-and-say pattern.
 *          1
 *          11
 *          21
 *          1211
 *          111221
 * 
 *      Look-and-Say Pattern: To generate a member of the sequence from the previous member, read off the digits 
 *                            of the previous member, counting the number of digits in groups of the same digit. 
 *      For example:
 *          1 is read off as "one 1" or 11.
 *          11 is read off as "two 1s" or 21.
 *          21 is read off as "one 2, then one 1" or 1211.
 *          1211 is read off as "one 1, one 2, then two 1s" or 111221.
 *          111221 is read off as "three 1s, two 2s, then one 1" or 312211.
 *   Ex.
 *      Input : n = 5
 *      Output: 111221
 *      Explanation: The 5th row of the given pattern will be 111221.
 */
import java.util.Scanner;

public class Pattern_Look_and_Say_Pattern {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n : ");
        int n = sc.nextInt();

        System.out.println("Look and Say pattern: " + countAndSay(n));
    }

    /// Solution
    static String countAndSay(int n) {
        // potd.code.hub
        String ans = "1";

        for (int i = 1;i < n;i++){
            StringBuilder cur = new StringBuilder();
            char prevChar = ans.charAt(0);
            int count = 1;

            for (int j = 1;j < ans.length();j++){
                if (ans.charAt(j) == prevChar){
                    count++;
                }else {
                    cur.append(count).append(prevChar);
                    prevChar = ans.charAt(j);
                    count = 1;
                }
            }
            cur.append(count).append(prevChar);

            ans = cur.toString();
        }
        
        return ans;
    }
}
