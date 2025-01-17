package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/group-shifted-string/0
 *
 * # Group Shifted String
 *
 *   Q. Given an array of strings (all lowercase letters), the task is to group them in such a way
 *      that all strings in a group are shifted versions of each other.
 *
 *      Two strings s1 and s2 are called shifted if the following conditions are satisfied:
 *          ● s1.length = s2.length
 *          ● s1[i] = s2[i] + m for 1 <= i <= s1.length  for a constant integer m
 *    Ex.
 *      Input : arr = ["acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"]
 *      Output: [["acd", "dfg", "wyz", "yab", "mop"],
 *               ["bdfh", "moqs"],
 *               ["a", "x"]]
 *      Explanation: All shifted strings are grouped together.
 */
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Hashing_06_Group_Shifted_String {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        String[]arr = new String[n];

        System.out.println("Words: ");
        for (int i = 0;i < n;i++) arr[i] = sc.next();

        System.out.println(groupShiftedString(arr));
    }

    /// Solution
    static ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>(n);

        for (String s : arr) {
            String code = getCode(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }

        map.forEach((s, list) -> {
            Collections.sort(list);
            ans.add(list);
        });

        return ans;
    }
    private static String getCode (String s){
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 1;i < n;i++){
            int dif = s.charAt(i) - s.charAt(i-1);
            if (dif < 0) dif += 26;
            ans.append(dif).append("#");
        }

        return ans.toString();
    }
}
