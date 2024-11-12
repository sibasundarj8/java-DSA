package Matrix;

import java.util.Scanner;

public class Matrix_Row_Reverse
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Matrix Dimensions in rows and columns :");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];

        System.out.println("Enter Matrix Elements :");
        int i;
        int a;
        for(i = 0; i < m; ++i)
        {
            for(a = 0; a < n; ++a)
            {
                arr[i][a] = sc.nextInt();
            }
        }
        for(i = 0; i < m; ++i)
        {
            a = 0;
            for(int b = n - 1; a < b; --b)
            {
                int temp = arr[i][a];
                arr[i][a] = arr[i][b];
                arr[i][b] = temp;
                ++a;
            }
        }
        printMatrix(arr);
    }
    static void printMatrix(int[][] arr)
    {
        System.out.println("Reverse of Matrix is :");
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