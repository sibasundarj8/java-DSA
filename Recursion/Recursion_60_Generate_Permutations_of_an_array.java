package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/generate-permutations-of-an-array/1
 *
 * # Generate Permutations of an array
 *
 *   Q. Given an array arr[] of unique elements. Generate all possible permutations of the elements in the array.
 *      Note: You can return the permutations in any order, the driver code will print them in sorted order.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3]
 *      Output: [[1, 2, 3],
 *               [1, 3, 2],
 *               [2, 1, 3],
 *               [2, 3, 1],
 *               [3, 1, 2],
 *               [3, 2, 1]]
 *      Explanation: There are 6 possible permutations (3! = 6) of the array.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Recursion_60_Generate_Permutations_of_an_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: (must be unique)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Permutation of " + Arrays.toString(arr) + " are: ");

        ArrayList<ArrayList<Integer>> ans = permuteDist(arr);

        for (ArrayList<Integer> list : ans)
            System.out.println(list);
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int ele : arr) {
            list.add(ele);
        }

        rec(arr.length - 1, list, ans);

        return ans;
    }

    private static void rec(int idx, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (idx == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i >= 0; i--) {
            int temp = list.get(i);
            list.set(i, list.get(idx));
            list.set(idx, temp);

            rec(idx - 1, list, ans);

            temp = list.get(i);
            list.set(i, list.get(idx));
            list.set(idx, temp);
        }
    }
}
