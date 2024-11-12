package Pattern;

import java.util.Scanner;

public class Pattern_Triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size :");
        int r = sc.nextInt();

        for(int i = 0; i <= r; ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}