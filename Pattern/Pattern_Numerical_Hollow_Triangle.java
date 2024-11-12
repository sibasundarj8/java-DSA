package Pattern;

import java.util.Scanner;

public class Pattern_Numerical_Hollow_Triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int r = sc.nextInt();

        for(int i = 0; i < r; ++i)
        {
            for(int j = 0; j < 2 * i + 1; ++j)
            {
                if (j == 0 || j == 2*i || i == r-1)
                {
                    System.out.print(i + " ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}