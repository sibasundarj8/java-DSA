package CSES.Q021_Grid_Coloring_I;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    /// Solution
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] prev = new char[m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < m; j++) {
                char cur = row.charAt(j);

                for (char ch = 'A'; ch <= 'D'; ch++) {
                    if (cur == ch) continue;
                    if (prev[j] == ch) continue;
                    if (j > 0 && prev[j - 1] == ch) continue;

                    bw.write(ch);
                    prev[j] = ch;
                    break;
                }

            }
            bw.newLine();
        }

        bw.flush();
    }
}
