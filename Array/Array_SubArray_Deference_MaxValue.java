package Array;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Array_SubArray_Deference_MaxValue {
    public Array_SubArray_Deference_MaxValue() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Array Elements : ");

        int m;
        for(m = 0; m < n; ++m) {
            arr[m] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.print("m = ");
        m = sc.nextInt();
        int l_sum1 = 0;
        int l_sum2 = 0;

        int i;
        for(i = 0; i < m; ++i) {
            l_sum1 += arr[i];
        }

        while(i < n) {
            l_sum2 += arr[i];
            ++i;
        }

        int dif1 = Math.abs(l_sum1 - l_sum2);
        int r_sum1 = 0;
        int r_sun2 = 0;

        int j;
        for(j = n - 1; j >= n - m; --j) {
            r_sum1 += arr[j];
        }

        while(j > 0) {
            r_sun2 += arr[j];
            --j;
        }

        int dif2 = Math.abs(r_sum1 - r_sun2);
        PrintStream var10000 = System.out;
        int var10001 = Math.max(dif1, dif2);
        var10000.println("\n" + var10001);
    }
}