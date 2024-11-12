package GFG;/*
    Q. WAP to check a number is palindrome or not ?
      Ex.-
        Input :- 1234321
        Output:- It's a palindromic Number

      Ex.-
        Input :- 986123
        Output:- It's not a palindromic Number

*/
import java.util.Scanner;

public class POTD_Palindromic_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number : ");
        int n = sc.nextInt();

        if (n == recPalindromic(n,0))
            System.out.println("It's a Palindromic Number");
        else System.out.println("It's not a Palindromic Number");
    }
    static int recPalindromic(int x,int ans)
    {
        // Base Case
        if (x == 0)return ans;

        // Recursive Work
        return recPalindromic(x/10,ans*10 + x%10);
    }
}