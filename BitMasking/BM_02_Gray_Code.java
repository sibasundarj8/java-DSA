package BitMasking;/*
 *
 * https://www.geeksforgeeks.org/problems/gray-code-1611215248/1
 *
 * # Gray Code
 *
 *   Q. Given a number n, generate bit patterns from 0 to 2(n-1) such that successive patterns differ by one bit.
 *      A Gray code sequence must begin with 0.
 *    Ex.
 *      Input : n = 3
 *      Output: ["000", "001", "011", "010", "110", "111", "101", "100"]
 *      Explanation:
 *              000 and 001 differ by one bit.
 *              001 and 011 differ by one bit.
 *              011 and 010 differ by one bit.
 *              Similarly, every successive pattern
 *              differs by one bit.
 *
 *  Constraints :
 *          1 ≤ n ≤ 16
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BM_02_Gray_Code {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.println("all the gray codes of length " + n + " : ");
        System.out.println(grayCode(n));
    }

    /// Solution
    static ArrayList<String> grayCode(int n) {
        // potd.code.hub
        int m = 1 << n;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int gray = i ^ (i >> 1);
            result.add(toBinary(gray, n));
        }

        return result;
    }

    private static String toBinary(int gray, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; 0 <= i; i--) {
            sb.append((gray >> i) & 1);
        }

        return sb.toString();
    }
}
