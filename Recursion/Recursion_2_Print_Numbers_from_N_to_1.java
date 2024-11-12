package Recursion;

import java.util.Scanner;

public class Recursion_2_Print_Numbers_from_N_to_1
{
    static void PD(int n)
    {
        // Base Case
        if (n == 1)
        {
            System.out.print(n + " ");
            return;
        }

        // Self Work
        System.out.print(n + " ");

        // Recursive Work
        PD(n-1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int n = sc.nextInt();

        PD(n);
    }
}