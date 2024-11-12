package Matrix;

import java.util.Scanner;

public class Matrix_Transpose
{
    static void printMatrix(int[][] arr)
    {
        for (int[] i : arr)
        {
            for (int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Matrix Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter Matrix Elements :");
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < c; ++j)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Transpose of the Matrix is :");
        printMatrix(transposeMatrix(arr, r, c));
    }
    static int[][] transposeMatrix(int[][] arr, int r, int c)
    {
        int[][] ans = new int[c][r];

        for(int i = 0; i < c; ++i)
        {
            for(int j = 0; j < r; ++j)
            {
                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }
}