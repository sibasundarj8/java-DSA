package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/prime-number2314/1
 *
 * # Prime Number
 *
 *   Q. Given a number n, determine whether it is a prime number or not. A prime number is a number
 *      greater than 1 that has no positive divisors other than 1 and itself.
 *
 *      Ex.
 *          Input : n = 7
 *          Output: true
 *          Explanation: 7 has exactly two divisors: 1 and 7, making it a prime number.
 */
import java.util.Scanner;

public class Math_Prime_Numbers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number: ");
        int n = sc.nextInt();

        System.out.println(isPrime(n));
    }

    /// Solution
    static boolean isPrime(int n) {
        // potd.code.hub
        for (int i = 2;i*i <= n;i++)
            if (n%i == 0) return false;

        return true;
    }
}
