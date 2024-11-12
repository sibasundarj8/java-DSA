package Recursion;/*
    Alternate Series Sum
    Ex:-
        input-    10
        output-   -5
        Explanation-
               1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 =   -5
*/
import java.util.Scanner;

public class Recursion_8_Alternate_Series_Sum
{
    static int altSeriesSum(int n)
    {
        // base case
        if(n == 0)return 0;

        // recursive work
        return (n % 2 == 0) ? altSeriesSum(n - 1) - n : altSeriesSum(n - 1) + n;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number :");
        int x = sc.nextInt();

        System.out.println(altSeriesSum(x));
    }
}