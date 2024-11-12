package Recursion;/*
 *      Q.  A string  is called  beautiful if it consists  of only stars(‘*’) and dashes(‘-’).
 *          Further the number of stars in the first half of the string should be equal to the
 *          number of stars in the second  half of the string. Given a number n, print all the
 *          beautiful strings of length n. If the value of n is odd, the  middle  value can be
 *          either '*' or '-'.
 *      Ex.
 *          Input  : 3
 *          Output : -*-
 *                   ---
 *                   ***
 *                   *-*
 *
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Recursion_45_Beautiful_String_Odd_Size {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0;i <= n;i++)ans.add(new ArrayList<>());

        getCombinations(n/2,ans,0,"");

        if (n%2 == 0)
            for (ArrayList<String> i : ans)
                printCombinationEven(i);
        else
            for (ArrayList<String> i : ans)
                printCombinationOdd(i);
    }
    static void getCombinations(int rem,ArrayList<ArrayList<String>> ans,int nos,String curr){
        // Base Case
        if (rem == 0){
            ans.get(nos).add(curr);
            return;
        }
        // Recursive Work
        getCombinations(rem-1,ans,nos+1,curr+"*"); // add "*"
        getCombinations(rem-1,ans,nos,curr+"-"); // add "-"
    }
    static void printCombinationOdd(ArrayList<String>arr){
        for (String i : arr) {
            for (String j : arr) {
                System.out.println(i + "*" + j);
                System.out.println(i + "-" + j);
            }
        }
    }
    static void printCombinationEven(ArrayList<String>arr){
        for (String i : arr)
            for (String j : arr)
                System.out.println(i + j);
    }
}