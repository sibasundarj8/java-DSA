package Strings;

import java.util.Scanner;

public class S2_Upper_to_Lower_vice_versa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.nextLine();
        String ans = "";
        for (int i = 0;i < s.length();i++){
            int ch = s.charAt(i);
            if (ch <= 90 && ch >= 65)
                ans += (char)(ch+32);
            else if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                ans += (char)(ch-32);
            else ans += (char)ch;
        }
        System.out.println(ans);
    }
}
