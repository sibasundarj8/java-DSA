package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-mode/1
 *
 * # Sum of Mode (Hard)
 *
 *   Q. Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all
 *      the subarrays of size k.
 *
 *      Note: The mode of a subarray is the element that occurs with the highest frequency. If multiple elements
 *            have the same highest frequency, the smallest such element is considered the mode.
 *   Ex.
 *      Input : arr[] = [1, 2, 3, 2, 5, 2, 4, 4], k = 3
 *      Output: 13
 *      Explanation: The mode of each k size subarray is [1, 2, 2, 2, 2, 4] and sum of all modes is 13.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class H_Sum_of_Mode {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("Mode sum: " + sumOfModes(arr, k));
    }

    // Solution
    static int sumOfModes(int[] arr, int k) {
        // code here
        int n = arr.length;
        int ans = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        TreeSet<int[]> set = new TreeSet<>((x, y) -> {
            if (x[1] == y[1]) return x[0] - y[0];
            return y[1] - x[1];
        });

        for (int i = 0; i < k; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[]{arr[i], 0});
            }
            int[] temp = map.get(arr[i]);
            set.remove(temp);
            temp[1]++;
            set.add(temp);
        }

        for (int i = k; i < n; i++) {
            ans += set.first()[0];

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[]{arr[i], 0});
            }

            int[] temp = map.get(arr[i]);
            set.remove(temp);
            temp[1]++;
            set.add(temp);

            temp = map.get(arr[i - k]);
            set.remove(temp);
            temp[1]--;
            if (temp[1] > 0) set.add(temp);
            else map.remove(arr[i - k]);
        }

        ans += set.first()[0];

        return ans;
    }
}
