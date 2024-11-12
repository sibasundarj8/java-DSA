package StringBuilder;

import java.util.Scanner;

public class SB2_Reverse_each_Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Sentence :");
        String s = sc.nextLine();
        System.out.println(reverseEach(s));
    }
    static String reverseEach(String s){
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if (ch == ' '){
                ans.append(temp.reverse().append(" "));
                temp = new StringBuilder();
            }
            else{
                temp.append(ch);
            }
        }
        return String.valueOf(ans.append(temp.reverse()));
    }
}