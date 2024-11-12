package Matrix;

import java.util.Scanner;

public class Problem_2dArray_4_Traverse_Diagonally
{
    static int[] traverseDiagonally(int[][] arr, int r, int c)
    {
        int[] ans = new int[r * c];
        int row = 0;
        int col = 0;
        int idx = 0;

        while(col < c)
        {
            int i = row;

            int j = col;
            while (i >= 0 && j < c)
            {
                ans[idx++] = arr[i--][j++];
            }

            ++row;
            if (row >= r)
            {
                row = r - 1;
                ++col;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of Matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Elements :");
        int j;
        for(int i = 0; i < r; ++i)
        {
            for(j = 0; j < c; ++j)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("After Traversing Diagonally :\n");

        int[] var9 = traverseDiagonally(arr, r, c);
        j = var9.length;

        for(int var7 = 0; var7 < j; ++var7) {
            int i = var9[var7];
            System.out.print(i + " ");
        }

        System.out.println();
    }
}