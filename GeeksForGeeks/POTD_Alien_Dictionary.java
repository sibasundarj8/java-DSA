package GFG;/*
 *   Q. Given a sorted dictionary of an alien language having N words and k starting alphabets
 *      of standard dictionary. Find the order of characters in the alien language.
 *   Note: Many orders may be possible for a particular test case, thus you may return any valid
 *   order and output will be 1 if the order of string returned by the function is correct else 0
 *   denoting incorrect string returned.
 *          Examples :
 *                  Input:  n = 5, k = 4, dict = {"baa","abcd","abca","cab","cad"}
 *                  Output: 1
 *                  Explanation: Here order of characters is 'b', 'd', 'a', 'c' Note that words
 *                               are sorted and in the given language "baa" comes before "abcd",
 *                               therefore 'b' is before 'a' in output.
 *                               Similarly, we can find other orders.
 */
import java.util.*;

public class POTD_Alien_Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size : ");
        int n = sc.nextInt();
        System.out.println("Enter the Number of vertices : ");
        int k = sc.nextInt();
        String[]dict = new String[n];
        System.out.println("Enter Words : ");
        for (int i = 0;i < n;i++)
            dict[i] = sc.next();
        System.out.println(findOrder(dict, n, k));
    }
    static String findOrder(String[] dict, int n, int k) {
        // @ potd.code.hub
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0;i < k;i++)
            graph.add(new ArrayList<>());

        for (int i = 0;i < n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0;j <  len;j++)
                if (s1.charAt(j) != s2.charAt(j)) {
                    graph.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            if (s1.length() < s2.length())return "0";
        }
        List<Integer>topo = topoSort(k,graph);
        String ans = "";
        for (int i : topo)
            ans += (char)(i + (int)'a');
        return ans;
    }
    static List<Integer>topoSort(int v,List<List<Integer>>graph){
        int[]inDegree = new int[v];
        for (int i = 0;i < v;i++)
            for (int j : graph.get(i))
                inDegree[j]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < v;i++)
            if (inDegree[i] == 0)
                q.add(i);
        List<Integer>topo = new ArrayList<>();
        while (!q.isEmpty()){
            int curr = q.remove();
            topo.add(curr);
            for (int j : graph.get(curr)){
                inDegree[j]--;
                if (inDegree[j] == 0) q.add(j);
            }
        }
        return topo;
    }
}