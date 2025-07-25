package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/combination-sum-ii-1664263832/1
 *
 * # Combination Sum II    
 *
 *   Q. Given an array arr[] and a target, your task is to find all unique combinations in the array where \
 *      the sum is equal to target. Each number in arr[] may only be used once in the combination.
 *
 *      You can return your answer in any order.
 *   Ex.
 *      Input : arr[] = [1, 2, 3, 3, 5]
 *              target =7
 *      Output: [[1, 3, 3], [2, 5]]
 *      Explanation: Total number of possible combinations are 2.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Recursion_04_Combination_Sum_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Enter target: ");
        int taget = sc.nextInt();

        System.out.println("Unique Combinations: ");
        System.out.println(uniqueCombinations(arr, taget));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        // potd.code.hub
        int n = arr.length;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        Arrays.sort(arr);
        solve(0, target, n, arr, new ArrayList<>(), set);

        return new ArrayList<>(set);
    }
    private static void solve(int idx, int target, int n, int[] arr, ArrayList<Integer> list, HashSet<ArrayList<Integer>> set) {
        // base case
        if (target == 0) {
            set.add(new ArrayList<>(list));
            return;
        }
        if (idx >= n) return;

        // recursive work
        if (arr[idx] <= target) {
            list.add(arr[idx]);
            solve(idx+1, target-arr[idx], n, arr, list, set);
            list.remove(list.size()-1);
        }
        solve(idx+1, target, n, arr, list, set);
    }
}
