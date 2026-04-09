package Two_Pointers;/*
 *
 * https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-arrays-with-duplicate-elements/1
 *
 * # Intersection of Two Sorted Arrays
 *
 *   Q. Given two sorted arrays a[] and b[], where each array may contain duplicate elements, return the elements in the
 *      intersection of the two arrays in sorted order.
 *
 *      Note: Intersection of two arrays can be defined as the set containing distinct common elements that are present
 *            in both of the arrays.
 *    Ex.
 *      Input : a[] = [1, 1, 2, 2, 2, 4],
 *              b[] = [2, 2, 4, 4]
 *      Output: [2, 4]
 *      Explanation: Distinct common elements in both the arrays are: 2 and 4.
 *
 *  Constraints:
 *          1 ≤ a.size(), b.size() ≤ 10⁵
 *          -10⁹ ≤ a[i], b[i] ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Q03_Intersection_of_Two_Sorted_Arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of a[] : ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter elements of b[] : ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }

        System.out.println("Intersection of two arrays : ");
        System.out.println(intersection(a, b));
    }

    /// Solution
/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Hashing-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n + m)
SC : O(n)
*/
    static ArrayList<Integer> bruteforce(int[] a, int[] b) {
        // potd.code.hub
        int m = b.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int ele : a) {
            set.add(ele);
        }

        if (set.contains(b[0])) {
            ans.add(b[0]);
        }
        for (int i = 1; i < m; i++) {
            if (set.contains(b[i]) && b[i] != b[i - 1]) {
                ans.add(b[i]);
            }
        }

        return ans;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-two-pointer-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(n + m)
SC : O(1)
*/
    static ArrayList<Integer> intersection(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (a[i] == b[j]) {
                if (ans.isEmpty() || ans.getLast() != a[i]) {
                    ans.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) i++;
            else j++;
        }

        return ans;
    }
}
