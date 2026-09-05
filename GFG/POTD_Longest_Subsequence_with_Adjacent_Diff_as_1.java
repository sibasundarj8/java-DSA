package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-sub-sequence-such-that-difference-between-adjacents-is-one2558/1
 *
 * # Longest Subsequence with Adjacent Diff as 1
 *
 *   Q. Given an array arr[] with n elements. find the longest subsequence such that the absolute difference between
 *      adjacent elements is one.
 *
 *    Ex.
 *      Input : arr[] = [10, 9, 4, 5, 4, 8, 6]
 *      Output: 3
 *      Explanation: Longest subsequences with difference 1 are [10, 9, 8], [4, 5, 4] and [4, 5, 6].
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size(), arr[i] ≤ 10⁶
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class POTD_Longest_Subsequence_with_Adjacent_Diff_as_1 {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("int[] arr: ");
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Length of longest subsequence such that the absolute difference between adjacent elements is 1: ");
        System.out.println(longestSubseq(arr));
    }

    /// Solution
    static int longestSubseq(int[] arr) {
        // potd.code.hub
        int maxLen = 0;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int ele : arr) {
            int prev = dp.getOrDefault(ele - 1, 0);
            int next = dp.getOrDefault(ele + 1, 0);
            int curr = Math.max(prev, next) + 1;

            dp.put(ele, curr);
            maxLen = Math.max(maxLen, curr);
        }

        return maxLen;
    }
}
