package Pattern;

import java.util.Scanner;

public class Pattern_Hollow_Rectangle
{                                                                  // big-O(r*c)
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length :");
        int r = sc.nextInt();

        System.out.println("Enter Width :");
        int c = sc.nextInt();

        for(int i = 1; i <= c; ++i)
        {
            for(int j = 1; j <= r; ++j)
            {
                if (i != 1 && i != c && j != 1 && j != r)
                {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}