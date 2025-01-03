package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/roman-number-to-integer3201/1
 *
 * # Roman Number to Integer
 *
 *   Q. Given a string in Roman number format (s), your task is to convert it to an integer. Various
 *      symbols and their values are given below.
 *
 *      Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 *    Ex.
 *      Input : s = "MCMIV"
 *      Output: 1904
 *      Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as
 *                   1000 + 900 + 4 = 1904.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Hashing_01_Roman_Number_to_Integer {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Roman Number: ");
        String num = sc.next();

        System.out.println(romanToDecimal(num));
    }

    /// Solution
    static int romanToDecimal(String s) {
        // potd.code.hub
        s = s.toUpperCase();
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0;i < n;i++){
            int curr = map.get(s.charAt(i));
            int next = (i < n-1) ? map.get(s.charAt(i+1)) : 0;
            ans += (next <= curr) ? curr : next - curr + i - i++;
        }

        return ans;
    }
}
