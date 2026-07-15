package CSES.Q011_Coin_Piles;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long min = Math.min(a, b);
            b = Math.max(a, b);
            a = min;

            if (((a + b) % 3 == 0) && (a << 1) >= b) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
    }
}
