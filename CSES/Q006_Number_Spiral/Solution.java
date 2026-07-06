package CSES.Q006_Number_Spiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
          
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
          
            long n = Math.max(r, c);
            long startingPoint = n * n + 1;
            long endingPoint = (n + 1) * (n + 1);
            boolean odd = (n & 1) == 1;

            if (r <= c) {
                if (odd) sb.append(startingPoint + r);
                else sb.append(endingPoint - r);
            } else {
                if (odd) sb.append(endingPoint - c);
                else sb.append(startingPoint + c);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
