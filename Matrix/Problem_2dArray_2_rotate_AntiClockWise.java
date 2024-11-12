package Matrix;

import java.util.Scanner;

public class Problem_2dArray_2_rotate_AntiClockWise
{
    static void printArray(int[][] a)
    {
        for (int[] i : a)
        {
            for (int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    static int[][] rotateAntiClockwise(int[][] arr, int n)
    {
        for(int i = 0; i < n / 2; ++i)
        {
            for(int j = i; j < n - 1 - i; ++j)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r != c)
        {
            throw new RuntimeException("Make sure number of Row and column are equal.");
        } else {
            int[][] arr = new int[r][c];
            System.out.println("Elements :");

            for(int i = 0; i < r; ++i)
            {
                for(int j = 0; j < c; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("The Matrix is rotated by 90 degree :");
            printArray(rotateAntiClockwise(arr, r));
        }
    }
}