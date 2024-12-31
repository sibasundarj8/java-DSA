package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 *
 * # Longest Consecutive Subsequence
 *
 *   Q. Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such
 *      that elements in the subsequence are consecutive integers, the consecutive numbers can be in any
 *      order.
 *    Ex.
 *      Input : arr[] = [2, 6, 1, 9, 4, 5, 3]
 *      Output: 6
 *      Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest
 *                   consecutive subsequence.
 */
import java.util.HashSet;
import java.util.Scanner;

public class GFG_47_Longest_Consecutive_Subsequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(longestConsecutive(arr));
    }

    /// Solution
    static int longestConsecutive(int[] arr) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        int ans = 0;
        for (int i : arr){
            if (!set.contains(i-1)){
                int count = 0;
                for (int j = i;set.contains(j);j++) count++;
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
