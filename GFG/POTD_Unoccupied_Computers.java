package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/unoccupied-computers-1646661078/1
 *
 * # Unoccupied Computers
 *
 *   Q. A cafe has n computers. The customer events are represented by a string s of uppercase English letters, where
 *      each distinct letter appears exactly twice:
 *        ◦ The first occurrence denotes the customer's arrival.
 *        ◦ The second occurrence denotes the customer's departure.
 *
 *      A customer is assigned a computer only if one is available at the time of arrival, otherwise the customer is
 *      rejected and does not use a computer.
 *
 *      Return the number of customers who could not be assigned a computer upon arrival.
 *
 *    Ex.
 *      Input : n = 3, s = "GACCBDDBAGEE"
 *      Output: 1
 *      Explanation: Only D will not be able to get any computer. So the answer is 1.
 *
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 26
 *        ◦ 1 ≤ s.size() ≤ 52
 *        ◦ s consists of uppercase English letters and each letter occurs exactly 2 times.
 */

import java.util.Scanner;

public class POTD_Unoccupied_Computers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("s: ");
        String s = sc.next();

        System.out.println("Number of customers who could not be assigned a computer: ");
        System.out.println(solve(n, s));
    }

    /// Solution
    static int solve(int n, String s) {
        // potd.code.hub
        int rejected = 0;
        int[] state = new int[26];
        /*
            0  → customer has not arrived yet
            1  → customer is currently using a computer
           -1  → customer was rejected
        */

        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';

            // Customer was previously rejected
            if (state[idx] == -1) continue;

            // Customer arrives
            if (state[idx] == 0) {
                if (n > 0) { // assign pc
                    n--;
                    state[idx] = 1;
                } else {    // discard if no pc available
                    rejected++;
                    state[idx] = -1;
                }
            }

            // Customer departs
            else {
                n++;
                state[idx] = 0;
            }
        }

        return rejected;
    }
}
