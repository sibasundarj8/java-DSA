package Matrix;

import java.util.Scanner;

public class Problem_2dArray_6_Form_Spiral_Matrix
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
    static int[][] formSpiralMatrix(int n)
    {
        int tr = 0;
        int br = n - 1;
        int lc = 0;
        int rc = n - 1;
        int idx = 1;

        int[][] ans;
        for(ans = new int[n][n]; idx <= n * n; ++lc)
        {
            int j;
            for(j = lc; j <= rc && idx <= n * n; ++j)
            {
                ans[tr][j] = idx++;
            }

            ++tr;

            for(j = tr; j <= br && idx <= n * n; ++j)
            {
                ans[j][rc] = idx++;
            }

            --rc;

            for(j = rc; j >= lc && idx <= n * n; --j)
            {
                ans[br][j] = idx++;
            }

            --br;

            for(j = br; j >= tr && idx <= n * n; --j)
            {
                ans[j][lc] = idx++;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of square Matrix :");
        int n = sc.nextInt();

        printMatrix(formSpiralMatrix(n));
    }
}