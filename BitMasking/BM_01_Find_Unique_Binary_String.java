package BitMasking;/*
 *
 * https://leetcode.com/problems/find-unique-binary-string?envType=daily-question&envId=2026-03-08
 *
 * # 1980. Find Unique Binary String
 *
 *   Q. Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length
 *      n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *    Ex.
 *      Input : nums = ["111", "011", "001"]
 *      Output: "101"
 *      Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *  Constraints:
 *          n == nums.length
 *          1 <= n <= 16
 *          nums[i].length == n
 *          nums[i] is either '0' or '1'.
 *          All the strings of nums are unique.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BM_01_Find_Unique_Binary_String {

    /// main Method
    public static void main(String[] args) {
        String[] nums = {"111", "011", "001"};
        System.out.println(backtracking(nums));
    }

    /// Solution
/*
✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘-Recursion-&-Backtracking-✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘
TC : O(2ⁿ)
SC : O(n)
*/
    static String backtracking(String[] nums) {
        int n = nums.length;

        Set<String> set = new HashSet<>(Arrays.asList(nums));

        flag = true;
        rec(n, "", set);

        return ans;
    }

    private static boolean flag = true;
    private static String ans = "";

    private static void rec(int size, String s, Set<String> set) {
        // base case
        if(size == 0) {
            if(!set.contains(s)) {
                flag = false;
                ans = s;
            }
            return;
        }

        // self work
        if(flag) {
            rec(size - 1, s + '0', set);
            rec(size - 1, s + '1', set);
        }
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Diagonal-Search-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n)
SC : O(1)
*/
    static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append((nums[i].charAt(i) == '1') ? '0' : '1');
        }

        return sb.toString();
    }
}
