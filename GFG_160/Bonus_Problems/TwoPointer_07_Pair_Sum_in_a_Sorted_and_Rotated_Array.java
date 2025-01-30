package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1
 *
 * # Pair Sum in a Sorted and Rotated Array
 *
 *   Q. Given an array of positive elements arr[] that is sorted and then rotated around an unknown
 *      point, the task is to check if the array has a pair with sum equals to a given target.
 *   Ex.
 *      Input : arr[] = [7, 9, 1, 3, 5]
 *              target = 6
 *      Output: true
 *      Explanation: arr[2] and arr[4] has sum equals to 6 which is equal to the target.
 */
import java.util.Scanner;

public class TwoPointer_07_Pair_Sum_in_a_Sorted_and_Rotated_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements must be sorted and rotated: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int t = sc.nextInt();

        System.out.println(pairInSortedRotated(arr, t));
    }

    /// Solution
    static boolean pairInSortedRotated(int[]arr, int target) {
        // potd.code.hub
        int point = gPoint(arr), n = arr.length, i = point, j = (point - 1 + n) % n;
        while (i != j){
            int sum = arr[i] + arr[j];
            if (sum == target)
                return true;
            if (sum < target) i = (i + 1) % n;
            else j = (j - 1 + n) % n;
        }
        return false;
    }
    private static int gPoint(int[]arr){
        int n = arr.length;
        for (int i = 0;i < n-1;i++)
            if (arr[i] > arr[i+1]) return i+1;
        return 0;
    }
}
