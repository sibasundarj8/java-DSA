package Matrix;

import java.util.Scanner;

public class Matrix_Addition
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Rows and Columns of Array 1 :");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] a = new int[r1][c1];

        System.out.println("Enter Array Elements : ");
        int r2;
        int c2;
        for(r2 = 0; r2 < r1; ++r2)
        {
            for(c2 = 0; c2 < c1; ++c2)
            {
                a[r2][c2] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of Rows and Columns of Array 2 :");
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        int[][] b = new int[r1][c1];

        System.out.println("Enter Array Elements : ");
        for(int i = 0; i < r2; ++i)
        {
            for(int j = 0; j < c2; ++j)
            {
                b[i][j] = sc.nextInt();
            }
        }
        addMatrix(a, r1, c1, b, r2, c2);
    }
    static void addMatrix(int[][] arr1, int r1, int c1, int[][] arr2, int r2, int c2)
    {
        if (r1 == r2 && c1 == c2)
        {
            int[][] sum = new int[r1][c1];

            for(int i = 0; i < r1; ++i)
            {
                for(int j = 0; j < c1; ++j)
                {
                    sum[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            printMatrix(sum);
        } else {
            System.out.println("Wrong Input!!\nFor matrix addition we have to Enter Equal number of rows and equal number of columns..");
        }
    }
    static void printMatrix(int[][] arr)
    {
        System.out.println("Sum :");
        for (int[] i : arr)
        {
            for (int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}