package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
 *
 * # Solve the Sudoku
 *
 *   Q. Given an incomplete Sudoku configuration in terms of a 9x9  2-D integer square matrix, mat[][],
 *      the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one
 *      solution.
 *
 *      A sudoku solution must satisfy all the following rules:
 *          1. Each of the digits 1-9 must occur exactly once in each row.
 *          2. Each of the digits 1-9 must occur exactly once in each column.
 *          3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 *      Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and
 *            cannot be changed.
 *    Ex.
 *      Input : int[]arr =
 *                   3 0 6   5 0 8   4 0 0
 *                   5 2 0   0 0 0   0 0 0
 *                   0 8 7   0 0 0   0 3 1
 *
 *                   0 0 3   0 1 0   0 8 0
 *                   9 0 0   8 6 3   0 0 5
 *                   0 5 0   0 9 0   6 0 0
 *
 *                   1 3 0   0 0 0   2 5 0
 *                   0 0 0   0 0 0   0 7 4
 *                   0 0 5   2 0 6   3 0 0
 *      Output: ----------------------------------
 *                   3 1 6   5 7 8   4 9 2
 *                   5 2 9   1 3 4   7 6 8
 *                   4 8 7   6 2 9   5 3 1
 *
 *                   2 6 3   4 1 5   9 8 7
 *                   9 7 4   8 6 3   1 2 5
 *                   8 5 1   7 9 2   6 4 3
 *
 *                   1 3 8   9 4 7   2 5 6
 *                   6 9 2   3 5 1   8 7 4
 *                   7 4 5   2 8 6   3 1 9
 */
import java.util.HashSet;
import java.util.Scanner;

public class GFG_78_Solve_the_Sudoku {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][]arr = new int[9][9];

        System.out.println("Sudoku is always be a 9*9 matrix, so you have enter 81 elements: ");
        for (int i = 0;i < 9;i++)
            for (int j = 0;j < 9;j++)
                arr[i][j] = sc.nextInt();

        solveSudoku(arr);

        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    /// Solution
    static boolean solveSudoku (int[][]arr){
        // potd.code.hub
        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                if (arr[i][j] == 0){
                    for (int x = 1; x < 10;x++){
                        if (isPos(arr, x, i, j)){
                            arr[i][j] = x;
                            if (solveSudoku(arr)) return true;
                            else arr[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isPos(int[][]arr, int x, int row, int col){
        for (int i = 0;i < 9;i++){
            int r = 3 * (row/3) + i/3;
            int c = 3 * (col/3) + i%3;
            if (arr[row][i] == x || arr[i][col] == x || arr[r][c] == x)
                return false;
        }
        return true;
    }
}
