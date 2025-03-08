package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 *
 * #2379. Minimum Recolors to Get K Consecutive Black Blocks
 *
 *   Q. You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B',
 *      representing the color of the ith block. The characters 'W' and 'B' denote the colors
 *      white and black, respectively.
 *
 *      • You are also given an integer k, which is the desired number of consecutive black blocks.
 *
 *      • In one operation, you can recolor a white block such that it becomes a black block.
 *
 *      • Return the minimum number of operations needed such that there is at least one occurrence
 *        of k consecutive black blocks.
 *
 *    Ex.
 *      Input : blocks = "WBBWWBBWBW", k = 7
 *      Output: 3
 *      Explanation: One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and
 *          4th blocks so that blocks = "BBBBBBBWBW".
 *          It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 *          Therefore, we return 3.
 */
import java.util.Scanner;

public class LeetCode_2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(minimumRecolors(s, k));
    }

    /// Solution
    static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        blocks = blocks.toUpperCase();
        int ans = k, white = 0;

        for (int i = 0;i < k;i++)
            if (blocks.charAt(i) == 'W') white++;

        for (int i = k;i < n;i++){
            if (blocks.charAt(i) != blocks.charAt(i-k)){
                ans = Math.min(ans, white);
                if (ans == 0) return ans;
                if (blocks.charAt(i) == 'W') white++;
                else if (blocks.charAt(i-k) == 'W') white--;
            }
        }

        return Math.min(ans, white);
    }
}
