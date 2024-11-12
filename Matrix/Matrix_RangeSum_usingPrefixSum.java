package Matrix;

import java.util.Scanner;

public class Matrix_RangeSum_usingPrefixSum
{
    static int rangeSum(int[][] arr, int l1, int l2, int r1, int r2)
    {                                                                   //  big O(i*j)
        int sum = 0;

        for(int i = l1; i <= l2; ++i)
        {
            for(int j = r1; j <= r2; ++j)
            {
                sum += arr[i][j];
            }
        }
        return sum;
    }
    static int rangeSum2(int[][] arr, int l1, int l2, int r1, int r2)
    {
        int up = 0;
        int left = 0;
        int leftUp = 0;

        prefixSum(arr);

        if (l1 >= 1)
        {
            up = arr[l1 - 1][r2];
        }

        if (r1 >= 1)
        {
            left = arr[l2][r1 - 1];
        }

        if (l1 >= 1 && r1 >= 1)
        {
            leftUp = arr[l1 - 1][r1 - 1];
        }

        int sum = arr[l2][r2];
        return sum - up - left + leftUp;
    }

    static void prefixSum(int[][] arr)
    {                                                           // big-O(1)
        int r = arr.length;
        int c = arr[0].length;

        int i;
        int j;
        for(i = 0; i < r; ++i)
        {
            for(j = 1; j < c; ++j)
            {
                arr[i][j] += arr[i][j - 1];
            }
        }
        for(i = 1; i < r; ++i)
        {
            for(j = 0; j < c; ++j)
            {
                arr[i][j] += arr[i - 1][j];
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter matrix Dimensions : ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r < 1 && c < 1)
        {
            System.out.println("First enter some Elements, Then try again !!");
        } else {
            int[][] arr = new int[r][c];

            System.out.println("Elements : ");
            for(int i = 0; i < r; ++i)
            {
                for(int j = 0; j < c; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter coordinates :");
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            System.out.println("Solution using brute force approach :");
            System.out.println(rangeSum(arr, l1, l2, r1, r2));
            System.out.println("Optimized Code Solution :");
            System.out.println(rangeSum2(arr, l1, l2, r1, r2));
        }
    }
}