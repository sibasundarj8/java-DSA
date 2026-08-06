package CSES.Q013_Gray_Code;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int m = 1 << n;

        for (int i = 0; i < m; i++) {
            int code = i ^ (i >> 1);

            for (int j = n - 1; j >= 0; j--) {
                bw.write(((code >> j) & 1) == 1 ? '1' : '0');
            }

            bw.newLine();
        }

        bw.flush();
    }
}
