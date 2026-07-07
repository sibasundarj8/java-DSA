package CSES.Q007_Two_Knights;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());

        for (long i = 1; i <= n; i++) {
            long total_cells = i * i;
            long total_ways = (total_cells * (total_cells - 1)) >> 1;
            long red_zone = (i >= 3) ? ((i - 2) * (i - 1) * 2) << 1 : 0;

            bw.write((total_ways - red_zone) + "\n");
        }

        bw.flush();
    }
}
