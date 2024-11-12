package GFG;

import java.util.Scanner;

public class POTD_Max_Bulb_On
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i * i <= n; ++i)
        {
            System.out.print(i * i + "  ");
        }
    }
}