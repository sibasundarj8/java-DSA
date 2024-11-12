package Recursion;
//   Try to print 1 to N numbers without using any loop.

import java.util.Scanner;

public class Recursion_1_Print_Numbers_upTo_N
{
 static void PI(int n)
 {
     // Base Case
     if (n == 1)
     {
         System.out.print(1 + " ");
         return;
     }

     // Recursive Work
     PI(n-1);

     // Self Work
     System.out.print(n + " ");
 }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size :");
        int n = sc.nextInt();

        PI(n);
    }
}