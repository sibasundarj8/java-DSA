package Array;

import java.util.Scanner;

public class Array_Conversion_1D_2D {
    public Array_Conversion_1D_2D() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of 2d array you want to convert to :");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m * n];
        System.out.println("Enter Array Elements of 1D Array :");

        for(int i = 0; i < m * n; ++i) {
            arr[i] = sc.nextInt();
        }

        int[][] ans = new int[m][n];
        int idx = 0;

        int j;
        for(int i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                ans[i][j] = arr[idx++];
            }
        }

        j = ans.length;

        for(int var9 = 0; var9 < j; ++var9) {
            int[] i = ans[var9];

            for (int k : i) {
                System.out.print(" " + k + " ");
            }
            System.out.println();
        }
    }
}