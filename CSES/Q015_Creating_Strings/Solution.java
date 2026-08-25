package CSES.Q015_Creating_Strings;

import java.io.*;

public class Solution {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] fact = new int[10];

    static {
        fact[0] = 1;

        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine().trim();

        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int count = fact[n];

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            count /= fact[freq[i]];
        }

        bw.write(String.valueOf(count));
        bw.newLine();

        new Solution().printCombinations(0, n, freq, new char[n]);

        bw.flush();
    }

    private void printCombinations(int idx, int n, int[] freq, char[] temp) throws IOException {

        // Base case
        if (idx >= n) {
            bw.write(temp);
            bw.newLine();
            return;
        }

        // Try characters in alphabetical order
        for (int x = 0; x < 26; x++) {
            if (freq[x] == 0) continue;

            // use
            freq[x]--;

            temp[idx] = (char) (x + 'a');
            printCombinations(idx + 1, n, freq, temp);

            // backtrack
            freq[x]++;
        }
    }
}
