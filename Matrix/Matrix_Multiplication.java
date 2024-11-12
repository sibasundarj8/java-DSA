package Matrix;

import java.util.Scanner;

public class Matrix_Multiplication
{
    static void multiplyMatrix(int[][] a, int r1, int c1, int[][] b, int r2, int c2)
    {
        if (c1 != r2)
        {
            System.out.println("Multiplication not possible!! - Wrong Dimension..");
        } else {
            System.out.println("Matrix 1 is :");
            printMatrix(a);

            System.out.println("Matrix 2 is :");
            printMatrix(b);

            int[][] mul = new int[r1][c2];

            for(int i = 0; i < r1; ++i)
            {
                for(int j = 0; j < c2; ++j)
                {
                    for(int k = 0; k < c1; ++k)
                    {
                        mul[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            System.out.println("Multiplication of 2 Matrix is :");
            printMatrix(mul);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Rows and Columns of Array1 :");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] a = new int[r1][c1];

        System.out.println("Enter Array Elements :");
        int r2;
        int c2;
        for(r2 = 0; r2 < r1; ++r2)
        {
            for(c2 = 0; c2 < c1; ++c2)
            {
                a[r2][c2] = sc.nextInt();
            }
        }
        System.out.println("Enter Rows and Columns of Array2 :");
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        int[][] b = new int[r2][c2];

        System.out.println("Enter Array Elements :");
        for(int i = 0; i < r2; ++i)
        {
            for(int j = 0; j < c2; ++j)
            {
                b[i][j] = sc.nextInt();
            }
        }
        multiplyMatrix(a, r1, c1, b, r2, c2);
    }
    static void printMatrix(int[][] arr)
    {
        for (int[] i : arr)
        {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}