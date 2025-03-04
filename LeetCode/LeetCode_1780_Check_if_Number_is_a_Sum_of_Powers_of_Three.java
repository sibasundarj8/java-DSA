package LeetCode;/*
 *
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 *
 * #1780. Check if Number is a Sum of Powers of Three
 *
 *   Q. Given an integer n, it returns true if it is possible to represent n as the sum of distinct
 *      powers of three. Otherwise, return false.
 *
 *      An integer y is a power of three if there exists an integer x such that y == 3x.
 *
 *    Ex-1:
 *      Input : n = 12
 *      Output: true
 *      Explanation: 12 = 31 + 32
 *
 *    Ex-2:
 *      Input : n = 91
 *      Output: true
 *      Explanation: 91 = 30 + 32 + 34
 */
import java.util.Scanner;

public class LeetCode_1780_Check_if_Number_is_a_Sum_of_Powers_of_Three {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number: ");
        System.out.println(checkPowersOfThree(sc.nextInt()));
    }

    /// Solution
    static boolean checkPowersOfThree(int n) {
        // @sibasundarj8@gmail.com
        for (int i = n;i > 0;i /= 3)
            if (i % 3 == 2) return false;

        return true;
    }
}
