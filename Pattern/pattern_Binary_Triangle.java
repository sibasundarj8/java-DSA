package Pattern;

import java.util.Scanner;
public class pattern_Binary_Triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size :");
        int n = sc.nextInt();

        for (int i = 1;i <= n;i++)
        {
            int x,y;
            if (i % 2 != 0) {
                x = 1;
                y = 0;
            }
            else {
                x = 0;
                y = 1;
            }
            for (int j = 1;j <= i;j++) {
                int t = x;
                x = y;
                y = t;
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}