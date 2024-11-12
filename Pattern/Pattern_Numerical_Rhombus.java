package Pattern;

import java.util.Scanner;

public class Pattern_Numerical_Rhombus
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size :");
        int r = sc.nextInt();

        System.out.println("Type:- 1");
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
                System.out.print(i + "   ");
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
                System.out.print(r - i + "   ");
            }
            System.out.println();
        }

        System.out.println("\nType:- 2");

        for(i = 1; i <= r; ++i)
        {
            for(j = 1; j <= r - i; ++j)
            {
                System.out.print("   ");
            }

            for(j = i; j >= 1; --j)
            {
                System.out.print(j + "  ");
            }

            for(j = 2; j <= i; ++j)
            {
                System.out.print(j + "  ");
            }

            System.out.println();
        }

        for(i = 1; i <= r - 1; ++i)
        {
            for(j = 1; j <= i; ++j)
            {
                System.out.print("   ");
            }

            for(j = r - i; j >= 1; --j)
            {
                System.out.print(j + "  ");
            }

            for(j = 2; j <= r - i; ++j)
            {
                System.out.print(j + "  ");
            }

            System.out.println();
        }
    }
}