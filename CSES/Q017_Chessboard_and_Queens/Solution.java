package CSES.Q017_Chessboard_and_Queens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().trim().toCharArray();
        }

        boolean[] column = new boolean[8];
        boolean[] diagonal = new boolean[15];
        boolean[] anti_diagonal = new boolean[15];

        System.out.println(solve(7, board, column, diagonal, anti_diagonal));
    }

    private static int solve(int row, char[][] board, boolean[] column, boolean[] diagonal, boolean[] anti_diagonal) {
        // base case
        if (row < 0) return 1;

        // recursive work
        int sum = 0;

        for (int col = 0; col < 8; col++) {

            if (board[row][col] == '*' || column[col] || diagonal[row - col + 7] || anti_diagonal[row + col]) {
                continue;
            }

            column[col] = true;
            diagonal[row - col + 7] = true;
            anti_diagonal[row + col] = true;

            sum += solve(row - 1, board, column, diagonal, anti_diagonal);

            column[col] = false;
            diagonal[row - col + 7] = false;
            anti_diagonal[row + col] = false;
        }

        return sum;
    }
}
