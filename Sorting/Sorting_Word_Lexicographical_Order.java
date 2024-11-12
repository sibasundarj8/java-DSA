package Sorting;/*
 *     Q. WAP to rearrange a word Lexicographical order ?
 *
 */
import java.util.Scanner;

public class Sorting_Word_Lexicographical_Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word :");
        String s = sc.next();
        System.out.println(sort(s));
    }
    static String sort(String s){
        char[]ans = s.toCharArray();
        int n = ans.length;
        for (int i = 0;i < n-1;i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++)
                if (ans[j] > ans[j + 1]) {
                    char temp = ans[j + 1];
                    ans[j + 1] = ans[j];
                    ans[j] = temp;
                    flag = false;
                }
            if (flag)break;
        }
        return String.valueOf(ans);
    }
}