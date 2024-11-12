package GFG;/*
 * Implement pow(x, n) % M.
 * In other words, for a given value of x, n, and M,find (xⁿ)%M.
 */

import java.util.Scanner;

public class POTD_Modular_Exponentiation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("X = ");
        long x = sc.nextLong();

        System.out.print("N = ");
        long n = sc.nextLong();

        System.out.print("M = ");
        long m = sc.nextLong();

        System.out.println("(xⁿ) % m =  "+ powMod(x,n,m));
    }
    static long powMod(long x,long n,long m)
    {
        // base Case
        if (n == 0)return 1;
        if (n == 1)return x;

        // recursive Work
        long sp = powMod(x,n/2,m);

        // self Work
        if (n%2 == 0)return (sp*sp) % m; // even Power
        return (sp*sp*x) % m;       // odd Power
    }
}
