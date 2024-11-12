package Recursion;

import java.util.Scanner;

public class Recursion_7_first_N_num_of_Multiples
{
    static void nMultiples(int a,int n)
    {
        // base case
        if (n == 0)return;

        // recursive work
        nMultiples(a,n-1);

        // self work
        System.out.print(a*n + " ");

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int x = sc.nextInt();

        System.out.println("Enter the number of multiples do you want :");
        int n = sc.nextInt();

        nMultiples(x,n);
    }
}
