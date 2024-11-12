package Recursion;

import java.util.Scanner;

public class Recursion_16_Decimal_to_Binary
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number Which U want to convert to Decimal :");
        int n = sc.nextInt();

        System.out.println(recBinary(n));
    }
    static int recBinary(int n)
    {
        // Base Case
        if (n == 0)return 0;

        // Recursive Work
        return n%2 + 10*recBinary(n/2);
    }
}