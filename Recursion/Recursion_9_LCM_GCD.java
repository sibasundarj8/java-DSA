package Recursion;/*
       input: 15
              24
      output: 3
 Explanation:
        GCD :  15)24(1
                  9)15(1
                     6)9(1
                       3)6(2
                         0)3(

        LCM : (x * y) / GCD
*/
import java.util.Scanner;

public class Recursion_9_LCM_GCD
{
    static int gcd(int x, int y)
    {
        if(y == 0)return x;
        return gcd(y, x % y);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two Numbers which LCM &GCD you want : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("GCD is : " + gcd(x,y));
        System.out.println("LCM is : " + (x*y)/gcd(x,y));
    }
}