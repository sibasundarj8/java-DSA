package Recursion;

import java.util.Scanner;

public class Recursion_12_Power
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the number and its power :");
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(x + " Raise to the power " + n +" : " + power(x,n));
    }
    static int power (int x,int n)
    {
        // Base Case
        if(n == 0)return 1;

        // Recursive work
        if (n%2 == 0)return power(x,n/2) * power(x,n/2);
        return x * power(x,n/2) * power(x,n/2);
    }
}
