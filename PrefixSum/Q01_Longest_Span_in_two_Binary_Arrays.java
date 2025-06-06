package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-span-with-same-sum-in-two-binary-arrays5142/1
 *
 * # Longest Span in two Binary Arrays
 *
 *   Q. Given two binary arrays, a1[] and a2[]. Find the length of longest common span (i, j) where j>= i such
 *      that a1[i] + a1[i+1] + .... + a1[j] =  a2[i] + a2[i+1] + ... + a2[j].
 *
 *    Ex.
 *      Input : a1[] = [0, 1, 0, 0, 0, 0]
 *              a2[] = [1, 0, 1, 0, 0, 1]
 *      Output: 4
 *      Explanation: The longest span with same sum is from index 1 to 4 following zero based indexing.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Q01_Longest_Span_in_two_Binary_Arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("<:---Number of elements must be same in both binary arrays---:>");

        System.out.println("Elements of array-1: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] arr = new int[n];
        int[] brr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Elements of array-2: ");
        for (int i = 0; i < n; i++) {
            brr[i] = sc.nextByte();
        }

        System.out.println("Size of longest span: " + longestCommonSum(arr, brr));
    }

    /// Solution
    static int longestCommonSum(int[] a1, int[] a2) {
        // potd.code.hub
        int n = a1.length, sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        /*
                        j
        works because   ∑ (a[i] + a[i+1] + ... + a[j]) - (b[i] + b[i+1] + ... + b[j]) = 0
                        i
        */
        for (int i = 0; i < n; i++) {
            sum += (a1[i] - a2[i]); // sum += a1[i] & sum -= a2[i]
            map.putIfAbsent(sum, i);

            if (map.containsKey(sum)) {
                int dist = i - map.get(sum);
                ans = Math.max(ans, dist);
            }
        }

        return ans;
    }
}
