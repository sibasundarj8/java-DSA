package Recursion;/*
    Input : 16
   Output :
            16 11 6 1 -4 1 6 11 16

   Explanation :
                n-5,n-10...0,5,10...n-5,n
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_10_Pattern_01
{
    static ArrayList<Integer> recS(int n, int m, boolean flag, ArrayList<Integer>ans)
    {
        if (m <= 0){
            ans.add(n);
            return ans;
        }
        ans.add(n);

        // Base Case
        if(!flag && n == m)return ans;

        // Recursive Work
        if(flag)return recS(n-5,m,n-5 > 0,ans);
        else return recS(n+5,m,false,ans);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number :");
        int n = sc.nextInt();

        ArrayList<Integer>ans = new ArrayList<>();

        System.out.println(recS(n,n,true,ans));
    }
}