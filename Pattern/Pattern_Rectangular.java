package Pattern;

import java.util.Scanner;

public class Pattern_Rectangular
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length and Breadth :");
        int length = sc.nextInt();
        int breadth = sc.nextInt();

        for(int i = 0; i < breadth; ++i)
        {
            for(int j = 0; j < length; ++j)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}