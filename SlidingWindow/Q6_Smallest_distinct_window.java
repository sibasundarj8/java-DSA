package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1
 *
 * # Smallest distinct window
 *
 *   Q. Given a string str, your task is to find the length of the smallest window that contains
 *      all the characters of the given string at least once.
 *    Ex.
 *      Input : str = "aabcbcdbca"
 *      Output: 4
 *      Explanation: Sub-String "dbca" has the smallest length that contains all the characters of
 *                   str.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q6_Smallest_distinct_window {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.next();

        System.out.println("Smallest distinct window: " + findSubString(s));
    }

    /// Solution
    static int findSubString(String str) {
        // potd.code.hub
        int n = str.length();
        int[] chars = new int[26];
        // count the number of distinct elements
        int totalCount = 0;
        int l = 0, r = 0;

        for (int i = 0;i < n;i++){
            int idx = str.charAt(i) - 'a';
            if (chars[idx] == 0) {
                totalCount++;
            }
            chars[idx]++;
        }

        Arrays.fill(chars, 0);

        int ans = n;
        int count = 0;

        while (l < n){
            int idx;
            while (count == totalCount && l < n){
                idx = str.charAt(l++) - 'a';
                if (chars[idx] == 1){
                    ans = Math.min(ans, r-l+1);
                    count--;
                }
                chars[idx]--;
            }
            while (count < totalCount && r < n){
                idx = str.charAt(r++) - 'a';
                if (chars[idx] == 0){
                    count++;
                }
                chars[idx]++;
            }
            if (r == n && count < totalCount){
                break;
            }
        }

        return ans;
    }
}
