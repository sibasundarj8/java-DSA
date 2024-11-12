package Recursion;/*
  Q1. Given a number n. Print if it is an armstrong number or not.
      An armstrong number is a number if the sum of every digit in that number
      raised to the power of total digits in that number is equal to the number.

     Input      : 153
     Output     : Yes
     Explanation: 1^3 + 5^3 + 3^3             ['.' num of digits in 153
                 = 1  + 125 +  27
                 = 153
*/
import java.util.Scanner;

public class Recursion_13_Armstrong_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number to check Armstrong or not : ");
        int x = sc.nextInt();
        int digit = 0;

        for (int i = x;i > 0;i/=10)digit++;     // Counting the Num of digits

        if (x == isArmstrong(x,digit)) System.out.println("Yes");
        else System.out.println("No");
    }
    static int isArmstrong(int x,int n)
    {
        if (x == 0)return 0;        // Base Case
        return (int)Math.pow(x%10,n) + isArmstrong(x/10,n); // Recursive Work
    }
}
