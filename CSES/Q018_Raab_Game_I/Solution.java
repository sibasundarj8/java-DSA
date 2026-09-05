package CSES.Q018_Raab_Game_I;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a + b > n || (a == 0) ^ (b == 0)) {
                bw.write("NO\n");
                continue;
            }

            bw.write("YES\n");

            // A cards
            for (int j = 1; j <= n; j++) {
                if (j <= a) bw.write((j + b) + " ");
                else if (j <= (a + b)) bw.write((j - a) + " ");
                else bw.write(j + " ");
            }

            bw.newLine();

            // B cards
            for (int j = 1; j <= n; j++) {
                bw.write(j + " ");
            }

            bw.newLine();
        }

        bw.flush();
    }
}
