package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1
 *
 * # Maximum Index
 *
 *   Q. Given an array arr of positive integers. The task is to return the maximum of j - i subjected to
 *      the constraint of arr[i] < arr[j] and i < j.
 *   Ex.
 *      Input : arr[] = [34, 8, 10, 3, 2, 80, 30, 33, 1]
 *      Output: 6
 *      Explanation: In the given array arr[1] < arr[7] satisfying the required condition(arr[i] < arr[j])
 *                   thus giving the maximum difference of j - i which is 6(7-1).
 */
import java.util.Scanner;

public class Array_Maximum_Index {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(maxIndexDiff(arr));
    }

    /// Solution
    static int maxIndexDiff(int...arr) {
        // potd.code.hub
        int n = arr.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];

        int min = arr[0];
        int max = arr[n-1];
        for (int i = 0;i < n;i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[n-i-1]);
            lMin[i] = min;
            rMax[n-i-1] = max;
        }

        int i = 0, j = 0, ans = 0;
        while (j < n){
            if (lMin[i] <= rMax[j]) j++;
            else{
                ans = Math.max(ans, j-i-1);
                i++;
            }
        }

        return Math.max(ans, j-i-1);
    }
}
