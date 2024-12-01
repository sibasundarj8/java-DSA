package GFG;/*
 *   Q. Given an array arr of n integers. Your task is to write a program to find the
 *      maximum value of ∑arr[i]*i, where i = 0, 1, 2,., n-1. You are allowed to rearrange
 *      the elements of the array.
 *
 *      Note: Since the output could be large, print the answer modulo 109+7.
 *
 *    Ex.
 *      Input : arr[] = [5, 3, 2, 4, 1]
 *      Output : 40
 *      Explanation:
 *                  If we arrange the array as 1 2 3 4 5 then we can see that the minimum
 *                  index will multiply with minimum number and maximum index will multiply
 *                  with maximum number. So, 1*0 + 2*1 + 3*2 + 4*3 + 5*4 = 0+2+6+12+20 = 40
 *                  mod(109+7) = 40
 */
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Maximize_Array_Value_After_Rearrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println(Maximize(arr));
    }
    static int Maximize(int[]arr) {
        // potd.code.hub
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0;i < arr.length;i++){
            ans += (long) i * arr[i];
            ans %= (int)(1e9+7);
        }
        return (int)ans;
    }
}