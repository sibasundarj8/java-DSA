package Pattern;

import java.util.Scanner;

public class Pattern_Prime_Pyramid
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int r = sc.nextInt();
        int num = 3;

        for(int i = 1; i <= r; ++i)
        {
            int j;
            for(j = 1; j <= r - i; ++j)
            {
                System.out.print("  ");
            }
            if (i == 1)
            {
                System.out.print("2");
            } else {
                for(j = 0; j != i; ++num)
                {
                    boolean count = false;

                    for(int k = 2; k < num; ++k)
                    {
                        if (num % k == 0)
                        {
                            count = true;
                            break;
                        }
                    }
                    if (!count)
                    {
                        System.out.print(num + "  ");
                        ++j;
                    }
                }
            }
            System.out.println();
        }
    }
}