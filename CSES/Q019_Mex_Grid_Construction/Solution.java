package CSES.Q019_Mex_Grid_Construction;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write((i ^ j) + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
