package Matrix;

import java.util.Scanner;

public class Matrix_Linear_Search
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Matrix size in Row number and Column Number :");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] a = new int[r1][c1];

        System.out.println("Enter Matrix Elements :");
        int x;
        int i;
        for(x = 0; x < r1; ++x)
        {
            for(i = 0; i < c1; ++i)
            {
                a[x][i] = sc.nextInt();
            }
        }
        System.out.print("Search here : ");
        x = sc.nextInt();

        for(i = 0; i < r1; ++i)
        {
            for(int j = 0; j < c1; ++j)
            {
                if (x == a[i][j])
                {
                    System.out.println("Row Number : " + i + "\nColumn Number : " + j);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}