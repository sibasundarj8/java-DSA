package Matrix;

import java.util.Scanner;

public class Problem_2dArray_9_Perfect_Matrix
{
    static boolean perfectMatrix(int[][] arr, int n)
    {
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if (i != j && i + j != n - 1)
                {
                    if (arr[i][j] != 0)
                    {
                        return false;
                    }
                } else if (arr[i][j] == 0)
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

        System.out.println("Enter Dimensions of matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r > 0 && c > 0)
        {
            int[][] arr = new int[r][c];

            System.out.println(r * c + " Elements :");
            for(int i = 0; i < r; ++i)
            {
                for(int j = 0; j < r; ++j)
                {
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println(perfectMatrix(arr, r));
        } else
        {
            System.out.println("Enter Valid Dimensions !!");
        }
    }
}