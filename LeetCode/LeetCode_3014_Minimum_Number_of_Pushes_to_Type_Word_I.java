package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 *
 * # LC. 3014. Minimum Number of Pushes to Type Word I
 *
 *   Q. You are given a string word containing distinct lowercase English letters.
 *
 *      Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used
 *      to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key
 *      one time to type "a", two times to type "b", and three times to type "c" .
 *
 *      It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped
 *      to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum
 *      number of times the keys will be pushed to type the string word.
 *
 *      Return the minimum number of pushes needed to type word after remapping the keys.
 *
 *      An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not
 *      map to any letters.
 *
 *    Ex.
 *      Input : word = "xycdefghij"
 *      Output: 12
 *      Explanation: The remapped keypad given in the image provides the minimum cost.
 *                     "x" -> one push on key 2
 *                     "y" -> two pushes on key 2
 *                     "c" -> one push on key 3
 *                     "d" -> two pushes on key 3
 *                     "e" -> one push on key 4
 *                     "f" -> one push on key 5
 *                     "g" -> one push on key 6
 *                     "h" -> one push on key 7
 *                     "i" -> one push on key 8
 *                     "j" -> one push on key 9
 *                   Total cost is 1 + 2 + 1 + 2 + 1 + 1 + 1 + 1 + 1 + 1 = 12
 *                   It can be shown that no other mapping can provide a lower cost.
 *
 *  Constraints:
 *        ◦ 1 <= word.length <= 26
 *        ◦ word consists of lowercase English letters.
 *        ◦ All letters in word are distinct.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3014_Minimum_Number_of_Pushes_to_Type_Word_I {

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
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-brute-force-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int approach_1(String word) {
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

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-mathematical-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(1)
SC : O(1)
*/
    static int minimumPushes(String word) {
        int n = word.length();
        int a = n >> 3;
        int b = n % 8;

        return (((a * (a + 1)) >> 1) << 3) + (a + 1) * b;
    }
}
