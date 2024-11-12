package Pattern;

import java.util.Scanner;

public class Pattern_Sand_Clock
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size :");
        int r = sc.nextInt();

        int i;
        int j;
        for(i = 1; i <= r; ++i)
        {
            for(j = 2; j <= i; ++j)
            {
                System.out.print("  ");
            }

            for(j = r - i + 1; j >= 1; --j)
            {
                System.out.print("*   ");
            }
            System.out.println();
        }

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
    }
}