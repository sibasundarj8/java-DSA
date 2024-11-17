package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/second-largest3735/1
 *
 * # Second Largest
 *
 *   Q. Given an array of positive integers arr[], return the second-largest element from the array.
 *      If the second-largest element doesn't exist then return -1.
 *
 *      Note: The second largest element should not be equal to the largest element.
 *    Ex.
 *      Input : arr[] = [12, 35, 1, 10, 34, 1]
 *      Output: 34
 *      Explanation: The largest element of the array is 35 and the second-largest element is 34.
 */
import java.util.Scanner;

public class GFG_01_Second_Largest {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Array Elements :");
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Second Largest: ");
        System.out.println(getSecondLargest(arr));
    }

    /// Solution
    static int getSecondLargest(int[]arr) {
        // potd.code.hub
        int max = arr[0];
        int max2 = -1;

        for (int j : arr) {
            if (j > max) {
                max2 = max;
                max = j;
            } else if (j < max && j > max2) {
                max2 = j;
            }
        }

        return max2;
    }
}