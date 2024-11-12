package Matrix;

import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public class Problem_2dArray_8_Reverse_SpiralOrder
{
    static void printArray(int @NotNull [] arr)
    {
        System.out.print("[ ");
        for (int i : arr)
        {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
    static int[] reverseSpiral(int[][] arr, int r, int c)
    {
        int[] ans = new int[r * c];
        int idx = 0;
        int tr = 0;
        int br = r - 1;
        int lc = 0;

        for(int rc = c - 1; idx < r * c; --rc)
        {
            int j;
            for(j = rc; j >= lc && idx < r * c; --j)
            {
                ans[idx++] = arr[tr][j];
            }

            ++tr;

            for(j = tr; j <= br && idx < r * c; ++j)
            {
                ans[idx++] = arr[j][lc];
            }

            ++lc;

            for(j = lc; j <= rc && idx < r * c; ++j)
            {
                ans[idx++] = arr[br][j];
            }

            --br;

            for(j = br; j >= tr && idx < r * c; --j)
            {
                ans[idx++] = arr[j][rc];
            }
        }

        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Matrix Dimensions :");
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

        System.out.println("Reverse Spiral Order :");
        printArray(reverseSpiral(arr, r, c));
    }
}