package Strings;

import java.util.Scanner;

public class S1_Sub_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Word : ");
        String s = sc.next();

        System.out.println("Output :");
        for (int i = 0;i < s.length();i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                System.out.println(s.substring(i,j));
            }
        }
        // Input : siba
        // Output : s si sib siba i ib iba b ba a
    }
}
