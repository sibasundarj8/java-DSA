package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/farthest-smaller-right/1
 *
 * # Farthest Smaller Right
 *
 *   Q. You are given an array arr[]. For each element at index i (0-based indexing), find the farthest index
 *      j to the right (i.e., j > i) such that arr[j] < arr[i]. If no such index exists for a given position,
 *      return -1 for that index. Return the resulting array of answers.
 *   Ex.
 *      Input : arr[] = [2, 5, 1, 3, 2]
 *      Output: [2, 4, -1, 4, -1]
 *      Explanation: arr[0] = 2: Farthest smaller element to the right is arr[2] = 1.
 *                   arr[1] = 5: Farthest smaller element to the right is arr[4] = 2.
 *                   arr[2] = 1: No smaller element to the right → -1.
 *                   arr[3] = 3: Farthest smaller element to the right is arr[4] = 2.
 *                   arr[4] = 2: No elements to the right → -1.
 *      Constraints:
 *          1 ≤ arr.size() ≤ 106
 *          1 ≤ arr[i] ≤ 106
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_Farthest_Smaller_Right {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        Arrays.setAll(arr, i -> Integer.parseInt(s[i]));

        System.out.println("Farthest smaller: ");
        System.out.println(farMin(arr));
    }

    /// Solution
    static ArrayList<Integer> farMin(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] rs = new int[n];

        rs[n - 1] = arr[n - 1];

        // making right smallest list
        for (int i = n - 2; i >= 0; i--) {
            rs[i] = Math.min(rs[i + 1], arr[i]);
        }

        // getting farthest smaller
        for (int i = 0; i < n; i++) {
            rs[i] = upperBound(i + 1, n - 1, arr[i] - 1, rs);
        }

        for (int i : rs) list.add(i);

        return list;
    }

    // upper bound (binary search)
    private static int upperBound(int s, int e, int target, int[] rs) {
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (rs[mid] <= target) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }
}
