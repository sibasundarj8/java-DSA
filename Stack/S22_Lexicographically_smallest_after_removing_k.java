package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/lexicographically-smallest-after-removing-k/1
 *
 *  # Lexicographically smallest after removing k
 *
 *   Q. Given a string s consisting of n lowercase characters. Return the lexicographically smallest string after removing
 *      exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is
 *      a power of 2, reduce k by half, else multiply k by 2. You can remove any k characters.
 *
 *      Note: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is
 *            empty return -1.
 *    Ex.
 *      Input : s = "fooland", k = 2
 *      Output: "and"
 *      Explanation: As the size of the string = 7 which is not a power of 2, hence k = 4. After removing 4 characters from
 *                   the given string, the lexicographically smallest string is "and".
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ k ≤ 10⁵
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class S22_Lexicographically_smallest_after_removing_k {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String word = sc.next();

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Lexicographically smallest string after removing k characters: ");
        System.out.println(lexicographicallySmallest(word, k));
    }

    /// Solution
    static String lexicographicallySmallest(String s, int k) {
        // potd.code.hub
        int n = s.length();
        k = (n & n-1) == 0 ? k/2 : k*2;

        if (k >= n) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}
