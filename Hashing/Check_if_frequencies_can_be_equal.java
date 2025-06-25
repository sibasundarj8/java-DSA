package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/check-frequencies4211/1
 *
 * # Check if frequencies can be equal
 *
 *   Q. Given a string s consisting only lowercase alphabetic characters, check whether it is possible to remove
 *      at most one character such that the  frequency of each distinct character in the string becomes same.
 *      Return true if it is possible; otherwise, return false.
 *   Ex.
 *      Input : s = "xyyzz"
 *      Output: true
 *      Explanation: Removing one 'x' will make frequency of each distinct character to be 2.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Check_if_frequencies_can_be_equal {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String s = sc.next();

        System.out.println("Frequencies can be equal: " + sameFreq(s));
    }

    /// Solution
/*------------------------------------------------------Approach-1------------------------------------------------------*/
    static boolean sameFreq(String s) {
        // potd.code.hub
        int n = s.length();
        if (n == 1) return true;
        int[] freq = new int[26];

        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 'a']++;

        HashMap<Integer, Integer> uniqueFreqCount = new HashMap<>();
        for (int i : freq)
            if (i > 0) uniqueFreqCount.put(i, uniqueFreqCount.getOrDefault(i, 0) +1);

        // Already the frequencies are same.
        if (uniqueFreqCount.size() == 1) return true;

        // Two unique frequencies means we have to check.
        if (uniqueFreqCount.size() == 2) {
            Integer[] array = uniqueFreqCount.keySet().toArray(new Integer[2]);

            //  frequency      | number character appears for this frequency
            int frq1 = array[0], cnt1 = uniqueFreqCount.get(frq1);
            int frq2 = array[1], cnt2 = uniqueFreqCount.get(frq2);

            // If any case there is a character which appears only once and by removing that we can equalize.
            if ((frq1 == 1 && cnt1 == 1) || (frq2 == 1 && cnt2 == 1)) return true;

            // We can remove only one character  &  more frequency must be the frequency of a single character.
            return (Math.abs(frq1 - frq2) == 1) && ((frq1 > frq2 && cnt1 == 1) || (frq2 > frq1 && cnt2 == 1));
        }

        // Three or more number of unique frequencies can never be equalized by changing only one character.
        return false;
    }
    
/*------------------------------------------------------Approach-2------------------------------------------------------*/
    static boolean sameFreq2(String s) {
        // potd.code.hub
        int n = s.length();
        if (n == 1) return true;
        int[] freq = new int[26];

        for (int i = 0;i < n;i++)
            freq[s.charAt(i) - 'a']++;

        Arrays.sort(freq);

        int idx = 0;
        while (idx < 26 && freq[idx] == 0) idx++;

        boolean flag = false;
        if (freq[idx] == 1) {
            idx++;
            flag = freq[idx] > 1;
        }
        
        int dif = 0, min = freq[idx];
        while (idx < 26) {
            dif += (freq[idx++] - min);
            if (dif >= 2) return false;
        }

        if (flag) return dif == 0;
        else return true;
    }
}
