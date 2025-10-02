package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/combination-sum-iii--111703/1
 *
 * # Unique K-Number Sum
 *
 *   Q. Given two integers n and k, the task is to find all valid combinations of k numbers that adds up to
 *      n based on the following conditions:
 *           •  Only numbers from the range [1, 9] used.
 *           •  Each number can only be used at most once.
 *
 *      Note: You can return the combinations in any order, the driver code will print them in sorted order.
 *   Ex.
 *      Input : n = 9, k = 3
 *      Output: [[1, 2, 6],
 *               [1, 3, 5],
 *               [2, 3, 4]]
 *      Explanation: There are three valid combinations of 3 numbers that sum to 9:
 *                   [1 ,2, 6], [1, 3, 5] and [2, 3, 4].
 *
 *  Constraints:
 *          1 ≤ n ≤ 50
 *          1 ≤ k ≤ 9
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_55_Unique_K_Number_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Possible " + k + " size combinations with sum " + n + " : ");
        System.out.println(combinationSum(n, k));
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // potd.code.hub
        boolean[] visited = new boolean[10];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if(k > n || k * 9 < n) return ans;
        getCombinations(n, k, visited, new ArrayList<>(), ans);

        return ans;
    }

    private static void getCombinations(int n, int k, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        // base case
        if (k == 0) {
            if (n == 0) ans.add(new ArrayList<>(list));
            return;
        }

        // self work
        int i = (!list.isEmpty()) ? list.getLast() : 0;
        while (++i <= 9) {
            if (!visited[i] && i <= n) {
                // use
                visited[i] = true;
                list.add(i);

                // recursive work
                getCombinations(n - i, k - 1, visited, list, ans);

                // backtrack
                list.removeLast();
                visited[i] = false;
            }
        }
    }
}
