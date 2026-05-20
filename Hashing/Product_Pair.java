package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/equal-to-product3836/1
 *
 * # Product Pair
 *
 *   Q. Given an integer array arr[] and an integer target, determine whether there exists a pair of elements in the array
 *      whose product is equal to target.
 *
 *      Return true if such a pair exists; otherwise, return false.
 *
 *    Ex.
 *      Input : arr[] = [10, 20, 9, 40], target = 400
 *      Output: true
 *      Explanation: As 10 * 40 = 400, the answer is true.
 *
 *  Constraints:
 *          2 ≤ arr.size ≤ 10⁵
 *          -108 ≤ arr[i] ≤ 10⁸
 *          -1018 ≤ target ≤ 10¹⁸
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Product_Pair {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.print("Product pair exists: ");
        System.out.println(isProduct(arr, target));
    }

    /// Solution
/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Sorting-+-Binary-Search-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n log n)
SC : O(1)
*/
    static boolean usingSorting(int[] arr, long target) {
        int n = arr.length;
        if (n <= 1) return false;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int ele = arr[i];

            if (ele == 0) {
                if (target == 0) return true;
                else continue;
            }

            if (target % ele == 0 && containsAnotherIndex(arr, target / ele, i)) {
                return true;
            }
        }

        return false;
    }

    // binary search
    private static boolean containsAnotherIndex(int[] arr, long target, int idx) {
        int i = 0;
        int j = arr.length - 1;
        int res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == target) {
                res = mid;
                break;
            }
            else if (arr[mid] < target) i = mid + 1;
            else j = mid - 1;
        }

        if (res != -1) {
            if (res != idx) return true;

            int x = res - 1;
            int y = res + 1;
            return x >= 0 && arr[x] == target || y < arr.length && arr[y] == target;
        }

        return false;
    }
/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Hashing-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(n)
*/
    static boolean isProduct(int[] arr, long target) {
        // potd.code.hub
        if (arr.length <= 1) return false;
        HashSet<Long> set = new HashSet<>();

        for (int ele : arr) {

            if (ele == 0) {
                if (target == 0) return true;
                else continue;
            }

            long goal = target / ele;

            if (set.contains(goal) && goal * ele == target) {
                return true;
            }

            set.add((long) ele);
        }

        return false;
    }
}
