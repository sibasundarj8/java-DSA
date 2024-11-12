package Matrix;

import java.util.Scanner;

public class Matrix_Rotate_90d_Clockwise
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r != c)
        {
            System.out.println("Only Square matrix are valid..\nPlease Try again!!..");
        } else {
            int[][] arr = new int[r][c];

            System.out.println("Enter Array elements :");
            for(int i = 0; i < r; ++i)
            {
                for(int j = 0; j < c; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("The Matrix is rotated by 90 degree :");
            printMatrix(rotate90d(arr, r));
        }
    }
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
    static void transposeMatrix(int[][] arr, int r, int c)
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
    static int[][] rotate90d(int[][] arr, int n)
    {
        transposeMatrix(arr, n, n);
        for(int i = 0; i < n; ++i)
        {
            swapElements(arr[i]);
        }
        return arr;
    }
    static void swapElements(int[] arr)
    {
        int i = 0;
        for(int j = arr.length - 1; i < j; --j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
        }
    }
}