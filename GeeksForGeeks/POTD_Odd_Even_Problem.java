package GFG;/*
 * Q. Given a string s of lowercase English characters, find out whether
 *    the summation of x and y is even or  odd, where x is the  count of
 *    distinct characters that occupy even positions in English alphabets
 *    and have even frequency, y is the count of distinct characters which
 *    occupy odd positions in English alphabets and have odd frequency.
 *
 *      Input:
 *      s = "abbbcc"
 *
 *      Output: ODD
 *
 *      Explanation:
 *           x = 0 and y = 1 so (x + y) is ODD.'a' occupies 1st place(odd) in english
 *           alphabets and its frequency is odd(1), 'b' occupies 2nd place(even) but
 *           its frequency is odd(3) so it doesn't get counted and 'c' occupies 3rd
 *           place(odd) but its frequency is even(2) so it also doesn't get counted.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Odd_Even_Problem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(oddEven(s));
    }
    static String oddEven(String s)
    {
        int x = 0; // Even
        int y = 0; // Odd

        char[]arr = s.toCharArray();
        Arrays.sort(arr);

        ArrayList<Character> xyz = new ArrayList<>();

        xyz.add(arr[0]);
        for (int i = 1;i < arr.length;i++)if (arr[i] != arr[i-1])xyz.add(arr[i]);

        for (Character c : xyz)
        {
            if (countFreq(s, c) % 2 == 0 && (int) c % 2 == 0) x++;
            else if (countFreq(s, c) % 2 != 0 && (int) c % 2 != 0) y++;
        }

        return (x+y)%2==0 ? "EVEN":"ODD";
    }
    static int countFreq(String s, char c)
    {
        int ans = 0;

        for (int i = 0;i < s.length();i++)
        {
            if (s.charAt(i) == c) ans++;
        }

        return ans;
    }
}