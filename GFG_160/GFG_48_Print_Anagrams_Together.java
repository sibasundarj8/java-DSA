package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/print-anagrams-together/1
 *
 * # Print Anagrams Together
 *
 *   Q. Given an array of strings, return all groups of strings that are anagrams. The groups must be created
 *      in order of their appearance in the original array. Look at the sample case for clarification.
 *
 *      Note: The final output will be in lexicographic order.
 *    Ex.
 *      Input : arr[] = ["act", "god", "cat", "dog", "tac"]
 *      Output: [["act", "cat", "tac"], ["god", "dog"]]
 *      Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make
 *                   group 2.
 */
import java.util.*;
 
public class GFG_48_Print_Anagrams_Together {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        HashMap<String, String> map = new HashMap<>();

        System.out.println("Size: ");
        int n = sc.nextInt();

        String[]arr = new String[n];

        System.out.println("Words: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.next();
        }

        System.out.println(anagrams(arr));
    }

    /// Solution
    static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // potd.code.hub
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String s : arr){
            char[]temp = s.toCharArray();
            Arrays.sort(temp);
            String s1 = String.valueOf(temp);
            map.putIfAbsent(s1, new ArrayList<>());
            if (map.containsKey(s1)) map.get(s1).add(s);
        }
        map.forEach((x, y) -> ans.add(y));

        return ans;
    }
}
