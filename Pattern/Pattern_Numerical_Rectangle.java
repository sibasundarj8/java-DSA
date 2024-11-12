package Pattern;

import java.util.Scanner;

public class Pattern_Numerical_Rectangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int r = sc.nextInt();

        for(int i = 1; i <= r; ++i)
        {
            int k;
            for(k = i; k <= r; ++k)
            {
                System.out.print(k);
            }

            for(k = 1; k <= i - 1; ++k)
            {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}