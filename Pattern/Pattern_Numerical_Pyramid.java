package Pattern;

import java.util.Scanner;

public class Pattern_Numerical_Pyramid
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int r = sc.nextInt();

        for(int i = 1; i <= r; ++i)
        {
            int j;
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
    }
}