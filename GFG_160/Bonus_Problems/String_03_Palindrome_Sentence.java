package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/string-palindromic-ignoring-spaces4723/1
 *
 * # Palindrome Sentence
 *
 *   Q. Given a single string s, the task is to check if it is a palindrome sentence or not. A palindrome
 *      sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the
 *      same backward as forward after converting all uppercase letters to lowercase and removing all
 *      non-alphanumeric characters.
 *    Ex.
 *      Input : s = "Abc 012..## 10cbA"
 *      Output: true
 *      Explanation: If we remove all non-alphanumeric characters and convert all uppercase letters to
 *                   lowercase, string s will become “abc01210cba” which is a palindrome.
 */
import java.util.Scanner;

public class String_03_Palindrome_Sentence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println((int)'z');

        System.out.println("Enter the Sentence: ");
        String s = sc.nextLine();

        System.out.println(sentencePalindrome(s));
    }

    /// Solution
    static boolean sentencePalindrome(String s) {
        // potd.code.hub
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while (i < j){
            while (i < j && !((48 <= s.charAt(i) && s.charAt(i) <= 57) || (97 <= s.charAt(i)&& s.charAt(i) <= 122))){
                i++;
            }
            while (i < j && !((48 <= s.charAt(j) && s.charAt(j) <= 57) || (97 <= s.charAt(j)&& s.charAt(j) <= 122))){
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
