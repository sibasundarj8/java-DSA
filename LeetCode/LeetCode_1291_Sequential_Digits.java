package LeetCode;/*
 *
 * https://leetcode.com/problems/sequential-digits/
 *
 * # LC. 1291. Sequential Digits
 *
 *   Q. An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *      Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *    Ex.
 *      Input : low = 1000, high = 13000
 *      Output: [1234, 2345, 3456, 4567, 5678, 6789, 12345]
 *
 *  Constraints:
 *        ◦ 10 <= low <= high <= 10⁹
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1291_Sequential_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Low: ");
        int low = sc.nextInt();

        System.out.print("High: ");
        int high = sc.nextInt();

        System.out.println("Sequential numbers between " + low + " and " + high + " : ");
        System.out.println(sequentialDigits(low, high));
    }

    /// Solution
    static List<Integer> sequentialDigits(int low, int high) {
        // potd.code.hub
        int multiplier = 1;
        List<Integer> list = new ArrayList<>();

        outer:
        for (int size = 2; size <= 9; size++) {
            int number = 0;
            multiplier *= 10;

            for (int i = 1; i <= size; i++) {
                number = number * 10 + i;
            }

            for (int i = size + 1; i <= 9; i++) {
                if (low <= number && number <= high) {
                    list.add(number);
                }

                number %= multiplier;
                number = number * 10 + i;

                if (number > high) break outer;
            }

            if (low <= number && number <= high) {
                list.add(number);
            }
        }

        return list;
    }
}
