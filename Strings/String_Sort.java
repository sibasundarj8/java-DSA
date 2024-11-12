package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class String_Sort {
    static String sort(String s){
        char[]str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The String :");
        String s = sort(sc.nextLine());
        System.out.println(s);
    }
}