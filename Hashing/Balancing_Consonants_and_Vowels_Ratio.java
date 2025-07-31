package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/balancing-consonants-and-vowels-ratio/1
 *
 * # Balancing Consonants and Vowels Ratio
 *
 *   Q. You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets.
 *      You need to find the number of balanced strings in arr[] which can be formed by concatenating one or
 *      more contiguous strings of arr[].
 *
 *      A balanced string contains the equal number of vowels and consonants.
 *   Ex.
 *      Input : arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
 *      Output: 4
 *      Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with equal consonants
 *                   and vowels.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Balancing_Consonants_and_Vowels_Ratio {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words: ");
        String[] arr = sc.nextLine().split(" ");

        System.out.println("Number of balanced subarray: " + countBalanced(arr));
    }

    /// Solution
    static int countBalanced(String[] arr) {
        // potd.code.hub
        int sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (String s : arr) {
            sum += getValue(s);
            if (map.containsKey(sum)) {
                ans += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    private static int getValue(String s) {
        int n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                ans++;
            } else ans--;
        }

        return ans;
    }
}
