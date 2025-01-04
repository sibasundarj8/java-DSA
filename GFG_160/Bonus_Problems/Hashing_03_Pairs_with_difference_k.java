package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/pairs-with-difference-k1713/0
 *
 * # Pairs with difference k
 *
 *   Q. Given an array arr[] of positive integers. Find the number of pairs of integers whose absolute
 *      difference equals to a given number k.
 *
 *      Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices
 *            are considered different.
 *
 *      The answer is guaranteed to fit in a 32-bit integer.
 *    Ex.
 *      Input : arr[] = [8, 16, 12, 16, 4, 0]
 *              k = 4
 *      Output: 5
 *      Explanation: There are 5 pairs with absolute difference 4,
 *                   the pairs are {8, 12}, {8, 4}, {16, 12}, {12, 16}, {4, 0}.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Hashing_03_Pairs_with_difference_k {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(countPairs(arr, k));
    }

    /// Solution
    static int countPairs(int[] arr, int k) {
        // potd.code.hub
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : arr){
            ans += map.getOrDefault(i+k, 0);
            ans += map.getOrDefault(i-k, 0);
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        return ans;
    }
}
