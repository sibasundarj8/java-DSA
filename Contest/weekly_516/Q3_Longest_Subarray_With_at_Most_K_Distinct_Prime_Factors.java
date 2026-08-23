package Contest.weekly_516;/*
 *
 * https://leetcode.com/contest/weekly-contest-516/problems/longest-subarray-with-at-most-k-distinct-prime-factors/
 *
 * # Q3. Longest Subarray With at Most K Distinct Prime Factors
 *
 *   Q. You are given an integer array nums consisting of positive integers and an integer k.
 *
 *      The prime factor set of a subarray is the union of the distinct prime factors of all its elements.
 *
 *      Return the length of the longest subarray whose prime factor set contains at most k distinct prime factors.
 *      If no such subarray exists, return 0.
 *
 *    Ex.
 *      Input : nums = [7, 6, 10, 12, 11], k = 3
 *      Output: 3
 *      Explanation:
 *              Consider the subarray [6, 10, 12]:
 *                 ◦ The distinct prime factors of 6 are {2, 3}.
 *                 ◦ The distinct prime factors of 10 are {2, 5}.
 *                 ◦ The distinct prime factors of 12 are {2, 3}.
 *                 ◦ The union of these sets is {2, 3, 5}, which contains 3 distinct prime factors.
 *              No longer subarray satisfies the condition. Therefore, the answer is 3.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 2 <= nums[i] <= 10⁵
 *        ◦ 1 <= k <= 10⁴
 */

import java.util.HashMap;
import java.util.Map;

public class Q3_Longest_Subarray_With_at_Most_K_Distinct_Prime_Factors {

    /// Solution
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        Map<Integer, Integer> primeFactorFreqMap = new HashMap<>(k);

        int i = 0;

        for (int j = 0; j < n; j++) {
            updatePrimeFactorFreqMap(nums[j], primeFactorFreqMap, +1);
            while (primeFactorFreqMap.size() > k) {
                updatePrimeFactorFreqMap(nums[i], primeFactorFreqMap, -1);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }

    private void updatePrimeFactorFreqMap(int n, Map<Integer, Integer> primeFactorFreqMap, int delta) {
        int prime = 2;

        while (prime * prime <= n) {
            if ((n % prime) == 0) {
                primeFactorFreqMap.put(prime, primeFactorFreqMap.getOrDefault(prime, 0) + delta);

                if (primeFactorFreqMap.get(prime) == 0) {
                    primeFactorFreqMap.remove(prime);
                }

                while (n % prime == 0) {
                    n /= prime;
                }
            }
            prime++;
        }

        if (n > 1) {
            primeFactorFreqMap.put(n, primeFactorFreqMap.getOrDefault(n, 0) + delta);
            if (primeFactorFreqMap.get(n) == 0) {
                primeFactorFreqMap.remove(n);
            }
        }
    }
}