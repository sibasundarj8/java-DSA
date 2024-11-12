package Recursion;/*
 *   Q.  WAP to print all the Possibilities ?
 *      Ex.
 *        Input: password can contain These digits : 0123456789
 *               Size of password : 4
 *        Output:
 *              All possibilities :
 *                0000
 *                0001
 *                .
 *                .
 *                .
 *                9997
 *                9998
 *                9999
 */
import java.util.Scanner;

public class Recursion_38_Password_Possibilities
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Possible Characters :");
        String s = sc.next();
        System.out.println("password Size :");
        int n = sc.nextInt();
        passwordChecker(s,s.length(),n,"");
    }
    static void passwordChecker(String s,int n,int rem,String ans){
        // Base Case
        if (rem == 0){
            System.out.println(ans);
            return;
        }
       // Recursive Work
       for(int i=0;i<n;i++)passwordChecker(s,n,rem-1,ans+s.charAt(i));
    }
}