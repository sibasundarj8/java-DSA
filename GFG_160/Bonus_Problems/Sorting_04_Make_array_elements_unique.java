package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/0
 *
 * # Make array elements unique
 *
 *   Q. Given an integer array arr[ ], your task is to find the minimum number of increment operations
 *      required to make all the array elements unique. i.e. no value in the array should occur more than
 *      once. In one operation, a value can be incremented by 1 only.
 *
 *      Note: The answer will always fit into a 32-bit integer.
 *    Ex.
 *      Input : arr[] = [3, 2, 1, 2, 1, 7]
 *      Output: 6
 *      Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7]. It can be shown that it is
 *                   impossible for the array to have all unique values with 5 or less operations.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_04_Make_array_elements_unique {

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

        System.out.println(minIncrements(arr));
    }

    ///  Solution
    static int minIncrements(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1;i < n;i++){
            if (arr[i] <= arr[i-1]){
                ans += arr[i-1] - arr[i] + 1;
                arr[i] = arr[i-1] + 1;
            }
        }

        return ans;
    }
}
