package Trie;/*
 *
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 *
 * # 3043. Find the Length of the Longest Common Prefix
 *
 *   Q. You are given two arrays with positive integers arr1 and arr2.
 *
 *      A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit.
 *      For example, 123 is a prefix of the integer 12345, while 234 is not.
 *
 *      A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b. For example,
 *      5655359 and 56554 have common prefixes 565 and 5655 while 1223 and 43456 do not have a common prefix.
 *
 *      You need to find the length of the longest common prefix between all pairs of integers (x, y) such that x belongs
 *      to arr1 and y belongs to arr2.
 *
 *      Return the length of the longest common prefix among all pairs. If no common prefix exists among them, return 0.
 *
 *    Ex.
 *      Input : arr1 = [1,10,100], arr2 = [1000]
 *      Output: 3
 *      Explanation: There are 3 pairs (arr1[i], arr2[j]):
 *                    - The longest common prefix of (1, 1000) is 1.
 *                    - The longest common prefix of (10, 1000) is 10.
 *                    - The longest common prefix of (100, 1000) is 100.
 *                   The longest common prefix is 100 with a length of 3.
 *
 *  Constraints:
 *          1 <= arr1.length, arr2.length <= 5 * 10⁴
 *          1 <= arr1[i], arr2[i] <= 10⁸
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class T05_Find_the_Length_of_the_Longest_Common_Prefix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter arr1[] elements: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter arr2[] elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(s1[i]);
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("Length of the longest common prefix among all pairs : ");
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    /// Solution
/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Sorting-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
SC : O(x log x) : x --> n + m
SC : O(n + m)
*/
    static int sorting(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int res = 0;
        String[][] temp = new String[n + m][2];

        for (int i = 0; i < n; i++) {
            temp[i][0] = Integer.toString(arr1[i]);
            temp[i][1] = "1";
        }

        for (int i = 0; i < m; i++) {
            temp[n + i][0] = Integer.toString(arr2[i]);
            temp[n + i][1] = "2";
        }

        Arrays.sort(temp, Comparator.comparing(a -> a[0]));

        for (int i = 1; i < n + m; i++) {
            if (!temp[i][1].equals(temp[i - 1][1])) {
                res = Math.max(res, countPrefix(temp[i][0], temp[i - 1][0]));
            }
        }

        return res;
    }

    private static int countPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            count++;
        }

        return count;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Hashing-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O((n + m) * D) : D --> number of digits in each element ~9
SC : O(n * D)
*/
    static int hashing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int maxCPL = 0;
    
        HashSet<Integer> set = new HashSet<>();
    
        for (int ele : arr1) {
            while (ele > 0) {
                set.add(ele);
                ele /= 10;
            }
        }
    
        for (int ele : arr2) {
            while (ele > 0) {
                if (set.contains(ele)) {
                    int size = (int) Math.log10(ele) + 1;
                    maxCPL = Math.max(maxCPL, size);
                }
                ele /= 10;
            }
        }
    
        return maxCPL;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Trie-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O((n + m) * D) : D --> number of digits in each element ~9
SC : O(n * D)
*/
    static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxCPL = 0; // max common prefix length
        Trie trie = new Trie();
    
        // insert the arr1 elements in trie.
        for (int ele : arr1) {
            trie.insert(ele);
        }
    
        // check common prefixes of arr2 elements using trie.
        for (int ele : arr2) {
            maxCPL = Math.max(maxCPL, trie.commonPrefixLength(ele));
        }
    
        return maxCPL;
    }

    // Structure and methods of trie. Don't remove static from anywhere billow this comment.
    private static class Trie {
        private final Trie[] children = new Trie[9];

        void insert(int n) {
            // code here
            Trie cur = this;
            String num = Integer.toString(n);
            int len = num.length();

            for (int i = 0; i < len; i++) {
                int idx = num.charAt(i) - '0';

                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }

                cur = cur.children[idx];
            }
        }

        int commonPrefixLength(int n) {
            // code here
            Trie cur = this;
            String s = Integer.toString(n);
            int len = s.length();
            int count = 0;

            for (int i = 0; i < len; i++) {
                int idx = s.charAt(i) - '0';

                if (cur.children[idx] == null) {
                    break;
                }

                cur = cur.children[idx];
                count++;
            }

            return count;
        }
    }
}
