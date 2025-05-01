package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/pascal-triangle0652/1
 *
 * # Pascal Triangle
 *
 *   Q. Given a positive integer n, return the nth row of pascal's triangle.
 *      Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the
 *      elements of the previous row.
 *    Ex.
 *      Input : n = 5
 *      Output: [1, 4, 6, 4, 1]
 *      Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix_Pascal_Triangle {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row Number: ");
        int n = sc.nextInt();

        System.out.println(n + "th Row in pascal triangle: ");
        System.out.println(nthRowOfPascalTriangle(n));
    }

    /// Solution
/*****************************************************************************Recursion*****************************************************************************/
    /*
    static ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // potd.code.hub
        if (n == 1){
            return new ArrayList<>(List.of(1));
        }
        if (n == 2){
            return new ArrayList<>(List.of(1, 1));
        }

        // recursive work
        ArrayList<Integer> prev = nthRowOfPascalTriangle(n-1);

        // self-work
        ArrayList<Integer> ans = new ArrayList<>(List.of(1));
        int size = prev.size();
        for (int i = 1;i < size;i++){
            ans.add(prev.get(i) + prev.get(i-1));
        }
        ans.add(1);

        return ans;
    }
    */
/******************************************************************Optimized-Mathematical-Solution******************************************************************/
    static ArrayList<Integer> nthRowOfPascalTriangle(int row) {
        ArrayList<Integer> ans = new ArrayList<>(List.of(1));

        int temp = 1;

        for (int col = 1;col < row;col++){
            temp *= row - col;
            temp /= col;
            ans.add(temp);
        }

        return ans;
    }
}
