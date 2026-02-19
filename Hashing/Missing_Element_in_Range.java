package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/missing-element-in-range/1
 *
 * # Missing Element in Range
 *
 *   Q. Given an array arr[] of distinct integers and a range [low, high], find all the numbers within the range that are
 *      not present in the array. return the missing numbers in sorted order.
 *    Ex.
 *      Input : arr[] = [10, 12, 11, 15], low = 10, high = 15
 *      Output: [13, 14]
 *      Explanation: Numbers 13 and 14 lie in the range [10, 15] but are not present in the array.
 *
 *  Constraints:
 *          1 ≤ arr.size(), low, high ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Missing_Element_in_Range {

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

        System.out.print("Low: ");
        int low = sc.nextInt();

        System.out.print("High: ");
        int high = sc.nextInt();

        System.out.println("Missing elements in array: ");
        System.out.println(missingRange(arr, low, high));
    }

    /// Solution
    static ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // potd.code.hub
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>(n);
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int ele : arr) 
            if (ele >= low && ele <= high) 
                set.add(ele);
        
        for (int i = low; i <= high; i++) 
            if (!set.contains(i)) 
                list.add(i);

        return list;
    }
}
