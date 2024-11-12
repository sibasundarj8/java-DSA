package GFG;/*
 *     Q. WAP to check the number is perfect number or not.
 *
 *       Perfect Number : A number is said to be perfect if sum of all its factors
 *                        excluding the number itself is equal to the number.
 *
 *       Note : Return true if it is perfect number else return false.
 */
import java.util.Scanner;

public class POTD_Perfect_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number :");
        long x = sc.nextInt();
        System.out.println(isPerfectNumber(x));
    }
    static boolean isPerfectNumber(long n) {
        // code here
        if(n == 0 || n == 1)return false;
        long ans = 0;
        for(int i = 2;i <= (int)Math.sqrt(n);i++)
            if(n%i == 0)
                ans += i + (n/i);
        return (ans+1) == n;
    }
}