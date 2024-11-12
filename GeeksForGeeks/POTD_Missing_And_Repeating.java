package GFG;

import java.util.Scanner;

public class POTD_Missing_And_Repeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.printf("Enter first %d natural numbers, with a missing and a repeating number :\n",n);
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        for (int i : findTwoElement(arr))
            System.out.print(i + " ");
        System.out.println();
    }
    static int[] findTwoElement(int[]arr) {
        // potd.code.hub
        long n = arr.length;
        // 1+2+3...n
        long sn = n*(n+1) / 2;
        // 1²+2²+3²...n
        long s2n = n*(n+1)*(2L*n+1) / 6;
        // sum of array elements
        long s = 0, s2 = 0;
        for (int i : arr){
            s += i;
            s2 += (long)i*(long)i;
        }

        long v1 = s - sn;
        long v2 = s2 - s2n;     //s²-p² = (s+p)(s-p) = v2 => s+p = v/(s-p)
        long m = v2/v1;        // s + p
        long r = (m+v1) / 2;  // (s+p + s-p)/2 = 2*s/2 = s  ->repeating number
        m -= r;              //  (s+p) - s = p              ->missing number

        return new int[]{(int)r, (int)m};
    }
}