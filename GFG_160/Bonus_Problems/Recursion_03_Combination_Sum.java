package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/combination-sum-1587115620/1
 *
 * # Combination Sum
 *
 *   Q. Given an array arr[] and a target, your task is to find all unique combinations in the
 *      array where the sum is equal to target. The same number may be chosen from the array any
 *      number of times to make target.
 *
 *      You can return your answer in any order.
 *    Ex.
 *      Input : arr[] = [2, 4, 6, 8]
 *              target = 8
 *      Output: [[2 2 2 2] [2 2 4] [2 6] [4 4] [8]]
 *      Explanation: Total number of possible combinations are 5.
 */

import java.util.*;

public class Recursion_03_Combination_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Target: ");
        int t = sc.nextInt();

        System.out.println(combinationSum(arr, t));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        solve(0, n, arr, target, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
    }

    private static void solve(int idx, int n, int[] arr, int x, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        // base case
        if (x == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // recursive call
        for (int i = idx; i < n; i++) {
            if (arr[i] > x) break;
            temp.add(arr[i]);
            solve(i, n, arr, x - arr[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
