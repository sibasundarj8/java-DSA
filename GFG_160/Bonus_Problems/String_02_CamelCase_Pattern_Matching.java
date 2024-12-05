package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/camelcase-pattern-matching2259/1
 *
 * # CamelCase Pattern Matching
 *
 *   Q. Given a dictionary of words arr[] where each word follows CamelCase notation, print all words in
 *      the dictionary that match with a given pattern pat consisting of uppercase characters only.
 *
 *      CamelCase is the practice of writing compound words or phrases such that each word or abbreviation
 *      begins with a capital letter. Common examples include PowerPoint and Wikipedia, GeeksForGeeks,
 *      CodeBlocks, etc.
 *
 *      Example: "GeeksForGeeks" matches the pattern "GFG", because if we combine all the capital letters in
 *               "GeeksForGeeks" they become "GFG". Also note "GeeksForGeeks" matches with the pattern "GFG"
 *                and also "GF", but does not match with "FG".
 *
 *      Note: The driver code will sort your answer before checking and return the answer in any order.
 *    
 *    Ex:
 *      Input: arr[] = ["WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks"], pat = "WTG"
 *      Output: ["WelcomeToGeeksForGeeks"]
 *      Explanation: Since only "WelcomeToGeeksForGeeks" matches the pattern, it is the only answer.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String_02_CamelCase_Pattern_Matching {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        String[]arr = new String[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.next();
        }

        System.out.println("Pattern: ");
        String pat = sc.next();

        System.out.println(camelCase(arr, pat));
    }

    /// Solution
    static List<String> camelCase(String[] arr, String pat) {
        // potd.code.hub
        List<String> ans = new ArrayList<>();

        for (String s : arr){
            if (isPat(s, pat)) ans.add(s);
        }

        return ans;
    }
    static boolean isPat(String s, String pat){
        int n = s.length();
        int m = pat.length();

        int i = 0, j = 0;
        while (i < n){
            char ch = s.charAt(i);
            if (65 <= ch && ch <= 90){
                if (ch != pat.charAt(j)) return false;
                j++;
                if (j == m) return true;
            }
            i++;
        }
        return false;
    }
}
