package Strings;/*
 *
 *  # Max Distance
 *
 *   Q. You are given a string S and a character X. Return the maximum distance between any two occurrences
 *      of x in the string s.
 *
 *      The distance between two occurrences of a character is defined as the total number of Distinct
 *      characters between them, excluding white spaces and the character X itself. Return -1 if X doesn't
 *      exist in the string S or occurs only Once.
 *    Ex.
 *      Input : S = "haryana"
 *              X = 'a'
 *      Output: 3
 *      Explanation: The indices of 'a' in the string S are [1, 4, 6]. The substring between the first and
 *                  second 'a' is "ry", with 2 distinct characters. The substring between the first and third
 *                  'a' is "ryan", with 3 distinct characters other than 'a'. The substring between the second
 *                  and third 'a' is "n", with 1 distinct character. Hence, the maximum distance is 3.
 */
import java.util.Scanner;

public class S6_Max_Distance {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.nextLine();

        System.out.println("Char: ");
        char ch = sc.next().charAt(0);


    }

    /// Solution
    public static int maxDistance(String s, char x) {
        // potd.code.hub
        int n = s.length();

        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) == x && s.charAt(j) == x) break;
            if (s.charAt(i) != x) i++;
            if (s.charAt(j) != x) j--;
        }
        if (i > j) return -1;

        return dist(s.substring(i, j)) - 1;
    }
    private static int dist(String s) {
        int n = s.length();
        int[] arr = new int[52];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') continue;
            int idx = (int) s.charAt(i) < 97 ? s.charAt(i) - 65 : s.charAt(i) - 71;
            arr[idx]++;
        }

        for (int i : arr) {
            if (i != 0) ans++;
        }

        return ans;
    }
}
