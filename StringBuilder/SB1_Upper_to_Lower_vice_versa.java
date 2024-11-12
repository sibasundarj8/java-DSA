package StringBuilder;

import java.util.Scanner;

public class SB1_Upper_to_Lower_vice_versa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        StringBuilder s = new StringBuilder(sc.nextLine());
        for (int i = 0;i < s.length();i++){
            int ch = s.charAt(i);
            if (s.charAt(i) <= 90 && s.charAt(i) >= 65)
                s.setCharAt(i, (char)(ch+32));
            else if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                s.setCharAt(i, (char)(ch-32));
        }
        System.out.println(s);
    }
}
