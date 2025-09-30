package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
 *
 * # Generate all binary strings
 *
 *   Q. Given an integer n. You need to generate all the binary strings of n characters representing bits.
 *      Note: Return the strings in  ascending order.
 *    Ex.
 *      Input : n = 3
 *      Output: [000, 001, 010, 011, 100, 101, 110, 111]
 *      Explanation: As each position can be either 0 or 1, the total possible combinations are 8.
 *
 *  Constraints:
 *      1 ≤ n ≤ 20
 */

import java.util.*;

public class Recursion_53_Generate_all_binary_strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.println("Possible binary strings: ");
        System.out.println(binstr(n));
    }

    /// Solution
/*................................................Recursion-&-Backtracking................................................*/
    static ArrayList<String> binstr(int n) {
        // potd.code.hub
        ArrayList<String> ans = new ArrayList<>();
        char[] str = new char[n];
        // initially str is filled with 0s.
        Arrays.fill(str, '0');

        binaryCombinations(str, 0, n, ans);

        return ans;
    }

    private static void binaryCombinations(char[] str, int i, int n, ArrayList<String> ans) {
        // base case
        if (i >= n) {
            ans.add(new String(str));
            return;
        }
        // recursive case
        binaryCombinations(str, i + 1, n, ans);
        str[i] = '1';
        binaryCombinations(str, i + 1, n, ans);
        str[i] = '0';
    }

/*...................................................Using-Queue--(BFS)..................................................*/
    static ArrayList<String> usingQueue(int n) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("0");
        q.add("1");

        while (q.peek().length() < n) {
            String cur = q.poll();
            q.add(cur + "0");
            q.add(cur + "1");
        }

        while (!q.isEmpty()) ans.add(q.poll());

        return ans;
    }

/*.................................................Using-Inbuilt-methods.................................................*/
    static ArrayList<String> inBuilt(int n) {
        ArrayList<String> ans = new ArrayList<>();
        int total = 1 << n;     // total number of possible combinations (2ⁿ)

        for (int i = 0; i < total; i++) {
            String binary = Integer.toBinaryString(i);
            ans.add("0".repeat(n - binary.length()) + binary);
        }

        return ans;
    }
}
