package LeetCode;/*
 *
 * https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/
 *
 * # 3306. Count of Substrings Containing Every Vowel and K Consonants II
 *
 *   Q. You are given a string word and a non-negative integer k.
 *
 *      Return the total number of substrings of word that contains every vowel('a', 'e', 'i', 'o' and 'u')
 *      at least once and exactly k consonants.
 *    Ex.
 *      Input : word = "aeiou", k = 0
 *      Output: 1
 *      Explanation: The only substring with every vowel and zero consonants is word[0..4], which is
 *                   "aeiou".
 */
import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_3306_Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("word: ");
        String s = sc.next();

        System.out.println("Number of consonants allowed: ");
        int k = sc.nextInt();

        System.out.println(countOfSubstrings(s, k));
    }

    /// Solution
    static long countOfSubstrings(String word, int k) {
        // @ sibasundarj8@gmail.com
        int n = word.length(), ans = 0;
        char[] s = word.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        int[] nextCons = new int[n];
        int cons = n;
        for (int i = n-1;i >= 0;i--){
            nextCons[i] = cons;
            if (!isVowel(s[i])) cons = i;
        }

        int i = 0, j = 0;
        cons = 0;
        while (j < n){
            char cur = s[j];
            if (isVowel(cur))
                map.put(cur, map.getOrDefault(cur, 0)+1);
            else cons++;

            while (cons > k){
                char pre = s[i++];
                if (isVowel(pre)){
                    map.put(pre, map.get(pre)-1);
                    if (map.get(pre) == 0) map.remove(pre);
                }
                else cons--;
            }

            while (cons == k && map.size() == 5){
                char pre = s[i++];
                ans += nextCons[j] - j;
                if (isVowel(pre)){
                    map.put(pre, map.get(pre)-1);
                    if (map.get(pre) == 0) map.remove(pre);
                }
                else cons--;
            }

            j++;
        }

        return ans;
    }
    private static boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
