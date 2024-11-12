package GFG;/*
 *     Q. You are given a string str containing two fractions a/b and c/d, compare them and return the greater.
 *        If they are equal, then return "equal".
 *       Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )).
 *
 *      Ex.
 *           Input : f = "5/6, 11/45"
 *           Output: 5/6
 *      Explanation: 5/6=0.8333 and 11/45=0.2444, So 5/6 is greater fraction.
 */
import java.util.Scanner;

public class POTD_Compare_two_fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two Fractions like (a/b, c/d)");
        String f = sc.nextLine();
        System.out.println(compareFraction(f));
    }
    static String compareFraction(String str) {
        // Code here
        int i = 0;
        while (i < str.length()){
            if (str.charAt(i) == ',')break;
            i++;
        }
        double a = findValue(str.substring(0,i));
        double b = findValue(str.substring(i+2));

        if (a < b)return str.substring(i+2);
        else if (a > b) return str.substring(0,i);
        return "equal";
    }
    static double findValue(String f){
        int i = 0;
        while (i < f.length()){
            if (f.charAt(i) == '/')break;
            i++;
        }
        return (double) Integer.parseInt(f.substring(0, i))
                / Integer.parseInt(f.substring(i+1));
    }
}