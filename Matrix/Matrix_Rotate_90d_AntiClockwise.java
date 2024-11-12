package Matrix;

import java.util.Scanner;

public class Matrix_Rotate_90d_AntiClockwise
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

    static void swapMatrix(int[] arr, int c)
    {
        int i = 0;
        int temp;
        for(int j = c - 1; i < j; arr[j--] = temp)
        {
            temp = arr[i];
            arr[i++] = arr[j];
        }
    }
    static void transpose(int[][] arr, int r, int c)
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
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Matrix Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r != c)
        {
            System.out.println("Invalid Input!!\nMake sure that number of Rows and Columns are Equal.");
        } else {
            int[][] arr = new int[r][c];

            System.out.println("Elements :");
            int i;
            for(i = 0; i < r; ++i)
            {
                for(int j = 0; j < c; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(i = 0; i < r; ++i)
            {
                swapMatrix(arr[i], c);
            }

            transpose(arr, r, c);

            System.out.println("Matrix after rotation of 90 degree Anti-Clockwise :");
            printMatrix(arr);
        }
    }
}