package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1
 *
 * # Minimum Insert and Delete to Convert
 *
 *   Q. Given two arrays a[] and b[] of size n and m respectively, find the minimum number of insertions and deletions on
 *      the array a[], required to make both the arrays identical.
 *
 *      Note: Array b[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily
 *            at the end.
 *
 *    Ex.
 *      Input : a[] = [1, 2, 5, 3, 1]
 *              b[] = [1, 3, 5]
 *      Output: 4
 *      Explanation:
 *              Delete 2 from a: a[] = [1, 5, 3, 1]
 *              Insert 3 after 1: a[] = [1, 3, 5, 3, 1]
 *              Delete the last two elements: a[] = [1, 3, 5]
 *              Total operations = 1 + 1 + 2 = 4.
 *
 *   Constraints:
 *          1 ≤ n, m ≤ 10⁵
 *          1 ≤ a[i], b[i] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Minimum_Insert_and_Delete_to_Convert {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a[] elements: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter b[] elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int m = s2.length;
        if (m > n) throw new IllegalArgumentException("b[] must be smaller or equal to a[]");

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s1[i]);
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(s2[i]);

        System.out.println("Minimum number of insertions and deletions required: ");
        System.out.println(minInsAndDel(a, b));
    }

    /// Solution
    static int minInsAndDel(int[] a, int[] b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;

        List<Integer> list = new ArrayList<>(n);
        HashSet<Integer> set = new HashSet<>();

        for (int ele : b) {
            set.add(ele);
        }

        for (int ele : a) {
            if (!set.contains(ele)) continue;

            if (list.isEmpty() || ele > list.getLast()) list.add(ele);
            else list.set(lowerBound(list, ele), ele);
        }

        int lcis = list.size();

        return (n - lcis) + (m - lcis);
    }

    private static int lowerBound(List<Integer> list, int target) {
        int n = list.size();
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) >= target) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }
}
