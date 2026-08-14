package CSES.Q014_Tower_of_Hanoi;

import java.io.*;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        bw.write((1 << n) - 1 + "\n");

        solve(1, 2, 3, n);

        bw.flush();
    }

    private static void solve(int s, int m, int t, int n) throws IOException {
        // base case
        if (n == 0) return;

        // recursive work
        solve(s, t, m, n - 1);
        bw.write(s + " " + t + "\n");
        solve(m, s, t, n - 1);
    }
}
