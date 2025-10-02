package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
 *
 *   Q. Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array
 *      in sorted order.
 *
 *      Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and
 *            Ai > Bi.
 *    Ex.
 *      Input : arr[] = [1, 3, 3]
 *      Output: [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
 *      Explanation: These are the only possible distinct permutations for the given array.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 9
 */

import java.util.*;

public class Recursion_54_All_Unique_Permutations_of_an_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        // Answer
        ArrayList<ArrayList<Integer>> ans = uniquePerms(arr);

        System.out.println("All combinations: ");
        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    /// Solution
/*........................................Brute-Force--(Recursion-&-Backtracking)........................................*/
    static ArrayList<ArrayList<Integer>> bruteForce(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Set<ArrayList<Integer>> ans = new LinkedHashSet<>(); // used to avoid duplications
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);
        for (int i : arr) list.add(i);

        getCombinations(0, n, ans, list);

        return new ArrayList<>(ans);
    }

    private static void getCombinations(int i, int n, Set<ArrayList<Integer>> ans, ArrayList<Integer> list) {
        // base case
        if (i >= n - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }

        getCombinations(i + 1, n, ans, list);

        for (int x = i; x < n; x++) {
            if (list.get(i) != list.get(x)) {
                int temp = list.remove(x);
                list.add(i, temp);

                getCombinations(i + 1, n, ans, list);

                temp = list.remove(i);
                list.add(x, temp);
            }
        }
    }

/*.........................................Optimized--(Recursion-&-Backtracking).........................................*/
    static ArrayList<ArrayList<Integer>> optimized(int[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];

        Arrays.sort(arr);
        rec(n, arr, list, ans, visited);

        return ans;
    }

    private static void rec(int n, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans, boolean[] visited) {
        // base case
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // self work
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // avoiding duplicate branches
                if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

                // use
                list.add(arr[i]);
                visited[i] = true;

                // recursive work
                rec(n, arr, list, ans, visited);

                //backtrack
                list.removeLast();
                visited[i] = false;
            }
        }
    }

/*.............................................Optimized--(Next-Permutation).............................................*/
    // getting all unique combination by using the getting all permutation.
    static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);
        for (int x : arr) list.add(x);

        do { // getting the next permutation until it becomes largest one
            ans.add(new ArrayList<>(list));
        } while (nextPermutation(list));

        return ans;
    }

    // logic to get next permutation
    private static boolean nextPermutation(ArrayList<Integer> list) {
        // potd.code.hub
        int n = list.size();
        int beg = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                beg = i;
                break;
            }
        }

        for (int i = n - 1; i > beg; i--) {
            if (list.get(i) > list.get(beg)) {
                int temp = list.get(i);
                list.set(i, list.get(beg));
                list.set(beg++, temp);
                reverse(list, beg);
                return true;
            }
        }

        return false;
    }

    private static void reverse(ArrayList<Integer> list, int start) {
        int end = list.size() - 1;

        while (start < end) {
            int temp = list.get(start);
            list.set(start++, list.get(end));
            list.set(end--, temp);
        }
    }
}
