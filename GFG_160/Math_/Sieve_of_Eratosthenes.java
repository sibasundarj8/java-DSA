package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1
 *
 * # Sieve of Eratosthenes
 *
 *   Q. Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.
 *
 *    Ex.
 *      Input : N = 35
 *      Output: 2 3 5 7 11 13 17 19 23 29 31
 *      Explanation: Prime numbers less than equal to 35 are
 *                   2, 3, 5, 7, 11, 13, 17, 19, 23, 29 and 31.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sieve_of_Eratosthenes {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("number :");
        int n = sc.nextInt();

        System.out.println(sieveOfEratosthenes(n));
    }

    /// Solution
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        // potd.code.hub
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve, true);
        for (int i = 2;i <= n;i++){
            if (sieve[i]){
                for (int j = i*i;j <= n;j+=i)
                    sieve[j] = false;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2;i <= n;i++)
            if (sieve[i]) list.add(i);

        return list;
    }
}
