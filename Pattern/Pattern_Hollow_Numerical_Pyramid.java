package Pattern;

import java.util.Scanner;

public class Pattern_Hollow_Numerical_Pyramid
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size : ");
        int n = sc.nextInt();

        for (int i = 0;i < n;i++)
        {
            for (int j = 0;j < n-i;j++)
            {
                System.out.print("  ");
            }
            for (int j = 0;j < 2*i+1;j++)
            {
                if (j == 0 || i == n-1 || j == 2*i)
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