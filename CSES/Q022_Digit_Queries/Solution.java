package CSES.Q022_Digit_Queries;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            long k = Long.parseLong(br.readLine().trim());
            bw.write(String.valueOf(solve(k)));
            bw.newLine();
        }

        bw.flush();
    }

    private static long solve(long k) {
        if (k < 10) return k;

        int dig = 2;
        long mul = 10L;
        long start = 10;
        long end = 9 + 9 * mul * dig;

        while (end < k) {
            dig++;
            mul *= 10;
            start = end + 1;
            end += 9 * mul * dig;
        }

        long orgIdx = k - start;
        long number = mul + orgIdx / dig;
        long digIdx = dig - 1 - (orgIdx % dig);

        while (digIdx > 0) {
            digIdx--;
            number /= 10;
        }

        return number % 10;
    }
}
