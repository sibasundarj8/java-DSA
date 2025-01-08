package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/count-quadruplets-with-given-sum/0
 *
 * # 4 Sum – Count quadruplets with given sum
 *
 *   Q. Given an array arr[] and an integer target, you need to find and return the count of quadruplets
 *      such that the index of each element of the quadruplet is unique and the sum of the elements is
 *      equal to target.
 *    Ex.
 *      Input : arr[] = [1, 1, 1, 1, 1]
 *              target = 4
 *      Output: 5
 *      Explanation: Three quadruplets with sum 4 are:
 *                  arr[0] + arr[1] + arr[2] + arr[3] = 1 + 1 + 1 + 1 = 4
 *                  arr[1] + arr[2] + arr[3] + arr[4] = 1 + 1 + 1 + 1 = 4
 *                  arr[0] + arr[2] + arr[3] + arr[4] = 1 + 1 + 1 + 1 = 4
 *                  arr[0] + arr[1] + arr[3] + arr[4] = 1 + 1 + 1 + 1 = 4
 *                  arr[0] + arr[1] + arr[2] + arr[4] = 1 + 1 + 1 + 1 = 4
 */
import java.util.HashMap;
import java.util.Scanner;

public class Hashing_04_4_Sum_Count_quadruplets_with_given_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(countSum(arr, target));
    }

    /// Solution
    static int countSum(int []arr, int target) {
        // potd.code.hub
        int n = arr.length, count = 0;
        if (n < 4) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0]+arr[1], 1);

        // for third element
        for (int i = 2;i < n-1;i++){
            // checking the sum of first 2 elements are available in our database or not.
            // sum of first 2 ele = target - (3rd + 4th)
            for (int j = i+1;j < n;j++) {
                int sum = arr[i] + arr[j];
                count += map.getOrDefault(target - sum, 0);
            }

            // Storing first 2 elements sum
            for (int j = 0;j < i;j++){
                int sum = arr[i] + arr[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        return count;
    }
}
