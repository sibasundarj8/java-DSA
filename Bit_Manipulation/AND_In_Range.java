package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/and-operation5726/1
 *
 * # AND In Range
 *
 *   Q. You are given two integers l and r. Find the result after applying the series of Bitwise AND ( & ) operation on
 *      every natural number between the range l to r (including both).
 *    Ex.
 *      Input : l = 8, r = 13
 *      Output: 8
 *      Explanation:
 *          8 AND 9 AND 10 AND 11 AND 12 AND 13 = 8.
 *
 *  Constraints:
 *          1 ≤ l ≤ r ≤ 10⁹
 */

import java.util.Scanner;

public class AND_In_Range {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("L : ");
        int l = sc.nextInt();

        System.out.print("R : ");
        int r = sc.nextInt();

        System.out.println("Bitwise AND between every natural number in range: ");
        System.out.println(andInRange(l, r));
    }

    /// Solution
    public static int andInRange(int l, int r) {
        // potd.code.hub
        int ans = 0;

        for(int i = 31; i >= 0; i--) {
            int l1 = l & (1 << i);
            int r1 = r & (1 << i);

            if(r1 == l1 && r1 > 0) {
                ans += l1;
            } else if(r1 > 0 || l1 > 0) break;
        }

        return ans;
    }
}
