package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1
 *
 * # Range Vowel Count Queries
 *
 *   Q. Given a string s and a 2D array queries[][], where each query consists of two integers l and r, find the number
 *      of vowels in the substring s[l....r] for each query. The substring includes both indices l and r.
 *
 *      Return an array containing the answers to all queries in the order they are given.
 *
 *    Ex.
 *      Input : s = "geeksforgeeks",
 *              queries[][] = [[1, 3],
 *                             [2, 4],
 *                             [1, 9]]
 *      Output: [2, 1, 4]
 *      Explanation:
 *              Query 1: "eek" has 2 vowels (e, e).
 *              Query 2: "eks" has 1 vowel (e).
 *              Query 3: "eeksforge" has 4 vowels (e, e, o, e).
 *
 *  Constraints:
 *        1 ≤ s.size(), queries.size() ≤ 105
 *        s consists only of lowercase English alphabets
 *        queries[i].size() = 2
 *        0 ≤ queries[i][0] ≤ queries[i][1] < s.size()
 */

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Range_Vowel_Count_Queries {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s: ");
        String s = sc.next();

        System.out.print("number of queries: ");
        int q = sc.nextInt();

        int[][] queries = new int[q][2];

        System.out.println("queries[]: (left, right) inclusive");
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.print("result: ");
        System.out.println(countVowels(s, queries));
    }

    /// Solution
    private static final int VOWEL_MASK;

    static {
        int mask = 0;
        char[] chars = {'a', 'e', 'i', 'o', 'u'};

        // setting all vowel positions 1

        for (char ch : chars) {
            int idx = ch - 'a';
            mask |= (1 << idx);
        }

        VOWEL_MASK = mask;
    }

    static ArrayList<Integer> countVowels(String s, int[][] queries) {
        // potd.code.hub
        int n = s.length();
        int[] preVowelCount = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            int isVowel = (VOWEL_MASK >>> idx) & 1;

            preVowelCount[i + 1] = preVowelCount[i] + isVowel;
        }

        // query calculation
        ArrayList<Integer> res = new ArrayList<>(queries.length);

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            int numberOfVowels = preVowelCount[r + 1] - preVowelCount[l];
            res.add(numberOfVowels);
        }

        return res;
    }
}
