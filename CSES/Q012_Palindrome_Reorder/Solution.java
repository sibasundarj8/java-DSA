package CSES.Q012_Palindrome_Reorder;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().trim();

        int[] freq = new int[26];
        int oddCount = 0;

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            bw.write("NO SOLUTION");
            bw.flush();
            return;
        }

        char oddFreqChar = '$';

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            if ((freq[i] & 1) == 1) {
                oddFreqChar = (char) (i + 'A');
                continue;
            }
            bw.write(String.valueOf((char) (i + 'A')).repeat(freq[i] >> 1));
        }

        if (oddFreqChar != '$') bw.write(String.valueOf(oddFreqChar).repeat(freq[oddFreqChar - 'A']));

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0 || (freq[i] & 1) == 1) continue;
            bw.write(String.valueOf((char) (i + 'A')).repeat(freq[i] >> 1));
        }

        br.close();
        bw.close();
    }
}
