package GFG;

import java.util.Scanner;

public class POTD_Power_of_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number :");
        long n = sc.nextInt();

        if (isPowerOfTwo(n))
        {
            System.out.println("Yes.");
        }
        else
        {
            System.out.println("No.");
        }
    }
    static boolean isPowerOfTwo(long n){

        // Your code here

        if(n <= 0)
        {
            return false;
        }
        else if(n == 1)
        {
            return true;
        }

        for(long i = n;i > 0;i /= 2)
        {
            long y = i;
            y %= 2;
            if(y == 1)
            {
                return false;
            }
            if(i == 2)
            {
                return true;
            }
        }
        return false;
    }
}
