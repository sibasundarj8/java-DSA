package Priority_Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/game-with-string4100/1
 *
 * # Game with String
 *
 *   Q. Given a string s consisting of lowercase alphabets and an integer k, your task is to find the minimum
 *      possible value of the string after removing exactly k characters.
 *
 *      The value of the string is defined as the sum of the squares of the frequencies of each distinct character
 *      present in the string.
 *    Ex.
 *      Input : s = "abbccc"
 *              k = 2
 *      Output: 6
 *      Explanation: We remove two 'c' to get the value as 12 + 22 + 12 = 6, or We remove one 'b' and one 'c' to
 *                   get the value 12 + 12 + 22 = 6.
 */

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ_Game_with_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String s = sc.next();

        System.out.println("K:");
        int k = sc.nextInt();

        System.out.println("Min Value: " + minValue(s, k));
    }

    /// Solution
/*-------------------------------------------------------Hash-Map-------------------------------------------------------*/
    static int minValue(String s, int k) {
        // potd.code.hub
        int n = s.length();
        int ans = 0;
        int max_freq = 0;

        // creating frequency array
        int[] frq = new int[26];
        for (int i = 0; i < n; i++)
            frq[s.charAt(i) -'a']++;

        // putting frequencies and frequency counts in a HashMap and calculating the max_freq.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : frq) {
            if (i > 0) {
                map.put(i, map.getOrDefault(i, 0) +1);
                max_freq = Math.max(max_freq, i);
            }
        }

        // removing k characters from max_freq and modifying max_freq.
        while (k > 0) {
            int remove = Math.min(k, map.get(max_freq));
            k -= remove;
            map.put(max_freq, map.get(max_freq) - remove);
            map.put(max_freq - 1, map.getOrDefault(max_freq - 1, 0) + remove);
            if (map.get(max_freq) == 0) {
                map.remove(max_freq);
                max_freq--;
            }
        }

        // calculating string value
        for (Integer i : map.keySet())
            ans += (i*i * map.get(i));

        return ans;
    }

/*----------------------------------------------------Priority-Queue----------------------------------------------------*/
    static int minValue2(String s, int k) {
        // potd.code.hub
        int n = s.length();
        int ans = 0;

        // creating frequency array
        int[] frq = new int[26];
        for (int i = 0; i < n; i++)
            frq[s.charAt(i) - 'a']++;

        // putting characters in a queue which prioritizing more frequent characters first.
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i : frq)
            if (i > 0) q.add(i);

        // removing k characters based on priority
        while (k > 0 && !q.isEmpty() && q.peek() != 0) {
            q.add(q.poll() - 1);
            k--;
        }

        // calculating string value
        while (!q.isEmpty()) {
            int val = q.poll();
            ans += (val * val);
        }

        return ans;
    }
}
