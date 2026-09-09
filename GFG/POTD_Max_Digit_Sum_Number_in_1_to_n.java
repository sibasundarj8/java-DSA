package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/biggest-integer-having-maximum-digit-sum1704/1
 *
 * # Max Digit Sum Number in 1 to n
 *
 *   Q. Given a number n, find a number in the range from 1 to n such that its digit sum is maximum. If there are
 *      multiple such numbers, return the largest of them.
 *
 *    Ex.
 *      Input : n = 48
 *      Output: 48
 *      Explanation: There are two numbers with maximum digit sum = 12. The numbers are 48 and 39. Since 48 > 39,
 *                   so 48 is the answer.
 *
 *  Constraints:
 *      1 ≤ n ≤ 10⁹
 */

import java.util.Scanner;

public class POTD_Max_Digit_Sum_Number_in_1_to_n {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.println("Number with maximum digit sum in range: [1 - " + n + "]");
        System.out.println(findMax(n));
    }

    /// Solution
    static int findMax(int n) {
        // potd.code.hub
        char[] num = String.valueOf(n).toCharArray();

        int len = num.length;
        int maxSum = 0;

        for (char digit : num) {
            maxSum += (digit - '0');
        }

        int prefixSum = maxSum - (num[len - 1] - '0');
        int deltaIdx = len;
        int currSum, digit;

        for (int i = len - 2; i >= 0; i--) {
            digit = num[i] - '0';
            currSum = prefixSum - 1 + 9 * (len - 1 - i);

            if (digit == 0) continue;

            if (currSum > maxSum) {
                maxSum = currSum;
                deltaIdx = i;
            }

            prefixSum -= (digit);
        }

        // building the number
        int res = 0;

        for (int i = 0; i < len; i++) {
            res *= 10;
            digit = num[i] - '0';

            if (i < deltaIdx) res += digit;
            else if (i == deltaIdx) res += (digit - 1);
            else res += 9;
        }

        return res;
    }
}
