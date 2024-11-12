package Matrix;

import java.util.Scanner;

public class Problem_2dArray_7_PrefixSum
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
    static int[][] prefixSum(int[][] arr, int r, int c)
    {
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < c; ++j)
            {
                if (i != 0 || j != 0)
                {
                    if (i == 0)
                    {
                        arr[i][j] += arr[i][j - 1];
                    } else if (j == 0) {
                        arr[i][j] += arr[i - 1][j];
                    } else {
                        arr[i][j] += arr[i][j - 1] + arr[i - 1][j];
                    }
                }
            }
        }
        return arr;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r != 0 && c != 0)
        {
            int[][] arr = new int[r][c];
            System.out.println("Enter Elements :");
            for(int i = 0; i < r; ++i)
            {
                for(int j = 0; j < c; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            printMatrix(prefixSum(arr, r, c));
        } else {
            System.out.println("Enter a valid Element !!");
        }
    }
}