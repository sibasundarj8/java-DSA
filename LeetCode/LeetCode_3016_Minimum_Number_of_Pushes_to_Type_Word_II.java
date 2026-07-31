package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
 *
 * # LC. 3016. Minimum Number of Pushes to Type Word II
 *
 *   Q. You are given a string word containing lowercase English letters.
 *
 *      Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used
 *      to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key
 *      one time to type "a", two times to type "b", and three times to type "c" .
 *
 *      It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to
 *      any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number
 *      of times the keys will be pushed to type the string word.
 *
 *      Return the minimum number of pushes needed to type word after remapping the keys.
 *
 *      An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map
 *      to any letters.
 *
 *    Ex.
 *      Input : word = "xyzxyzxyzxyz"
 *      Output: 12
 *      Explanation: The remapped keypad given in the image provides the minimum cost.
 *                   "x" -> one push on key 2
 *                   "y" -> one push on key 3
 *                   "z" -> one push on key 4
 *                   Total cost is 1 * 4 + 1 * 4 + 1 * 4 = 12
 *                   It can be shown that no other mapping can provide a lower cost.
 *                   Note that the key 9 is not mapped to any letter: it is not necessary to map letters to every key, but to map all the letters.
 *
 *  Constraints:
 *        ◦ 1 <= word.length <= 10⁵
 *        ◦ word consists of lowercase English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3016_Minimum_Number_of_Pushes_to_Type_Word_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word containing distinct lowercase English letters: ");
        String word = sc.nextLine();

        int n = word.length();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (visited[idx]) throw new IllegalArgumentException("Letters must be unique");
            visited[idx] = true;
        }

        System.out.println("Minimum number of pushes needed to type word after remapping the keys: ");
        System.out.println(minimumPushes(word));
    }

    /// Solution
    static int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int pushes = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            pushes += freq[i] * (((25 - i) >> 3) + 1);
        }

        return pushes;
    }
}
