package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/exactly-one-swap--170637/1
 *
 * # Exactly one swap
 *
 *   Q. Given a string s, return the number of distinct strings that can be obtained by exactly one swap of two
 *      different indices (i < j).
 *    Ex.
 *      Input : s = "geek"
 *      Output: 6
 *      Explanation: After one swap, There are only 6 distinct strings possible.
 *                   (i.e "egek","eegk","geek","geke","gkee" and "keeg")
 */

import java.util.HashMap;
import java.util.Scanner;

public class String_Exactly_one_swap {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String s = sc.next();

        System.out.println("number of unique string possible by exactly one swap: " + countStrings(s));
    }

    /// Solution
    static int countStrings(String s) {
        // potd.code.hub
        int n = s.length(), ans = 0;
        boolean flag = false;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) > 1) flag = true;
            ans += (n - map.get(ch));
        }

        ans /= 2;

        return (flag) ? ans + 1 : ans;
    }
}
