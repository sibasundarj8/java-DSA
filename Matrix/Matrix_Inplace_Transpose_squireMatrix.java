package Matrix;

import java.util.Scanner;

public class Matrix_Inplace_Transpose_squireMatrix
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

        System.out.println("Enter " + r * c + " Elements :");
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < c; ++j)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Transpose of this Matrix is :");
        printMatrix(transposeMatrix(arr, r, c));
    }
    static int[][] transposeMatrix(int[][] arr, int r, int c)
    {
        for(int i = 0; i < r; ++i)
        {
            for(int j = i; j < c; ++j)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }
}