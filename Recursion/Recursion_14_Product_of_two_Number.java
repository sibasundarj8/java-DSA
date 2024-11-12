package Recursion;

import java.util.Scanner;

public class Recursion_14_Product_of_two_Number
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the two numbers which you want to Multiply :");

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(mul(m,n));
    }
    static int mul(int x,int y)
    {
        if (y == 0)return 0;    // Base Case
        return x + mul(x,y-1);  // Recursive Work
    }
}
