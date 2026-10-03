package CSES.Q020_Knight_Moves_Grid;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final int[] DRow = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static final int[] DCol = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int[] row : mat) {
            Arrays.fill(row, -1);
        }

        int[] queue = new int[n * n];
        int head = -1;
        int tail = 0;

        queue[++head] = 0;
        mat[0][0] = 0;

        while (tail <= head) {
            int curr = queue[tail++];
            int r = curr >> 16;
            int c = curr & 0xFFFF;

            for (int x = 0; x < 8; x++) {
                int nr = r + DRow[x];
                int nc = c + DCol[x];

                if (0 <= nr && nr < n && 0 <= nc && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    queue[++head] = (nr << 16) | nc;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(mat[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
