package Tree;/*
 *
 * https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1
 *
 * # Check if an Array is Max Heap
 *
 *   Q. Given an array arr[], determine whether it represents the level-order traversal of a valid max heap. Return true if
 *      it does; otherwise, return false.
 *
 *    Ex.
 *      Input : arr[] = [90, 15, 10, 7, 12, 2]
 *      Output: true
 *      Explanation: The given array represents the following tree. Each parent node is greater than or equal to its children,
 *                   so the max-heap property holds.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Scanner;

public class Tree_Check_if_an_Array_is_Max_Heap {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter level order of tree: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("Is valid maxheap: ");
        System.out.println(isMaxHeap(arr));
    }

    /// Solution
    static boolean isMaxHeap(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && arr[l] > arr[i]) return false;
            if (r < n && arr[r] > arr[i]) return false;
        }

        return true;
    }
}
