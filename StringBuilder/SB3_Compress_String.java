package StringBuilder;

import java.util.Scanner;

public class SB3_Compress_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word : ");
        String s = sc.next();
        System.out.println(compress(s));
    }
    static String compress(String s){
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1;i < n;i++){
            if (s.charAt(i) == s.charAt(i-1))
                count++;
            else {
                ans.append(s.charAt(i-1));
                if (count > 1)ans.append(count);
                count = 1;
            }
        }
        ans.append(s.charAt(n-1));
        if (count > 1)ans.append(count);
        return ans.toString();
    }
}