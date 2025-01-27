package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 *
 * # Permutations of a String
 *
 *   Q. Given a string s, which may contain duplicate characters, your task is to generate and return
 *      an array of all unique permutations of the string. You can return your answer in any order.
 *    Ex.
 *      Input : s = "ABC"
 *      Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 *      Explanation: Given string ABC has 6 unique permutations.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class GFG_75_Permutations_of_a_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter characters: ");
        String s = sc.next();

        System.out.println(findPermutation(s));
    }

    /// Solution
    static ArrayList<String> findPermutation(String s) {
        // potd.code.hub
        HashSet<String> ans = new HashSet<>();
        permutation(s, new boolean[s.length()], "", ans);
        return new ArrayList<>(ans);
    }
    private static void permutation(String s, boolean[]visit,String curr, HashSet<String> ans){
        // base case
        if (s.length() == curr.length()){
            ans.add(curr);
            return;
        }
        // self work
        for (int i = 0;i < s.length();i++){
            if (!visit[i]){
                visit[i] = true;
                // recursive work
                permutation(s, visit, curr+s.charAt(i), ans);
                visit[i] = false;
            }
        }
    }
}
