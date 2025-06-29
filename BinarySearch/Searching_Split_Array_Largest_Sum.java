package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1
 *
 * # Split Array Largest Sum
 *
 *   Q. Given an array arr[] and an integer k, divide the array into k contiguous subarrays such that the maximum
 *      sum among these subarrays is minimized. Find this minimum possible maximum sum.
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4], k = 3
 *      Output: 4
 *      Explanation: Optimal Split is [1, 2], [3], [4]. Maximum sum of all subarrays is 4, which is minimum possible
                     for 3 splits.
 */
import java.util.Scanner;

public class Searching_Split_Array_Largest_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("k : ");
        int k = sc.nextInt();

        System.out.println("minimized max_sum: " + splitArray(arr, k));
    }

    /// Solution
    static int splitArray(int[] arr, int expected) {
        // potd.code.hub
        int ans = -1;
        int i = 0, j = 0;
        for (int val : arr) {
            i = Math.max(i, val);
            j += val;
        }

        while (i <= j) {
            int mid = i + (j-i)/2;
            int actual = calculate(arr, mid);
            // the current limit of sum needs more number of sub-arrays then k,
            if (actual > expected) i = mid+1;    // then we need to grow othe sum.
            else {   // if this limit requireds equal or lesser number of sub-array then k,
                ans = mid;         // then it might be answer or any lower might be possible
                j = mid-1;
            }
        }

        return ans;
    }
    private static int calculate(int[] arr, int max) {
        int count = 1;
        int sum = 0;
      
        for (int val : arr) {
            sum += val;
            if (val > max) return Integer.MAX_VALUE;
            if (sum > max) {
                count++;
                sum = val;
            }
        }
      
        return count;
    }
}
