package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1
 *
 * # Sort by Set Bit Count
 *
 *   Q. Given an array arr[] of integers, sort the array (in descending order) according to count of set bits in binary
 *      representation of array elements.
 *
 *      Note: For integers having same number of set bits in their binary representation, sort according to their position
 *            in the original array i.e., a stable sort.
 *
 *    Ex.
 *      Input : arr[] = [5, 2, 3, 9, 4, 6, 7, 15, 32]
 *      Output: [15, 7, 5, 3, 9, 6, 2, 4, 32]
 *      Explanation: The integers in their binary representation are:
 *                      15 - 1111
 *                      7  - 0111
 *                      5  - 0101
 *                      3  - 0011
 *                      9  - 1001
 *                      6  - 0110
 *                      2  - 0010
 *                      4  - 0100
 *                      32 - 10000
 *                   hence the non-increasing sorted order is: [15], [7], [5, 3, 9, 6], [2, 4, 32]
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁶
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sort_by_Set_Bit_Count {

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

        System.out.println("Sorting according to set bit count: ");
        System.out.println(sortBySetBitCount(arr));
    }

    /// Solution
    static ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();

        for (int ele : arr) {
            list.add(ele);
        }

        list.sort(Comparator.comparingInt(a -> -Integer.bitCount(a)));

        return list;
    }
}
