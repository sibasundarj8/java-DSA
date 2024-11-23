package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
 *
 * # Minimize the Heights II
 *
 *   Q. Given an array arr[] denoting heights of N towers and a positive integer K.
 *
 *      For each tower, you must perform exactly one of the following operations exactly once.
 *
 *        ●   Increase the height of the tower by K
 *        ●   Decrease the height of the tower by K
 *
 *      Find out the minimum possible difference between the height of the shortest and tallest towers after
 *      you have modified each tower.
 *
 *      Note: It is compulsory to increase or decrease the height by K for each tower. After the operation,
 *            the resultant array should not contain any negative integers.
 *    Ex.
 *      Input : arr[] = {3, 9, 12, 16, 20}
 *              k = 3
 *      Output: 11
 *      Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.
 *                   The difference between the largest and the smallest is 17-6 = 11.
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_09_Minimize_the_Heights_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(getMinDiff(arr, k));
    }

    /// Solution
    static int getMinDiff(int[] arr, int k) {

        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        int l = arr[n-1];
        int s = arr[0];
        int ans = l-s;

        for (int i = 1;i < n;i++){
            l = Math.max(arr[n-1]-k, arr[i-1]+k);
            s = Math.min(arr[0]+k, arr[i]-k);
            if (s < 0) continue;
            ans = Math.min(ans, l-s);
        }

        return ans;
    }
}
