package Pattern;

import java.util.Scanner;

public class Pattern_Love
{
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);

        System.out.println("Enter Size :");
        int n = sc.nextInt();
        String s = "Anu";

        for (int i = n/2;i < n;i++) {
            for (int j = n-i;j > 1;j--)
                System.out.print("    ");
            for (int j = 0;j < 2*i+1;j++)
                System.out.print(s + " ");
            for (int j = n-i;j > 1;j--)
                System.out.print("    ");
            for (int j = n-i;j > 1;j--)
                System.out.print("    ");
            for (int j = 0;j < 2*i+1;j++)
                System.out.print(s + " ");
            System.out.println("\n");
        }

        int m = (4*n)-2;

        for (int i = 0;i < m;i++) {
            if (i == 0) System.out.print(" ");
            for (int j = 0;j < i;j++)
                System.out.print("    ");
            for (int j = 0;j < m-(2*i+1);j++)
                System.out.print(s + " ");
            System.out.println("\n");
        }
    }
}