package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/split-array-in-three-equal-sum-subarrays/0
 *
 * # Split array in three equal sum sub-arrays
 *
 *   Q. Given an array, arr[], determine if arr can be split into three consecutive parts such that
 *      the sum of each part is equal. If possible, return any index pair(i, j) in an array such that
 *      sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.
 *
 *      Note: Since multiple answers are possible, return any of them. The driver code will print true
 *            if it is correct otherwise, it will print false.
 *    Ex.
 *      Input : arr[] = [1, 3, 4, 0, 4]
 *      Output: true
 *      Explanation: [1, 2] is valid pair as sum of sub-array arr[0..1] is equal to sum of sub-array
 *                   arr[2..3] and also to sum of sub-array arr[4..4]. The sum is 4, so driver code
 *                   prints true.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Array_01_Split_array_in_three_equal_sum_subArrays {

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

        System.out.println(findSplit(arr));
    }

    /// Solution
    public static List<Integer> findSplit(int[] arr) {
        // potd.code.hub
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        // Finding Total
        int total = 0;
        for (int value : arr) {
            total += value;
        }

        // Checking partition possible or not
        if (n < 3 || total % 3 != 0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }

        /// finding the indices
        int sum = total / 3;
        int prefix = 0;
        int i = 0;
        int k = 0;

        // Finding i
        while (i < n-2) {
            prefix += arr[i];
            if (prefix == sum){
                k = prefix;
                break;
            }
            i++;
        }

        // Finding j
        int j = i+1;
        while (j < n-1) {
            prefix += arr[j];
            if (total - prefix == sum) break;
            j++;
        }

        // Checking indices are valid or not
        if (i != j && prefix-k == sum){
            ans.add(i);
            ans.add(j);
        }
        else {
            ans.add(-1);
            ans.add(-1);
        }
        
        // Returning Answer
        return ans;
    }
}
