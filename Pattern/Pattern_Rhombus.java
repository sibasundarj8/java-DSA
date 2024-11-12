package Pattern;

import java.util.Scanner;

public class Pattern_Rhombus
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int r = sc.nextInt();

        int i;
        int j;
        for(i = 1; i <= r; ++i)
        {
            for(j = 1; j <= r - i; ++j)
            {
                System.out.print("  ");
            }

            for(j = 1; j <= i; ++j)
            {
                System.out.print("*   ");
            }
            System.out.println();
        }

        for(i = 1; i <= r - 1; ++i)
        {
            for(j = 1; j <= i; ++j)
            {
                System.out.print("  ");
            }

            for(j = 1; j <= r - i; ++j)
            {
                System.out.print("*   ");
            }
            System.out.println();
        }
    }
}