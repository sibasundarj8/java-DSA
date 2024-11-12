package Recursion;/*
 *    Q5. A string is called special if it consists of only stars(‘*’) and dashes(‘-’),
 *        and there are no consecutive stars in the string. Given a positive integer K,
 *        print all the special strings of size K.
 *
 *      Ex :
 *          Input : k = 3
 *         Output :  ---
 *                   --*
 *                   -*-
 *                   *--
 *                   *-*
 */
import java.util.Scanner;

public class Recursion_40_Special_Strings_of_Dash_Stars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number :");
        int s = sc.nextInt();
        starAndDash(s,"");
    }
    static void starAndDash(int n,String ans){
        // Base Case
        if (n == 0){
            System.out.println(ans);
            return;
        }
        // Recursive Work
        starAndDash(n-1,ans+"-");
        if (ans.isEmpty() || ans.charAt(ans.length()-1)!='*')
            starAndDash(n-1,ans+"*");
    }
}