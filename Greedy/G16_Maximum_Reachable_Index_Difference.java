package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-reachable-index-difference/1
 *
 * # Maximum Reachable Index Difference
 *
 *   Q. Given a string s containing lowercase English alphabets.
 *
 *        ◦ Start from any index containing the character 'a' and perform jump operations.
 *        ◦ In each jump operation, move to any index on the right side whose character is the immediate next letter of
 *          the current character in the alphabet (i.e., 'a' to 'b', 'b' to 'c', 'c' to 'd', and so on).
 *        ◦ Continue performing jumps until no further jump is possible.
 *
 *      Find the maximum possible difference between the starting index and the ending index. If it is not possible to
 *      choose a starting index, return -1.
 *
 *    Ex.
 *      Input : s = "abcbzzd"
 *      Output: 6
 *      Explanation: Start from index 0 ('a'). Jump to index 1 ('b') because 'b' is the next alphabet character.
 *                   Jump to index 2 ('c') because 'c' is the next character after 'b'. Jump to index 6 ('d')
 *                   because 'd' is the next character after 'c'.
 *
 *  Constraints:
 *       ◦ 1 ≤ s.size() ≤ 10⁵
 */

import java.util.Scanner;

public class G16_Maximum_Reachable_Index_Difference {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S: ");
        String s = sc.next();

        System.out.println("Maximum possible difference: ");
        System.out.println(maxIndexDifference(s));
    }

    /// Solution
    static int maxIndexDifference(String s) {
        // potd.code.hub
        int n = s.length();
        int start = 0;
        int end = 0;
        boolean[] visited = new boolean[26];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (idx == 0) {
                if (!visited[0]) {
                    visited[0] = true;
                    start = i;
                    end = i;
                }
            } else if (visited[idx - 1]) {
                end = i;
                visited[idx] = true;
            }
        }

        if (!visited[0]) return -1;
        return end - start;
    }
}
