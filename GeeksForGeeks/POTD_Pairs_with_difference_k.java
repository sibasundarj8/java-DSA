package GFG;/*
 * https://www.geeksforgeeks.org/problems/pairs-with-difference-k1713/1
 *
 * # Pairs with difference k
 *
 *      Q.  Given an array arr[] of positive integers. Find the number of pairs of integers whose difference
 *          equals a given number k.
 *          Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are
 *                 considered different.
 *        Ex.
 *          Input : arr[] = [8, 12, 16, 4, 0, 20]
 *                  k = 4
 *          Output: 5
 *          Explanation: There are 5 pairs with difference 4, the pairs are {0,4}, {4,8}, {8,12}, {12,16}
 *                       and {16,20}.
 */
import java.util.HashMap;
import java.util.Scanner;

public class POTD_Pairs_with_difference_k {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size : ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("K : ");
        int k = sc.nextInt();

        System.out.println("No. of pairs : " + countPairsWithDiffK(arr, k));
    }
    static int countPairsWithDiffK(int[] arr, int k) {
        // potd.code.hub
        int res = 0;
        HashMap<Integer,Integer> table = new HashMap<>();
        for (int i : arr) {
            res += table.getOrDefault(i - k, 0);
            res += table.getOrDefault(i + k, 0);
            table.put(i, table.getOrDefault(i, 0) + 1);
        }
        return res;
    }
}