package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1
 *
 * # Counting elements in two arrays
 *
 *   Q. You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each
 *      element in a[], your task is to count how many elements in b[] are less than or equal to that element.
 *    Ex.
 *      Input : a[] = [4, 8, 7, 5, 1]
 *              b[] = [4, 48, 3, 0, 1, 1, 5]
 *      Output: [5, 6, 6, 6, 3]
 *      Explanation:
 *              For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are ≤ 4.
 *              For a[1] = 8 and a[2] = 7, there are 6 elements in b that are ≤ 8 and ≤ 7.
 *              For a[3] = 5, there are 6 elements in b that are ≤ 5.
 *              For a[4] = 1, there are 3 elements in b (0, 1, 1) that are ≤ 1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_Counting_elements_in_two_arrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements of Array - A");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter Elements of Array - B");
        String[] s2 = sc.nextLine().split(" ");

        int n = s1.length, m = s2.length;
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s1[i]);
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(s2[i]);

        System.out.println("Count of less : " + countLessEq(a, b));
    }

    /// Solution
/*
-------------------------------------------------------Brute-Force-------------------------------------------------------
TC : O(n ⨉ m)
SC : O(n) to return the ans ArrayList
*/
    public static ArrayList<Integer> bruteForce(int[] a, int[] b) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i : a) {
            int count = 0;
            for (int j : b) {
                if (j <= i) count++;
            }
            ans.add(count);
        }

        return ans;
    }

/*
---------------------------------------------------------Sorting---------------------------------------------------------
TC : O(m log m + n log m)
SC : O(n) to return the ans ArrayList
*/
    public static ArrayList<Integer> countLessEq(int[] a, int[] b) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(b);

        for (int i : a)
            ans.add(bs(i + 1, b));

        return ans;
    }

    private static int bs(int target, int[] arr) {
        int ans = arr.length, i = 0, j = ans - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
