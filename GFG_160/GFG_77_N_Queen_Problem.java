package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
 *
 * # N-Queen Problem
 *
 *   Q. The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two
 *      queens can attack each other. Note that two queens attack each other if they are placed on the same
 *      row, the same column, or the same diagonal.
 *
 *      Given an integer n, find all distinct solutions to the n-queens puzzle.
 *      You can return your answer in any order but each solution should represent a distinct board
 *      configuration of the queen placements, where the solutions are represented as permutations of
 *      [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in
 *      which the queen is placed in the ith column.
 *      For eg: below figure represents a chessboard [3 1 4 2].
 *                                        •  Q  •  •
 *                                        •  •  •  Q
 *                                        Q  •  •  •
 *                                        •  •  Q  •
 *    Ex.
 *      Input : n = 4
 *      Output: [[2 4 1 3 ] [3 1 4 2 ]]
 *      Explanation: There are 2 possible solutions for n = 4.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GFG_77_N_Queen_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of board: ");
        int n = sc.nextInt();

        System.out.println(nQueen(n));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[]row = new int[n];
        int[]uDiagonal = new int[2 * n - 1];
        int[]lDiagonal = new int[2 * n - 1];
        solve(0, new ArrayList<>(n), ans, row, uDiagonal, lDiagonal, n);
        return ans;
    }
    private static void solve(int col,ArrayList<Integer> pos, ArrayList<ArrayList<Integer>> ans, int[]row, int[]ud, int[]ld, int n){
        // base case
        if (col == n){
            ans.add(new ArrayList<>(pos));
            return;
        }
        // self work
        for (int r = 0;r < n;r++){
            if (row[r] == 0 && ud[r + col] == 0 && ld[n-1 + col - r] == 0){
                row[r] = 1;
                ud[r + col] = 1;
                ld[n-1 + col - r] = 1;
                pos.add(r+1);
                // recursive work
                solve(col+1, pos, ans, row, ud, ld, n);
                // backtracking
                row[r] = 0;
                ud[r + col] = 0;
                ld[n-1 + col - r] = 0;
                pos.remove(pos.size()-1);
            }
        }
    }
}
