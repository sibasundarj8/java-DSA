package LeetCode;/*
 *
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 *
 * # 2300. Successful Pairs of Spells and Potions
 *
 *   Q. You are given two positive integer arrays spells and potions, of length n and m respectively, where
 *      spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth
 *      potion.
 *
 *      You are also given an integer success. A spell and potion pair is considered successful if the product
 *      of their strengths is at least success.
 *
 *      Return an integer array pairs of length n where pairs[i] is the number of potions that will form a
 *      successful pair with the ith spell.
 *   Ex.
 *      Input : spells = [5,1,3],
 *              potions = [1,2,3,4,5],
 *              success = 7
 *      Output: [4,0,3]
 *      Explanation:
 *              - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 *              - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 *              - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 *              Thus, [4,0,3] is returned.
 *
 * Constraints:
 *      •  n == spells.length
 *      •  m == potions.length
 *      •  1 <= n, m <= 10⁵
 *      •  1 <= spells[i], potions[i] <= 10⁵
 *      •  1 <= success <= 10¹⁰
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2300_Successful_Pairs_of_Spells_and_Potions {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter spells[]: ");
        String[] x = sc.nextLine().split(" ");

        System.out.println("Enter potions[]: ");
        String[] y = sc.nextLine().split(" ");

        int n = x.length;
        int m = y.length;
        int[] spells = new int[n];
        int[] potions = new int[m];

        for (int i = 0; i < n; i++) spells[i] = Integer.parseInt(x[i]);
        for (int i = 0; i < m; i++) potions[i] = Integer.parseInt(y[i]);

        System.out.println("Enter success: ");
        int success = sc.nextInt();

        System.out.println("Successful pairs: ");
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    /// Solution
    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        // potd.code.hub
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        // sort the potions[]
        Arrays.sort(potions);  // O(n log n)

        for (int i = 0; i < n; i++) // O(n)
            ans[i] = (spells[i] >= success) ? m : m - bs(potions, spells[i], success, m); // O(log n)
        // total -> O(n log n + n * log n) => O(n log n)

        return ans;
    }

    // helper method --> lower bound using binary search
    private static int bs(int[] arr, int start, long success, int n) { // O(log n)
        int i = 0;
        int j = n - 1;
        int ans = n;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if ((long) start * arr[mid] >= success) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
