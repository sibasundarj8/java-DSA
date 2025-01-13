package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/3-sum-closest/1
 *
 * # 3 Sum Closest
 *
 *   Q. Given an array arr[] and an integer target, the task is to find the sum of three integers in arr[]
 *      such that the sum is closest to target.
 *
 *      Note: If multiple sums are closest to target, return the maximum one.
 *    Ex.
 *      Input : arr[] = [1, 10, 4, 5]
 *              target = 10
 *      Output: 10
 *      Explanation: All possible triplets
 *                  [1, 10, 4], sum = (1 + 10 + 4) = 15
 *                  [1, 10, 5], sum = (1 + 10 + 5) = 16
 *                  [1,  4, 5], sum = (1 +  4 + 5) = 10
 *                  [10, 4, 5], sum = (10 + 4 + 5) = 19
 *                  Triplet [1, 4, 5] has sum = 10 which is closest to target.
 */
import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer_02_3_Sum_Closest {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(closest3Sum(arr, target));
    }
    /// Solution
    static int closest3Sum(int[] arr, int t) {
        // potd.code.hub
        int n = arr.length;
        long ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0;i < n-2;i++){
            int l = i+1, r = n-1;
            while (l < r){
                int sum = arr[i] + arr[l] + arr[r];
                ans = Math.abs(t-sum) <= Math.abs(t-ans) ? Math.abs(t-sum) == Math.abs(t-ans)? Math.max(ans, sum) : sum : ans;
                if (sum < t) l++;
                else if (sum > t)r--;
                else return sum;
            }
        }

        return (int)ans;
    }
}
