package GFG;/*
 *     Q. Given an array of strings arr. Return the longest common prefix among all strings
 *        present in the array. If there's no prefix common in all the strings, return "-1".
 *      Ex.
 *          Input : arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
 *          Output: gee
 *          Explanation: "gee" is the longest common prefix in all the given strings.
 */
import java.util.Scanner;

public class POTD_Longest_Common_Prefix_of_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size :");
        int r = sc.nextInt();
        String[]arr = new String[r];
        System.out.println("Elements :");
        for (int i = 0;i < r;i++)
            arr[i] = sc.next();
        System.out.println(longestCommonPrefix(arr));
    }
    static String longestCommonPrefix(String[]arr) {
        // potd.code.hub
        // base Case
        if (arr.length == 1)
            return arr[0];
        String ans = common(arr[0],arr[1]);
        for (String s : arr){
            String temp = common(s,ans);
            if (temp.length() < ans.length())
                ans = temp;
        }
        if (ans.isEmpty())return "-1";
        return ans;
    }
    static String common(String s1,String s2){
        String ans = "";
        int i = 0;
        while (i < s1.length() && i < s2.length()){
            if (s1.charAt(i) != s2.charAt(i))
                return ans;
            else
                ans += s1.charAt(i);
            i++;
        }
        return ans;
    }
}