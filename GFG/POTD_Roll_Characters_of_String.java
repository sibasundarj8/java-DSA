package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/roll-the-characters-of-a-string2127/1
 *
 * # Roll Characters of String
 *
 *   Q. Given a string s consisting of lowercase English letters and an integer array roll[], perform a sequence
 *      of roll operations on the string.
 *
 *      For each value roll[i], increment each of the first roll[i] characters of the string by 1 in the English
 *      alphabet. After 'z', the character wraps around to 'a'.
 *
 *      Return the final string after applying all roll operations.
 *
 *      Note: A roll operation affects the current state of the string, including all previous modifications.
 *
 *    Ex.
 *      Input : s = "bca", roll[] = [1, 2, 3]
 *      Output: eeb
 *      Explanation: Initially, s = "bca"
 *                     ◦ roll[0] = 1: Roll the first 1 character. "bca" -> "cca"
 *                     ◦ roll[1] = 2: Roll the first 2 characters. "cca"-> "dda"
 *                     ◦ roll[2] = 3: Roll the first 3 characters. "dda" -> "eeb"
 *                   After applying all the roll operations, the final string is "eeb".
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size(), roll.size() ≤ 10⁵
 *        ◦ 1 ≤ roll[i] ≤ s.size()
 *        ◦ s consists only of lowercase English alphabets
 */

import java.util.Scanner;

public class POTD_Roll_Characters_of_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S : ");
        String s = sc.nextLine();

        System.out.print("roll[] : ");
        String[] r = sc.nextLine().split(" ");

        int n = r.length;
        int m = s.length();
        int[] roll = new int[n];

        for (int i = 0; i < n; i++) {
            roll[i] = Integer.parseInt(r[i]);

            if (roll[i] > m || roll[i] < 1) {
                throw new IllegalArgumentException("Invalid Input!!");
            }
        }

        System.out.println("Final string after applying all roll operations:");
        System.out.println(findRollOut(s, roll));
    }

    /// Solution
    static String findRollOut(String s1, int[] roll) {
        // potd.code.hub
        char[] s = s1.toCharArray();
        int n = s.length;
        int[] idxRoll = new int[n];

        for (int r : roll) {
            idxRoll[r - 1]++;
        }

        int curRoll = 0;

        for (int i = n - 1; i >= 0; i--) {
            curRoll += idxRoll[i];
            char cur = (char) ((s[i] - 'a' + curRoll) % 26 + 'a');
            s[i] = cur;
        }

        return String.valueOf(s);
    }
}
