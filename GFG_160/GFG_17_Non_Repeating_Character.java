package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
 *
 * # Non-Repeating Character
 *
 *   Q. Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character
 *      in s. If there is no non-repeating character, return '$'.
 *
 *      Note: When you return '$' driver code will output -1.
 *    Ex.
 *      Input : s = "geeksforgeeks"
 *      Output: 'f'
 *      Explanation: In the given string, 'f' is the first character in the string which does not repeat.
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class GFG_17_Non_Repeating_Character {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        Consumer<Character> ans = x -> {    // java 8
            if (x == '$') System.out.println(-1);
            else System.out.println(x);
        };

        ans.accept(nonRepeatingChar(s));
    }

    /// Solution
    static char nonRepeatingChar(String s) {
        // potd.code.hub
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0;i < n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0;i < n;i++){
            if (map.get(s.charAt(i)) == 1) return s.charAt(i);
        }

        return '$';
    }
}
