package GFG_job_a_thon;/*
 *
 * https://practice.geeksforgeeks.org/contest/job-a-thon-46-hiring-challenge/problems
 *
 * # Towers and Jumps (job-a-thon)
 *
 *   Q. You are given two arrays:
 *
 *          • heights[], where heights[i] is the height of the i-th tower.
 *          • jumps[], where jumps[i] is the maximum number of jumps allowed for the i-th person.
 *
 *      The i-th person always starts on the i-th tower (at height heights[i]). From a tower, a person can only
 *      jump to the next immediate tower with a strictly greater height. Each person can make at most jumps[i]
 *      jumps, and no one can move beyond the last tower.
 *
 *      You are also given a query array q[]. For each query q[i], determine how many people can reach a tower
 *      with height at least q[i].   
 *
 *   Ex.
 *      Input : heights[] = [2, 4, 3, 5]
 *              jumps[] = [1, 2, 1, 3]
 *              queries[] = [3, 5]
 *      Output: [4, 3]
 *      Explanation:
 *              -> Person 1 starts at tower 1 (height 2). With 1 jump, they can move to tower 2 (height 4).
 *              -> Person 2 starts at tower 2 (height 4). With 1st jump -> tower 4 (height 5). (They still
 *                 have another jump but cannot go further.)
 *              -> Person 3 starts at tower 3 (height 3). With 1 jump, they can move to tower 4 (height 5).
 *              -> Person 4 starts at tower 4 (height 5). No need to jump, already at height 5.
 *          Now queries:
 *              -> For q = 3: persons {1, 2, 3, 4} can reach a tower of height >= 3 -> 4 people.
 *              -> For q = 5: persons {2, 3, 4} can reach a tower of height >= 5 -> 3 people.
 *
 *      Constraints:
 *              1 ≤ heights.size() = jumps.size(), queries.size() ≤ 10⁵
 *              1 ≤ heights[i], queries[i] ≤ 10⁹
 *              0 ≤ jumps[i] ≤ jumps.size()
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Towers_and_Jumps {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of both array (heights and jumps)");
        int n = sc.nextInt();

        int[] heights = new int[n];
        int[] jumps = new int[n];

        System.out.println("Enter height of Towers: ");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println("Enter jumps (how many times Ith ele can jump): ");
        for (int i = 0; i < n; i++) {
            jumps[i] = sc.nextInt();
        }

        sc.nextLine(); // cleaning the buffer
        System.out.println("Enter queries: ");
        String[] s = sc.nextLine().split(" ");

        n = s.length;
        int[] queries = new int[n];

        Arrays.setAll(queries, i -> Integer.parseInt(s[i]));

        System.out.println("Reachable count according to query: ");
        System.out.println(reachableCount(heights, jumps, queries));
    }

    /// Solution
    static ArrayList<Integer> reachableCount(int[] heights, int[] jumps, int[] queries) {
        // potd.code.hub
        int n = heights.length;
        int[] nxt = nextGreater(heights);
        ArrayList<Integer> ans = new ArrayList<>();
        int[] arr = new int[n];
      
        for (int i = 0; i < n; i++) arr[i] = i;

        for (int i = 0; i < n; i++) {
            int idx = i;
          
            while (nxt[idx] != -1 && jumps[i] > 0) {
                jumps[i]--;
                idx = nxt[idx];
                arr[i] = idx;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? -1 : heights[arr[i]];
        }

        Arrays.sort(arr);

        for (int i : queries) {
            ans.add(n - bs(arr, i));
        }

        return ans;
    }

    private static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            tmp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }

        return tmp;
    }

    private static int bs(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
