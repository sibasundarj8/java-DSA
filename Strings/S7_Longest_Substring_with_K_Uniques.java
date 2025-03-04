package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 *
 * # Longest Substring with K Uniques
 *
 *   Q. Given a string s, you need to print the size of the longest possible substring with exactly k
 *      unique characters. If no possible substring exists, print -1.
 *
 *      Ex-
 *      Input : s = "aabacbebebe", k = 3
 *      Output: 7
 *      Explanation: "cbebebe" is the longest substring with 3 distinct characters.
 */
import java.util.HashMap;
import java.util.Scanner;

public class S7_Longest_Substring_with_K_Uniques {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println("K:");
        int k = sc.nextInt();

        System.out.println(longestkSubstr(s, k));
    }

    /// Solution
    static int longestkSubstr(String s, int k) {
        // potd.code.hub
        int n = s.length(), ans = -1;
        HashMap<Character, Integer> map = new HashMap<>(k+1);
        int start = 0;
        for (int i = 0;i < n;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k){
                char temp = s.charAt(start++);
                map.put(temp, map.get(temp)-1);
                if (map.get(temp) <= 0) map.remove(temp);
            }
            if (map.size() == k) ans = Math.max(ans, i-start+1);
        }

        return ans;
    }
}
