package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Maximum_Product {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Sub-array Boundaries: ");
        System.out.print("L: ");
        int l = sc.nextInt();
        System.out.print("\nR: ");
        int r = sc.nextInt();
        System.out.println();

        System.out.println(maxSum(n, arr, l, r));
    }
    static long maxSum(int n, int[] arr, int l, int r) {
        // potd.code.hub
        if (l < 1 || r > n) throw new RuntimeException("subArray position out of bound!");

        int maxi = Integer.MIN_VALUE;
        int maxo = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int mino = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            if (i >= l-1 && i < r){
                maxi = Math.max(maxi, arr[i]);
                mini = Math.min(mini, arr[i]);
            }
            else {
                maxo = Math.max(maxo, arr[i]);
                mino = Math.min(mino, arr[i]);
            }
        }
        long ans1 = (long) maxi * maxo;
        long ans2 = (long) maxi * mino;
        long ans3 = (long) mini * maxo;
        long ans4 = (long) mini * mino;
        long[]ans = {ans1,ans2,ans3,ans4};
        Arrays.sort(ans);
        return ans[3];
    }
}