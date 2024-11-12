package Matrix;

import java.util.Scanner;

public class Problem_2dArray_1_Multiply
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
    static void multiplyMatrix(int[][] a, int r1, int c1, int[][] b, int r2, int c2)
    {
        if (c1 != r2)
        {
            System.out.println("Invalid Input Try Again !!");
        } else {
            int[][] ans = new int[r1][c2];

            for(int i = 0; i < r1; i++)
            {
                for(int j = 0; j < c2; j++)
                {
                    for(int k = 0; k < c2; k++)
                    {
                        ans[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            System.out.println("Matrix A * B :");
            printMatrix(ans);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix 1 :");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] a = new int[r1][c1];

        System.out.println("Enter Elements :");
        for(int i = 0; i < r1; ++i)
        {
            for(int j = 0; j < c1; ++j)
            {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Dimensions of Matrix 2 :");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] b = new int[r2][c2];

        System.out.println("Enter Elements :");
        for(int i = 0; i < r2; ++i)
        {
            for(int j = 0; j < c2; ++j)
            {
                b[i][j] = sc.nextInt();
            }
        }
        multiplyMatrix(a, r1, c1, b, r2, c2);
    }
}