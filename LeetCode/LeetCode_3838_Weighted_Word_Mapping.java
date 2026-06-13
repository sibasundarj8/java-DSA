package LeetCode;/*
 *
 * https://leetcode.com/problems/weighted-word-mapping/
 *
 * # LC. 3838. Weighted Word Mapping
 *
 *   Q. You are given an array of strings words, where each string represents a word containing lowercase English letters.
 *
 *      You are also given an integer array weights of length 26, where weights[i] represents the weight of the ith lowercase
 *      English letter.
 *
 *      The weight of a word is defined as the sum of the weights of its characters.
 *
 *      For each word, take its weight modulo 26 and map the result to a lowercase English letter using reverse alphabetical
 *      order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
 *
 *      Return a string formed by concatenating the mapped characters for all words in order.
 *
 *    Ex.
 *      Input : words = ["abcd","def","xyz"],
 *              weights = [5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2]
 *      Output: "rij"
 *      Explanation:
 *                ◦ The weight of "abcd" is 5 + 3 + 12 + 14 = 34. The result modulo 26 is 34 % 26 = 8, which maps to 'r'.
 *                ◦ The weight of "def" is 14 + 1 + 2 = 17. The result modulo 26 is 17 % 26 = 17, which maps to 'i'.
 *                ◦ The weight of "xyz" is 7 + 7 + 2 = 16. The result modulo 26 is 16 % 26 = 16, which maps to 'j'.
 *              Thus, the string formed by concatenating the mapped characters is "rij".
 *
 *  Constraints:
 *        ◦ 1 <= words.length <= 100
 *        ◦ 1 <= words[i].length <= 10
 *        ◦ weights.length == 26
 *        ◦ 1 <= weights[i] <= 100
 *        ◦ words[i] consists of lowercase English letters.
 */

public class LeetCode_3838_Weighted_Word_Mapping {

    /// main Method
    public static void main(String[] args) {
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};

        System.out.println("String formed by concatenating the mapped characters for all words in order: ");
        System.out.println(mapWordWeights(words, weights));
    }

    /// Solution
    static String mapWordWeights(String[] words, int[] weights) {
        // potd.code.hub
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            int n = word.length();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                sum += weights[idx];
            }

            int rem = 25 - (sum % 26);
            sb.append((char) (rem + 'a'));
        }

        return sb.toString();
    }
}
