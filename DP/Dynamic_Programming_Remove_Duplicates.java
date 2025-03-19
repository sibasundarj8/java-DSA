package DP;

import java.util.Scanner;

public class Dynamic_Programming_Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Word :");
        String s = sc.next();
        System.out.println(removeDups(s));
    }
     static String removeDups(String str) {
        // potd.code.hub
         str = str.toLowerCase();
        String ans = "";
        int[]freq = new int[26];
        for (int i = 0;i < str.length();i++){
            int idx = (int) str.charAt(i)-97;
            if (freq[idx] == 0){
                freq[idx]++;
                ans += str.charAt(i);
            }
        }
        return ans;
    }
}
