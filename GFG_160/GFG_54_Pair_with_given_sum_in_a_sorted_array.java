package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
 *
 * # Pair with given sum in a sorted array
 *
 *   Q. You are given an integer target and an array arr[]. You have to find number of pairs in arr[]
 *      which sums up to target. It is given that the elements of the arr[] are in sorted order.
 *
 *      Note: pairs should have elements of distinct indexes.
 *    Ex.
 *      Input : arr[] = [-1, 1, 5, 5, 7]
 *              target = 6
 *      Output: 3
 *      Explanation: There are 2 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
 */
import java.util.Scanner;

public class GFG_54_Pair_with_given_sum_in_a_sorted_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(countPairs(arr, target));
    }

    /// Solution
    static int countPairs(int[]arr, int target) {
        // potd.code.hub
        int i = 0, j = arr.length-1, count = 0;
        while (i < j){
            int sum = arr[i] + arr[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                count++;
                for (int t = i+1;t < j && arr[t] == arr[i];t++) count++;
                j--;
            }
        }
        return count;
    }
}
