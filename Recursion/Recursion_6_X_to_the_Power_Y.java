package Recursion;
//     Find X to the power Y using Recursion.

import java.util.Scanner;

public class Recursion_6_X_to_the_Power_Y
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number first and then the power : ");
        int n = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(n + " to the power " + p + " : " + pow(n,p));
    }
    static int pow(int n,int p)
    {
        if (p == 0) return 1;           // Base Case
        int smallPw = pow(n,p/2);    // Recursive Work
        if (p%2 == 0) return smallPw*smallPw;  // Self Work
        return n*smallPw*smallPw;
    }
}