package Queue;/*
 * 
 * https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
 * 
 * # Generate Binary Numbers (Easy)
 * 
 *   Q. Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.
 *   Ex.
 *      Input : n = 6
 *      Output: ["1", "10", "11", "100", "101", "110"]
 *      Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.
 * 
 * Constraints:
 *      1 ≤ n ≤ 10⁶
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_01_Generate_Binary_Numbers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.println("Binary numbers from 1 to " + n + " : " + generateBinary(n));
    }

    /// Solution
/*.................................................using bit manipulation................................................*/
    static ArrayList<String> bitMagic(int n) {
        // potd.code.hub
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();

            for (int t = i; t > 0; t /= 2)
                s.append(t % 2);

            ans.add(s.reverse().toString());
        }

        return ans;
    }

/*....................................................in-built method....................................................*/
    static ArrayList<String> inBuilt(int n) {
        // potd.code.hub
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            ans.add(Integer.toBinaryString(i));

        return ans;
    }

/*......................................................Using Queue......................................................*/
    static ArrayList<String> generateBinary(int n) {
        // potd.code.hub
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();

        queue.add("1");
    
        while (n-->0) {
            String cur = queue.poll();

            if (queue.size() < n) {
                queue.add(cur + 0);
                queue.add(cur + 1);
            }

            ans.add(cur);
        }

        return ans;
    }
}
