package Matrix;

import java.util.Scanner;

public class Problem_2dArray_3_Toeplitz_Matrix
{
    static boolean toeplitz(int[][] arr, int r, int c)
    {
        for(int i = 1; i < r; ++i)
        {
            for(int j = 1; j < c; ++j)
            {
                if (arr[i][j] != arr[i - 1][j - 1])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Elements :");
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < c; ++j)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("It is a Toeplitz Matrix- ");
        System.out.println(toeplitz(arr, r, c));
    }
}