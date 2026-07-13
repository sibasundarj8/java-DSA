package CSES.Q010_Trailing_Zeros;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        long count = 0;
        long base = 5;

        while (n >= base) {
            count += n / base;
            base *= 5;
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }
}
