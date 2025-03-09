package GFG_160;/*
 * 
 * https://www.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1
 * 
 * # Palindrome SubStrings
 * 
 *   Q. Given a string s, count all palindromic sub-strings present in the string. The length of the 
 *      palindromic sub-string must be greater than or equal to 2.
 *    Ex.
 *      Input : s = "abaab"
 *      Output: 3
 *      Explanation: All palindromic substrings are: "aba", "aa", "baab".
 */
import java.util.Scanner;

public class GFG_115_Palindrome_SubStrings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println(countPS(s));
    }

    /// Solution
    static int countPS(String s) {
        // potd.code.hub
        int n = s.length();
        int[] count = {0};

        // both for odd and even
        for (int i = 1;i < n;i++){
            palindromeLength(s, i-1, i+1, count);
            palindromeLength(s, i-1, i, count);
        }

        return count[0];
    }
    private static void palindromeLength(String s, int i, int j,int[]count){
        int n = s.length(), len = 0;
        while (i >= 0 && j < n){
            if (s.charAt(i) == s.charAt(j)){
                len += 2;
                count[0]++;
                i--;
                j++;
            }
            else break;
        }
    }
}
