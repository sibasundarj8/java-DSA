package Pattern;/*
 *
 * https://www.geeksforgeeks.org/problems/form-coils-in-a-matrix4726/1
 *
 * # Coils in Matrix
 *
 *   Q. Given a positive integer n, consider a 4n * 4n matrix filled with integers from 1 to (4n) * (4n) in row-major
 *      order (left to right, top to bottom). Form two coils from the matrix:
 *        ◦ The first coil starts from the top-left cell (0, 0) and spirals inward.
 *        ◦ The second coil starts from the bottom-right cell (4n - 1, 4n - 1) and spirals inward in the opposite
 *          direction.
 *
 *      Return these two coils in the same order.
 *
 *    Ex.
 *      Input : n = 1
 *      Output: [[ 1,  5, 9, 13, 14, 15, 11,  7],
 *               [16, 12, 8,  4,  3,  2,  6, 10]]
 *      Explanation: The matrix is
 *                                  1     2 -- 3 -- 4
 *                                  |     |         |
 *                                  5     6    7    8
 *                                  |     |    |    |
 *                                  9     10   11   12
 *                                  |          |    |
 *                                  13 -- 14 - 15   16
 *              So, the two coils are as given in the Output.
 *
 *  Constraints:
 *       ◦ 1 ≤ n ≤ 20
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Pattern_Coils_in_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> res = formCoils(n);

        System.out.print("coil-1 : ");
        System.out.println(res.get(0));

        System.out.print("coil-2 : ");
        System.out.println(res.get(1));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> formCoils(int n) {
        // potd.code.hub
        n <<= 2;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int size = n * (n >> 1);
        int maxVal = (size << 1) + 1;

        ArrayList<Integer> a = new ArrayList<>(size);
        ArrayList<Integer> b = new ArrayList<>(size);

        while (top < bottom && left < right) {

            for (int x = top; x <= bottom; x++) {
                int val = x * n + left + 1;
                a.add(val);
                b.add(maxVal - val);
            }

            for (int x = left + 1; x < right; x++) {
                int val = bottom * n + x + 1;
                a.add(val);
                b.add(maxVal - val);
            }

            for (int x = bottom - 1; x > top; x--) {
                int val = x * n + right;
                a.add(val);
                b.add(maxVal - val);
            }

            for (int x = right - 2; x > left + 1; x--) {
                int val = (top + 1) * n + x + 1;
                a.add(val);
                b.add(maxVal - val);
            }

            top += 2;
            bottom -= 2;
            left += 2;
            right -= 2;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(a);
        res.add(b);

        return res;
    }
}
