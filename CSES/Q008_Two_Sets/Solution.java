package CSES.Q008_Two_Sets;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        long totalSum = (n * (n + 1L)) >> 1;

        if ((totalSum & 1) == 1) {
            bw.write("NO\n");
            bw.flush();
            return;
        }

        int set1Size = 0;
        boolean[] set1 = new boolean[n + 1];
        long target = totalSum >> 1;

        for (int i = n; i > 0; i--) {
            if (i <= target) {
                target -= i;
                set1[i] = true;
                set1Size++;
                if (target == 0) break;
            }
        }

        bw.write("YES\n");
        bw.write(String.valueOf(set1Size));
        bw.write('\n');

        for (int i = 1; i <= n; i++) {
            if (set1[i]) {
                bw.write(String.valueOf(i));
                bw.write(' ');
            }
        }

        bw.write('\n');
        bw.write(String.valueOf(n - set1Size));
        bw.write('\n');

        for (int i = 1; i <= n; i++) {
            if (!set1[i]) {
                bw.write(String.valueOf(i));
                bw.write(' ');
            }
        }

        bw.write('\n');
        bw.flush();
    }
}
