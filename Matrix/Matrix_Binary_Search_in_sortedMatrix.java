package Matrix;

import java.util.Scanner;

public class Matrix_Binary_Search_in_sortedMatrix
{
    static void binarySearch(int[][] arr, int m, int n, int x)
    {
        int i = 1;
        int j = n;
        while(i <= m && j > 0)
        {
            if (arr[i][j] == x)
            {
                System.out.println(" Row  number  : " + i);
                System.out.println("Column number : " + j);
                return;
            }
            if (x < arr[i][j])
            {
                --j;
            } else {
                ++i;
            }
        }
        System.out.println("Number is not Exist in this Matrix !!");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter matrix Dimensions in rows and columns :");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m + 1][n + 1];

        System.out.println("Enter the Elements in increasing order :");
        int i;
        for(i = 1; i <= m; ++i)
        {
            for(int j = 1; j <= n; ++j)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the Element to be Searched :");
        i = sc.nextInt();

        binarySearch(arr, m, n, i);
    }
}