package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example_1 {
    public static void main(String[] args) {
        System.out.println("(a)");
        String regex = "a"; // true only if matcher contains one "a".
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("a");
        System.out.println(matcher.matches()); // true
        System.out.println(pattern.matcher("aa").matches()); // false

        // (a*) -> returns true if string contains a 0 or more times
        System.out.println("\n(a*)");
        Pattern pattern1 = Pattern.compile("a*");
        System.out.println(pattern1.matcher("aa").matches()); // true
        System.out.println(pattern1.matcher("").matches());   // true
        System.out.println(pattern1.matcher("ab").matches()); // false
        System.out.println(Pattern.compile("a*b").matcher("b").matches()); // true
        /*
          similarly,
             (a*b) -> aaa..aab                  "a" appears 0 or more times with single "b" at end
             (a*b*)-> aaa..aaabbb..bbb          "a" appears 0 or more times and also "b" appears 0 or more times but in order
             (ab*) -> abbb..bb                  "a" appear only once and "b" can appear 0 o more times
        */

        // (a+) -> returns true if the string contains only "a" 1 or more times.
        System.out.println("(\n(a+))");
        Pattern pattern2 = Pattern.compile("a+");
        System.out.println(pattern2.matcher("aa").matches()); // true
        System.out.println(pattern2.matcher("").matches());   // false
        System.out.println(Pattern.compile("ab+").matcher("abba").matches()); // false
        /*
            similarly,                           ∑ = {a, b}
                (a+b) -> aaa...ab                only accepts string which starts with 1 or more "a" and ends with only one "b"
                (ab+) -> abbb...b                only accepts string which start with a single "a" and ends with 1 or more "b"
        */

        // (a{n}) -> return true only if "a" contains exactly n times
        System.out.println("\n(a{n})");
        Pattern pattern3 = Pattern.compile("a{3}");
        System.out.println(pattern3.matcher("aaa").matches());   // true
        System.out.println(pattern3.matcher("aaaa").matches());  // false

        // (a{n}) -> return true only if "a" contains at-least n times
        System.out.println("\n(a{n,})");
        Pattern pattern4 = Pattern.compile("a{3,}");
        System.out.println(pattern4.matcher("aa").matches());    // false
        System.out.println(pattern4.matcher("aaa").matches());   // true
        System.out.println(pattern4.matcher("aaaa").matches());  // true

        // (a{n, m}) -> return true only if "a" contains n to m number of times
        System.out.println("\n(a{n,m})");
        Pattern pattern5 = Pattern.compile("a{3,5}");
        System.out.println(pattern5.matcher("aaa").matches());   // true
        System.out.println(pattern5.matcher("aa").matches());    // false
        System.out.println(pattern5.matcher("aaaaaa").matches());// false

        // (ab) -> return true only if string is "ab".
        System.out.println("\n(ab)");
        Pattern pattern6 = Pattern.compile("ab");
        System.out.println(pattern6.matcher("a").matches()); // false
        System.out.println(pattern6.matcher("b").matches()); // false
        System.out.println(pattern6.matcher("ab").matches());// true

        // (a|b) -> return true only if either string is "a" or "b"
        System.out.println("\n(a|b) or ([ab])");
        Pattern pattern7 = Pattern.compile("[ab]");
        System.out.println(pattern7.matcher("a").matches()); // true
        System.out.println(pattern7.matcher("b").matches()); // true
        System.out.println(pattern7.matcher("ab").matches());// false

        // ([A-Z]) -> return true when String of size one with a capital character
        System.out.println("\n([A-Z])");
        Pattern pattern8 = Pattern.compile("[A-Z]");
        System.out.println(pattern8.matcher("G").matches()); // true
        System.out.println(pattern8.matcher("g").matches()); // false
        System.out.println(pattern8.matcher("GG").matches());// false

        // ([A-Z0-9]) -> true if String is either A-Z or 0-0 size must be 1
        System.out.println("\n([A-Z0-9])");
        Pattern pattern9 = Pattern.compile("[A-Z0-9]");
        System.out.println(pattern9.matcher("G").matches()); // true
        System.out.println(pattern9.matcher("5").matches()); // true
        System.out.println(pattern9.matcher("23").matches());// false

        // ([a-z0-9]) -> String can contain range(a-z | 0-9) size at-least 1
        System.out.println("\n([a-z0-9]+)");
        Pattern pattern10 = Pattern.compile("[a-z0-9]+");
        System.out.println(pattern10.matcher("aa").matches()); // true
        System.out.println(pattern10.matcher("53").matches()); // true
        System.out.println(pattern10.matcher("AA").matches());// false

        // (^([a-z]+[0-9]+)$) -> true is starts with (a-z) then (0-9) till end
        System.out.println("\n(^([a-z]+[0-9]+)$)");
        Pattern pattern11 = Pattern.compile("^([a-z]+[0-9]+)$");
        System.out.println(pattern11.matcher("ar21").matches()); // true
        System.out.println(pattern11.matcher("53").matches());  // false
        System.out.println(pattern11.matcher("AA").matches());  // false
    }
}
