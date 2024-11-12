package Recursion;/*
     Q1. Find m-th summation of first n natural numbers where m-th summation of first n
         natural numbers ?

      input: n = 3
             m = 2
     output: 21

Explanation: 1+2+3 = 6
             1+2+3+4+5+6 = 21   Although m == 2 it runs 2 times
*/
import java.util.Scanner;

public class Recursion_11_SumOf_n_Numbers_M_Times
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the numbers :");
        int n = sc.nextInt();
        int m =sc.nextInt();

        System.out.println(recN(n,m));
    }
    static int recN(int n,int m)
    {
        // Base Case
        if (m == 1)return (n*(n+1))/2;

        // Recursive Work
        return recN((n*(n+1))/2,m-1);
    }
}