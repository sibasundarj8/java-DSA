package Pattern;

import java.util.Scanner;

public class Pattern_Plus_Pattern
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int size = sc.nextInt();

        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                if (i == size / 2)
                {
                    System.out.print("*  ");
                } else if (j == size / 2)
                {
                    System.out.print("*");
                } else
                {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}