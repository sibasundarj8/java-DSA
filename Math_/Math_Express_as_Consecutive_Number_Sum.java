package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/consecutive-numbers-for-sum3132/1
 *
 * # Express as Consecutive Number Sum
 *
 *   Q. Given a number n, find whether n can be expressed as sum of two or more consecutive positive numbers.
 *    Ex.
 *      Input : n = 10
 *      Output: true
 *      Explanation: 10 can be expressed as 1 + 2 + 3 + 4.
 *
 *  Constraints:
 *      1 ≤ n ≤ 10⁹
 */

import java.util.Scanner;

public class Math_Express_as_Consecutive_Number_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N : ");
        int n = sc.nextInt();

        System.out.println("Can it be expressed as sum of consecutive positive numbers: ");
        System.err.println(isSumOfConsecutive(n) ? "YES" : "NO");
    }

    /// Solution
    static boolean isSumOfConsecutive(int n) {
        // potd.code.hub

    /*
        ## Proof
        
        n = a + a + 1 + a + 2 + a + 3 + ... + a + (k - 1) if k consecutive elements
        
        so,
        => n = k*a + (1 + 2 + 3 + 4 +...+ (k - 1))  {k*a because here k number of a's are present}
        => n = k*a + ((k-1) * k) / 2
        => n = (2ka + (k-1) * k) / 2
        => 2n = 2ak + (k-1) * k
        => 2n = k(2a + (k-1))

        see here 2n has two factors,
                    1. k
                    2. 2a + (k-1)  --> here 2a is always even

        factors are totally depends on k.

        if k is odd then :    2n = k(2a + (k-1)) ---> here 2a + (k-1) is divisible by 2.
                           => n = k * (2a + k - 1) / 2 ---> now (2a + k - 1) / 2 may odd or even.
                           notice still one factor (k) is odd.

        if k is even then :   2n = k(2a + (k-1)) ---> here k is divisible by 2 and 2a + (k-1) is odd.
                           => n = (k/2) * (2a + (k-1)) ---> now (k / 2) may odd or even.
                           notice here also one factor (2a + (k-1)) is odd.

        so every n which has an odd factor is possible to represent sum of consecutive numbers.
    */

        return (n & (n - 1)) != 0;
    }
}
