package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1
 *
 * # Count all triplets with given sum in sorted array
 *
 *   Q. Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices,
 *      such that arr[i] + arr[j] + arr[k] = target and i < j < k.
 *    Ex.
 *      Input : arr[] = [-3, -1, -1, 0, 1, 2]
 *              target = -2
 *      Output: 4
 *      Explanation: Two triplets that add up to -2 are:
 *              arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
 *              arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
 *              arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
 *              arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
 */
import java.util.Scanner;

public class GFG_51_Count_all_triplets_with_given_sum_in_sorted_array {

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
        sc.close();

        System.out.println(countTriplets(arr, target));
    }

    /// Solution
    static int countTriplets(int[] arr, int target) {
        // potd.ode.hub
        int n = arr.length;
        int count = 0;

        for (int i = 0;i < n-2;i++){
            int l = i+1, r = n-1;
            int t = target - arr[i]; //1
            while (l < r){
                int sum = arr[l] + arr[r];
                
                if (sum < t) l++;
                else if (sum > t) r--;
                else{
                    count++;
                    for (int temp = l+1;temp < r && arr[l] == arr[temp];temp++) count++;
                    r--;
                }
            }
        }

        return count;
    }
}
