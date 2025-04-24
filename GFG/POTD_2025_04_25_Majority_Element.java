package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/majority-element-1587115620/1
 *
 * # Majority Element
 *
 *   Q. Given an array arr[]. Find the majority element in the array. If no majority element
 *      exists, return -1.
 *
 *      Note: A majority element in an array is an element that appears strictly more than
 *            arr.size()/2 times in the array.
 *    Ex.
 *      Input : arr[] = [1, 1, 2, 1, 3, 5, 1]
 *      Output: 1
 *      Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.
 */

import java.util.Scanner;

public class POTD_2025_04_25_Majority_Element {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(majorityElement(arr));
    }

    /// Solution
    static int majorityElement(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        int count = 1;
        int num = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] != num) {
                if (count == 1) {
                    num = arr[i];
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }

        count = 0;
        for (int i : arr) {
            if (i == num) {
                count++;
            }
        }

        return (count > n / 2) ? num : -1;
    }
}
