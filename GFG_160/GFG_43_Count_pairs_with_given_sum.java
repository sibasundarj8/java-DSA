package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/0
 *
 * # Count pairs with given sum
 *
 *   Q. Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums
 *      up to given target.
 *    Ex.
 *      Input : arr[] = [1, 5, 7, -1, 5]
 *              target = 6
 *      Output: 3
 *      Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5).
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_43_Count_pairs_with_given_sum {

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

        System.out.println(countPairs(arr, target));
    }

    /// Solution
    static int countPairs(int[]arr, int target) {
        // potd.code.hub
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            count += map.getOrDefault(target-i, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return count;
    }
}
