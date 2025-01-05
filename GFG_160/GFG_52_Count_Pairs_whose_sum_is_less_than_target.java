package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1
 *
 * # Count Pairs whose sum is less than target
 *
 *   Q. Given an array arr[] and an integer target. You have to find the number of pairs in the array whose
 *      sum is strictly less than the target.
 *    Ex.
 *      Input : arr[] = [5, 2, 3, 2, 4, 1]
 *              target = 5
 *      Output: 4
 *      Explanation: There are 4 pairs whose sum is less than 5: (2, 2), (2, 1), (3, 1) and (2, 1).
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_52_Count_Pairs_whose_sum_is_less_than_target {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(countPairs(arr, target));
    }

    /// Solution
    static int countPairs(int []arr, int target) {
        // potd.code.hub
        int n = arr.length, count = 0;
        Arrays.sort(arr);

        int i = 0, j = n-1;
        while (i < j){
            int sum = arr[i] + arr[j];
            if (sum < target) count += j - i++;
            else j--;
        }

        return count;
    }
}
