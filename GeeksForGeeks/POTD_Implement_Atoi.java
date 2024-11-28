package GFG;/*
 * https://www.geeksforgeeks.org/problems/implement-atoi/1
 *
 * # Implement Atoi
 *
 *   Q. Given a string s, the objective is to convert it into integer format without utilizing any builtin
 *      functions. Refer the below steps to know about atoi() function.
 *
 *      Cases for atoi() conversion:
 *       1. Skip any leading whitespaces.
 *       2. Check for a sign ('+' or '-'), default to positive if no sign is present.
 *       3. Read the integer by ignoring leading zeros until a non-digit character is encountered or end of
 *          the string is reached. If no digits are present, return 0.
 *       4. If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than
 *          -2³¹ then return -2³¹.
 *    Ex.
 *      Input : s = "-123"
 *      Output: -123
 *
 *      Input : s = "  -"
 *      Output: 0
 *
 *      Input : s = "1231231231311133"
 *      Output: 2147483647
 *
 *      Input : s = "-999999999999"
 *      Output: -2147483648
 *
 *      Input : s = "  -0012gfg4"
 *      Output: -12
 */

import java.util.Scanner;

public class POTD_Implement_Atoi {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();

        System.out.println(myAtoi(s));
    }

    /// Solution
    static int myAtoi(String s) {
        // potd.code.hub
        int n = s.length();
        long res = 0;
        boolean flag = false;

        int i = 0;
        while(i < n){
            if (s.charAt(i) != ' ') break;
            i++;
        }

        if (s.charAt(i) == '-'){
            flag = true;
            i++;
        }

        while (i < n){
            int temp = s.charAt(i) - '0';
            if (temp < 0 || 9 < temp) break;
            res = res*10 + temp;
            i++;
        }

        if (flag){
            res *= -1;
        }

        if (res <= Integer.MIN_VALUE) res = Integer.MIN_VALUE;
        if (res >= Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        return (int)res;
    }
}
