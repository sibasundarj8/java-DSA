package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/0
 *
 * # Sum Pair closest to target
 *
 *   Q. Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose
 *      sum is closest to target.
 *
 *      Note: Return the pair in sorted order and if there are multiple such pairs return the pair with
 *            maximum absolute difference. If no such pair exists return an empty array.
 *    Ex.
 *      Input : arr[] = [5, 2, 7, 1, 4]
 *              target = 10
 *      Output: [2, 7]
 *      Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and
 *                   (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GFG_53_Sum_Pair_closest_to_target {

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

        System.out.println(sumClosest(arr, target));
    }

    /// Solution
    static List<Integer> sumClosest(int[] arr, int target) {
        // potd.code.hub
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = arr.length-1, close = Integer.MAX_VALUE;
        
        while (i < j){
            int sum = arr[i] + arr[j];
            int rem = Math.abs(target - (arr[i]+arr[j]));
            if (rem < close){
                close = Math.min(close, rem);
                ans = Arrays.asList(arr[i], arr[j]);
            }
            if (sum < target) i++;
            else j--;
        }

        return ans;
    }
}
