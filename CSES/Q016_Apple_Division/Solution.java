package CSES.Q016_Apple_Division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] weights = new long[n];
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = Long.parseLong(st.nextToken());
            totalSum += weights[i];
        }

        long minDiff = Long.MAX_VALUE;
        long subsetSum, difference;

        // checking out all the possibilities using bit-mask
        for (int mask = 0; mask < (1 << n); mask++) {
            subsetSum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetSum += weights[i];
                }
            }

            difference = Math.abs(totalSum - 2 * subsetSum);
            minDiff = Math.min(minDiff, difference);
        }

        System.out.println(minDiff);
    }
}
