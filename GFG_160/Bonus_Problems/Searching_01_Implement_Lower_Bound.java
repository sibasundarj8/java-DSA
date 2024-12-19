package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/implement-lower-bound/0
 *
 * # Implement Lower Bound
 *
 *   Q. Given a sorted array arr[] and a number target, the task is to find the lower bound of the target in
 *      this given array. The lower bound of a number is defined as the smallest index in the sorted array
 *      where the element is greater than or equal to the given number.
 *
 *      Note: If all the elements in the given array are smaller than the target, the lower bound will be the
 *            length of the array.
 *    Ex.
 *      Input : arr[] = [2, 3, 7, 10, 11, 11, 25]
 *              target = 9
 *      Output: 3
 *      Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to
 *                   9.
 */
import java.util.Scanner;

public class Searching_01_Implement_Lower_Bound {

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

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(lowerBound(arr, target));
    }

    /// Solution
    static int lowerBound(int[] arr, int target) {
        // potd.code.hub
        int i = 0, j = arr.length-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid] >= target) j = mid-1;
            else i = mid + 1;
        }

        return i;
    }
}
