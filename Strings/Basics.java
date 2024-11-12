package Strings;

import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input of a word
        String str = sc.next();
        System.out.println(str);

        // Input of line
        str = sc.nextLine();
        System.out.println(str);

        str = "hello World";

        // Char at index
        char ch = str.charAt(0);
        System.out.println(ch);

        // index of a char
        int idx = str.indexOf('w');
        System.out.println(idx);

        // Compare two Strings
        String s1 = "Hello";
        String s2 = "Fello";
        int c = s1.compareTo(s2);
        // output is 2 bcz First disSimilar char is H and F, ASCII of (H - F) = 2
        System.out.println(c);

        String s = "Sibasundar Jena";
        // Contains a particular subString
        boolean a = s.contains(" Jena");
        System.out.println(a);
        System.out.println(s.startsWith("Sib"));
        System.out.println(s.endsWith("Jena"));

        // Convert to UpperCase
        s = s.toUpperCase();
        System.out.println(s);

        // Convert to lowerCase
        s = s.toLowerCase();
        System.out.println(s);

        // Concatenation in Strings
        String ans = s1.concat(s2);
        // Output "HelloFello"
        System.out.println(ans);
        // String + String
        System.out.println("Hello" + "World");// HelloWorld
        // String + Char
        System.out.println("Hello" + 'Z');    // HelloZ
        // String + Number
        System.out.println("Hello" + 8 + 8);  // Hello88

        // Sub-String

        String subS = "Sibasundar Jena";
        // subS.subString( beginIndex ) -> Index to End
        System.out.println(subS.substring(4)); // sundar Jena
        // subS.subString(beginIndex(Inclusive), endIndex(Exclusive));
        System.out.println(subS.substring(4,10)); // sundar

        // "s1.equals(s2)"(must use)  or  "s1 == s2"(don't use)
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println(str1 == str2);     // true
        System.out.println(str1 == str3);     // false (Comparing Address)
        System.out.println(str1.equals(str2));// true   (Comparing Value)
    }
}