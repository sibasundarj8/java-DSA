package Recursion;/*
 *   Q. A string is called beautiful if is an even length string consisting of only stars(‘*’)
 *      and dashes(‘-’). Further the number of stars in the first half of the string should be
 *      equal to the number of stars in the second half of the string. Given a number n, print
 *      all the beautiful strings of length 2 * n.
 *
 *   Ex.
 *      Input : 2
 *     Output : ----
 *              *-*-
 *              *--*
 *              -**-
 *              -*-*
 *              ****
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_44_Beautiful_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0;i <= n;i++)
            ans.add(new ArrayList<>());
        getCombinations(n,ans,0,"");
        for (ArrayList<String> i : ans)
            printCombinations(i);
    }
    static void getCombinations(int rem,ArrayList<ArrayList<String>>ans,int nos,String curr){
        // Base Case
        if (rem == 0){
            ans.get(nos).add(curr);
            return;
        }
        // Recursive Work
        // add "*"
        getCombinations(rem-1,ans,nos+1,curr+"*");
        // add "-"
        getCombinations(rem-1,ans,nos,curr+"-");
    }
    static void printCombinations(ArrayList<String>num){
        for (String i : num)
            for (String j : num)
                System.out.println(i+j);
    }
}