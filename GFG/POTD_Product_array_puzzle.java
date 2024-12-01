package GFG;/*
 *       Q. Given an array nums[], construct a Product Array nums[] such that nums[i] is equal
 *          to the product of all the elements of nums except nums[i].\
 *      Examples:
 *          Input: nums[] = [10, 3, 5, 6, 2]
 *          Output: [180, 600, 360, 300, 900]
 *          Explanation:
 *                      For i=0, P[i] = 3*5*6*2 = 180.
 *                      For i=1, P[i] = 10*5*6*2 = 600.
 *                      For i=2, P[i] = 10*3*6*2 = 360.
 *                      For i=3, P[i] = 10*3*5*2 = 300.
 *                      For i=4, P[i] = 10*3*5*6 = 900.
 */
import java.util.Scanner;

public class POTD_Product_array_puzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Array Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        for (long i : productExceptSelf(arr))
            System.out.print(i + " ");
    }
    static long[]productExceptSelf(int[]arr){
        // @ potd.code.hub
        int n = arr.length;
        long[]ans = new long[n];
        long left = 1;      // left product
        for (int i = 0;i < n;i++) {
            ans[i] = left;
            left*=arr[i];
        }
        long right = 1;     // Right product
        for (int i = n-1;i >= 0;i--){
            ans[i] *= right;
            right*=arr[i];
        }
        return ans;
    }
}