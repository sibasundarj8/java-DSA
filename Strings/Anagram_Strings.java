package Strings;

import java.util.Scanner;
import java.util.Arrays;

class Text {
    public int areAnagram(String S1, String S2) {
        char[] arr1 = S1.toCharArray();
        char[] arr2 = S2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2) ? 1 : 0;
    }
}
public class Anagram_Strings {
    public Anagram_Strings() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 2 Strings and find are they equal or not...");
        System.out.print("String 1 : ");
        String S1 = sc.nextLine();
        System.out.print("String 2 : ");
        String S2 = sc.nextLine();
        Text ob = new Text();
        System.out.println(ob.areAnagram(S1, S2));
    }
}