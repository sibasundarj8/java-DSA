package Recursion;/*
 *  Q. Given an input string of digits, find all combinations of numbers
 *     that can be formed using digits in the same order ?
 *   Ex.
 *      Input: 123
 *     Output: 1,2,3
 *             1,23
 *             12,3
 *             123
 */
import java.util.Scanner;

public class Recursion_39_all_possible_Numbers
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number :");
        String s = sc.next();

        System.out.println("All combinations of Number in Same order :");
        allCombinations(s,s.length(),0,"");
    }
    static void allCombinations(String s,int n,int idx,String ans){
        // Base case
        if (idx == n){
            System.out.println(ans);
            return;
        }
        // Recursive Work
        if (idx < n-1)
            allCombinations(s,n,idx+1,ans+s.charAt(idx)+",");
        allCombinations(s,n,idx+1,ans+s.charAt(idx));
    }
}