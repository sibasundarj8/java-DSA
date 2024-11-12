package Recursion;/*
 *      Q.  Problem Count the number of substrings having same first and last characters.
 *
 *     Ex.
 *          Input : anupama
 *         Output : 10
 *    Explanation : [a,n,u,p,a,m,a]  : 7
 *                  [anupa,ama]      : 2
 *                  [anupama]        : 1
 */
import java.util.Scanner;

public class Recursion_46_SubStrings_with_same_1se_and_Last_Char {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.next();
        int n = s.length();
        System.out.println(count(s,n,0,n-1));
    }
    static int count(String s,int n,int i,int j){
        // Base Case
        if (n == 1)return 1;
        if (n == 0)return 0;

        // Recursive Work
        int ans = count(s,n-1,i+1,j) +
                  count(s,n-1,i,j-1) -
                  count(s,n-2,i+1,j-1);

        // Self Work
        if (s.charAt(i) == s.charAt(j))
            ans++;

        return ans;
    }
}