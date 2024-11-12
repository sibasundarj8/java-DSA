package Pattern;

import java.util.Scanner;

public class Pattern_Numerical_Squire
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int r = sc.nextInt();
        r *= 2;

        for(int i = 0; i <= r; ++i)
        {
            for(int j = 0; j <= r; ++j)
            {
                int a = Math.min(Math.min(i, j), Math.min(r - i, r - j));
                System.out.print(a + "  ");
            }
            System.out.println();
        }
    }
}