package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
 *
 * # Largest number in K swaps
 *
 *   Q. Given a number k and string s of digits denoting a positive integer, build the largest number possible
 *      by performing swap operations on the digits of s at most k times.
 *   Ex.
 *      Input : s = "1234567"
 *              k = 4
 *      Output: 7654321
 *      Explanation: Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally
 *                   3 with 5
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Recursion_49_Largest_number_in_K_swaps {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number: ");
        String s = sc.next();

        System.out.println("k : ");
        int k = sc.nextInt();

        System.out.println(findMaximumNum(s, k));
    }

    /// Solution
/*  
    // incorrect
    static String findMaximumNum(String s, int k) {
        // potd.code.hub
        int n = s.length();
        Pair[] sPair = new Pair[n];

        for (int i = 0; i < n; i++) {
            sPair[i] = new Pair(s.charAt(i) - '0', i);
        }

        Pair[] oPair = sPair.clone();

        Comparator<Pair> comparator = (Pair p, Pair q) -> {
            int ans = Integer.compare(q.ele, p.ele);
            if (q.ele == p.ele){
                ans = q.idx - p.idx;
            }
            return ans;
        };

        Arrays.sort(sPair, comparator);

        for (int i = 0; i < n; i++) {
            if (k == 0) break;
            int dig = oPair[i].ele;
            if (dig != sPair[i].ele) {
                k--;
                swap(oPair, i, sPair[i].idx);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Pair p : oPair) {
            ans.append(p.ele);
        }

        return ans.toString();
    }

    private static class Pair {
        int ele, idx;

        Pair(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }
    }

    private static void swap (Pair[] arr, int i, int j) {
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        arr[i].idx = i;
        arr[j].idx = j;
    }
*/
    // correct
    static String findMaximumNum(String s, int k) {
        // potd.code.hub
        char[] arr = s.toCharArray();
        int n = arr.length;
        char[] ans = new char[n];

        solve(arr, ans, n, 0, k);

        return (ans[0] == 0) ? new String(arr) : new String(ans);
    }

    private static void solve(char[] arr, char[] ans, int n, int start, int k) {
        // base case
        if (k == 0 || start == n - 1) {
            return;
        }
        // self-work
        int max = arr[start] - '0';
        for (int i = start + 1; i < n; i++) {
            max = Math.max(max, arr[i] - '0');
        }
        for (int i = start + 1; i < n; i++) {
            int cur = arr[i] - '0';
            if (cur == max) {
                swap(arr, start, i);
                if (isValid(arr, ans)) {
                    System.arraycopy(arr, 0, ans, 0, n);
                }
                // recursive call
                solve(arr, ans, n, start + 1, k - 1);
                // backtracking
                swap(arr, start, i);
            }
        }
        solve(arr, ans, n, start + 1, k);
    }

    private static boolean isValid(char[] arr, char[] ans) {
        return Arrays.compare(arr, ans) > 0;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
