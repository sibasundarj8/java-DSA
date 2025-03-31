package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximize-partitions-in-a-string/1
 *
 * # Maximize partitions in a String
 *
 *   Q. Given a string s of lowercase English alphabets, your task is to return the maximum number of
 *      substrings formed, after possible partitions (probably zero) of s such that no two substrings
 *      have a common character.
 *    Ex.
 *      Input : s = "acbbcc"
 *      Output: 2
 *      Explanation: "a" and "cbbcc" are two substrings that do not share any characters between them.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_137_Maximize_partitions_in_a_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter String: ");
        String s = sc.next();

        System.out.println(maxPartitions(s));
    }

    /// Solution
    
/// Hashmap takes a little bit time to compute Hashcode.
/// Here I prefer to use a frequency array to avoid the computation.
    /*static int maxPartitions(String s) {
        // potd.code.hub
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = n-1;i >= 0;i--)
            map.putIfAbsent(s.charAt(i), i);

        int ans = 0, max = 0;
        for (int i = 0;i < n;i++){
            max = Math.max(max, map.get(s.charAt(i)));
            if (max == i) ans++;
        }

        return ans;
    }*/

    static int maxPartitions(String s) {
        // potd.code.hub
        int n = s.length();

        int[] map = new int[26];
        Arrays.fill(map, -1);

        for (int i = n - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (map[idx] == -1)
                map[idx] = i;
        }

        int ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, map[s.charAt(i) - 'a']);
            if (max == i) ans++;
        }

        return ans;
    }
}
