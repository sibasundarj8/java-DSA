package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 *
 * # Triplet Sum in Array
 *
 *   Q. Given an array arr[] and an integer target, determine if there exists a triplet in the array whose
 *      sum equals the given target.
 *
 *      Return true if such a triplet exists, otherwise, return false.
 *    Ex.
 *      Input : arr[] = [1, 2, 4, 3, 6, 7]
 *              target = 10
 *      Output: true
 *      Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10.
 */
import java.util.Arrays;
import java.util.Scanner;

public class TwoPointer_01_Triplet_Sum_in_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(hasTripletSum(arr, target));
    }

    /// Solution
    static boolean hasTripletSum(int[]arr, int target) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0;i < n-2;i++){
            int t = target - arr[i];
            int l = i+1, r = n-1;
            while (l < r){
                int sum = arr[l] + arr[r];
                if (sum < t) l++;
                else if (sum > t)r--;
                else return true;
            }
        }
        return false;
    }
}
