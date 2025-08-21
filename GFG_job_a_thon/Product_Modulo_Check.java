package GFG_job_a_thon;/*
 *
 * https://practice.geeksforgeeks.org/contest/job-a-thon-46-hiring-challenge/problems
 *
 * # Math Product Modulo Check (job-a-thon)  
 *
 *   Q. You are given an array of integers arr[] and an integer y.
 *      Your task is to determine whether there exist three distinct indices i, j, and k such that:
 *          • 0 ≤ i < j < k < len(arr)
 *          • The product arr[i] × arr[j] × arr[k] ends with the number y (i.e., the last digit of the product
              are equal to y).
 *      Return true if such indices exist, otherwise return false.
 *   Ex.
 *      Input : arr[] = [2, 5, 10, 3], y = 0
 *      Output: true
 *      Explanation: Choose i = 0, j = 1, k = 2 → 2 × 5 × 10 = 100.
 *                   The product ends with 0, which matches y = 0.
 *   Constraints:
 *          3 ≤ arr.size() ≤ 10^5
 *          0 ≤ arr[i] ≤ 10^7
 *          0 ≤ y ≤ 9
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Product_Modulo_Check {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("y: ");
        int y = sc.nextInt();

        System.out.println("(arr[a] * arr[b] * arr[c]) % 10 = y : ");
        System.out.println(modMatch(arr, y));
    }

    /// Solution
    static boolean modMatch(int[] arr, int y) {
        // potd.code.hub
        int[] freq = new int[10];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            int idx = i % 10;
            if (freq[idx] < 3) freq[idx]++;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < freq[i]; j++) {
                list.add(i);
            }
        }

        int n = list.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int mul = list.get(i) * list.get(j) * list.get(k);
                    if (mul % 10 == y) return true;
                }
            }
        }

        return false;
    }
}
