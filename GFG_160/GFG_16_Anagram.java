package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/anagram-1587115620/1
 *
 * # Anagram
 *
 *   Q. Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two
 *      given strings are an anagram of each other or not. An anagram of a string is another string that
 *      contains the same characters, only the order of characters can be different. For example, act and
 *      tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.
 *
 *      Note: You can assume both the strings s1 & s2 are non-empty.
 *    Ex.
 *      Input : s1 = "geeks"
 *              s2 = "kseeg"
 *      Output: true
 *      Explanation: Both the string have same characters with same frequency. So, they are anagrams.
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_16_Anagram {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("s1: ");
        String s1 = sc.next();

        System.out.println("s2: ");
        String s2 = sc.next();

        System.out.println(areAnagrams(s1, s2));
    }

    /// Solution
    static boolean areAnagrams(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        if (n != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0;i < n;i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0)-1);
        }

        for (int i = 0;i < n;i++){
            if (map.get(s1.charAt(i)) != 0 || map.get(s2.charAt(i)) != 0){
                return false;
            }
        }

        return true;
    }
}
