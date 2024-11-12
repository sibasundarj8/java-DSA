/*
 *   Q. Given a string of characters, find the length of the longest proper prefix which is also a
 *      proper suffix.
 *
 *       NOTE: Prefix and suffix can be overlapping, but they should not be equal to the entire string.
 *    Ex :
 *        Input: str = "sibasundarsiba"
 *        Output: 4
          Explanation: "siba" is the longest proper prefix and suffix.
 */
package GFG;

import java.util.Scanner;

public class POTD_Longest_Prefix_Suffix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word :");
        String str = sc.next();

        System.out.println(lps(str));
    }
    static int lps(String str) {
        // potd.code.hub
        int n = str.length();
        int p = 0;
        int s = 1;
        int[]ans = new int[n];

        while (s < n){
            char a = str.charAt(p);
            char b = str.charAt(s);
            //  match
            if (a == b){
                ans[s] = p+1;
                p++;s++;
            }
            //  not match
            else {
                if (p == 0) ans[s++] = 0;
                else p = ans[p-1];
            }
        }

        return ans[n-1];
    }
}