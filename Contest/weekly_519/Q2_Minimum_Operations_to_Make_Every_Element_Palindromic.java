package Contest.weekly_519;/*
 *
 * https://leetcode.com/contest/weekly-contest-519/problems/minimum-operations-to-make-every-element-palindromic/
 *
 * # Q2. Minimum Operations to Make Every Element Palindromic
 *
 *   Q. You are given an integer array nums.
 *
 *      In one operation, you may choose an index i and either increment or decrement nums[i] by 2.
 *
 *      Return the minimum number of operations required to make every element in nums a positive palindromic integer.
 *      Different elements may be changed into different palindromic integers.
 *
 *      An integer is a palindrome if it reads the same forward and backward. For example, 121 is a palindrome while
 *      123 is not.
 *
 *    Ex.
 *      Input : nums = [10, 12, 14, 16]
 *      Output: 9
 *      Explanation:
 *              One optimal sequence of operations is:
 *                ◦ Decrement nums[0] by 2 once to change it from 10 to 8.
 *                ◦ Decrement nums[1] by 2 twice to change it from 12 to 8.
 *                ◦ Decrement nums[2] by 2 three times to change it from 14 to 8.
 *                ◦ Increment nums[3] by 2 three times to change it from 16 to 22.
 *
 *              After 1 + 2 + 3 + 3 = 9 operations, nums = [8, 8, 8, 22], and every element is a positive palindromic
 *              integer.
 *
 *              It can be shown that fewer than 9 operations cannot achieve this.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 */

import java.util.ArrayList;
import java.util.List;

public class Q2_Minimum_Operations_to_Make_Every_Element_Palindromic {

    /// Solution
    private static final List<Long> ODD_PALINDROMES = new ArrayList<>();
    private static final List<Long> EVEN_PALINDROMES = new ArrayList<>();

    static {
        for (long i = 1; i <= 7; i += 2) {
            ODD_PALINDROMES.add(i);
            EVEN_PALINDROMES.add(i + 1);
        }

        ODD_PALINDROMES.add(9L);

        for (long i = 1; i <= 2000; i++) {
            // even len
            long palindrome = join(i, i);

            if ((palindrome & 1) == 1) {
                ODD_PALINDROMES.add(palindrome);
            } else {
                EVEN_PALINDROMES.add(palindrome);
            }

            // odd len
            for (int m = 0; m <= 9; m++) {
                palindrome = join(i * 10 + m, i);
                if ((palindrome & 1) == 1) {
                    ODD_PALINDROMES.add(palindrome);
                } else {
                    EVEN_PALINDROMES.add(palindrome);
                }
            }
        }

        ODD_PALINDROMES.sort(null);
        EVEN_PALINDROMES.sort(null);
    }

    private static long join(long x, long y) {
        while (y > 0) {
            long digit = y % 10;
            x = x * 10 + digit;
            y /= 10;
        }

        return x;
    }

    public long minOperations(int[] nums) {
        long ops = 0;

        for (int ele : nums) {
            List<Long> palindromes = ((ele & 1) == 1) ? ODD_PALINDROMES : EVEN_PALINDROMES;

            long smallerPalindrome = upperBound(palindromes, ele);
            long largerPalindrome = lowerBound(palindromes, ele);

            long dist = Math.min(largerPalindrome - ele, ele - smallerPalindrome);

            ops += (dist >> 1);
        }

        return ops;
    }

    private long lowerBound(List<Long> palindromes, long target) {
        int n = palindromes.size();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (palindromes.get(mid) >= target) j = mid - 1;
            else i = mid + 1;
        }

        return (i < n) ? palindromes.get(i) : (long) 1e12;
    }

    private long upperBound(List<Long> palindromes, long target) {
        int n = palindromes.size();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (palindromes.get(mid) <= target) i = mid + 1;
            else j = mid - 1;
        }

        return (j >= 0) ? palindromes.get(j) : (long) -1e12;
    }
}