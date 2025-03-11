package LeetCode;/*
 *
 * https://leetcode.com/problems/closest-prime-numbers-in-range/
 *
 * #2523. Closest Prime Numbers in Range
 *
 *   Q. Given two positive integers left and right, find the two integers num1 and num2 such that:
 *          left <= num1 < num2 <= right.
 *          Both num1 and num2 are prime numbers.
 *          Num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
 *          Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
 *
 *   Example 1:
 *      Input: left = 10, right = 19
 *      Output: [11,13]
 *      Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 *          The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
 *          Since 11 is smaller than 17, we return the first pair.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2523_Closest_Prime_Numbers_in_Range {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Num 1: ");
        int n = sc.nextInt();

        System.out.println("Num 2: ");
        int m = sc.nextInt();
 
        String ans = Arrays.toString(new Solution().closestPrimes(n, m));
        System.out.println(ans);
    }
}
class Solution{
    private static final int[] arr = new int[(int)(Math.pow(10,6)+1)];
    Solution(){
        int n = arr.length;
        if (arr[0] == 0){
            Arrays.fill(arr, 1);
            for (int i = 2;i < n;i++) {
                if (arr[i] == 1) {
                    for (long j = (long) i * i; j < n; j += i) {
                        arr[(int) j] = 0;
                    }
                }
            }
        }
    }
    /// Solution
    int[] closestPrimes(int left, int right) {
        int[] ans = {-1, -1};
        int f = -1;
        int s = -1;

        for (;left <= right;left++){
            if (left < 2) continue;
            if (arr[left] == 1){
                if (f == -1) f = left;
                else if (s == -1) s = left;
                else {

                    f = s;
                    s = left;
                }
                if (ans[1] == -1 || ans[1]-ans[0] > s-f){
                    ans[0] = f;
                    ans[1] = s;
                }
            }
        }
        if (ans[1] == -1) ans[0] = -1;

        return ans;
    }
}
