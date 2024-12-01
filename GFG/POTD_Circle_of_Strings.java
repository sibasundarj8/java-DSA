/*
 *   Q. Given an array arr of lowercase strings, determine if the strings can be chained together to
 *      form a circle. A string X can be chained together with another string Y if the last character
 *      of X is the same as the first character of Y. If every string of the array can be chained with
 *      exactly two strings of the array(one with the first character and the second with the last
 *      character of the string), it will form a circle.
 *    Ex.
 *      Input: arr[] = ["ab" , "bc", "cd", "da"]
 *      Output: 1
 *      Explanation: These strings can form a circle of strings.
 */
package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Circle_of_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        String[]arr = new String[n];
        System.out.println("Words :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.next();
        System.out.println(isCircle(arr));
    }
    static int isCircle(String[]arr) {
        // potd.code.hub

        // counting in-degree and out-degree
        int[]in = new int[26];
        int[]out =new int[26];

        // Adjacency List
        // a-0, b-1, c-2...
        ArrayList<Integer>[]adj = new ArrayList[26];
        for (int i = 0;i < 26;i++)
            adj[i] = new ArrayList<>();

        // making edges
        for (String temp : arr){
            int u = temp.charAt(0) - 'a';
            int v = temp.charAt(temp.length()-1) - 'a';
            adj[u].add(v);
            out[u]++;
            in[v]++;
        }

        // in-degree != out-degree (False)
        for (int i = 0;i < 26;i++)
            if (in[i] != out[i]) return 0;

        // Depth-first search
        boolean[]visited = new boolean[26];
        DFS(arr[0].charAt(0)-'a', adj, visited);

        // checking all are visited or not
        for (int i = 0;i < 26;i++)
            if (in[i]>0 && !visited[i])
                return 0;
        return 1;
    }
    static void DFS (int start, ArrayList<Integer>[]adj, boolean[]visited){
        visited[start] = true;
        for (int i = 0;i < adj[start].size();i++)
            if (!visited[adj[start].get(i)])
                DFS(adj[start].get(i), adj, visited);
    }
}