package GFG;/*
 *      Q. Given a sentence containing several words and numbers. Find the largest number
 *         among them which does not contain 9. If no such number exists, return -1.
 *
 *       Note: Numbers and words are separated by spaces only.
 *          Ex :
 *              Input : s = "This is alpha 5057 and 97"
 *             Output : 5057
 *        Explanation : 5057 is the only number that does not have a 9.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POTD_Extract_the_Number_from_the_String {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String with Two Numbers : ");
        String s = sc.nextLine();

        System.out.println(extractNumber(s));
    }
    static long extractNumber(String s){

        // Define regex to find numbers
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);

        // Extract all numbers from the string
        long l = -1;
        while (m.find()){
            if (! m.group().contains("9")){
                long ch = Long.parseLong(m.group());
                if (ch > l) l = ch;
            }
        }
        return l;
    }
}