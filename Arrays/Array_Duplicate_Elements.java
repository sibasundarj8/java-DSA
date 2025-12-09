package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
 *
 * # Array Duplicates
 *
 *   Q. Given an array arr[] of size n, containing elements from the range 1 to n, and each element appears at most twice,
 *      return an array of all the integers that appears twice.
 *
 *      Note: You can return the elements in any order but the driver code will print them in sorted order.
 *
 *    Ex.
 *      Input : arr[] = [2, 3, 1, 2, 3]
 *      Output: [2, 3]
 *      Explanation: 2 and 3 occur more than once in the given array.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁶
 *          1 ≤ arr[i] ≤ n
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Array_Duplicate_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements must be smaller then n :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(findDuplicates(arr));
    }

    /// Solution
/*
⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷-brute-force-⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷
TC : O(n²)
SC : O(1)
*/
    static ArrayList<Integer> bruteForce(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    list.add(arr[i]);
                    break;
                }
            }
        }

        return list;
    }

/*
⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷-Hash-Set-⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷
TC : O(n)
SC : O(n)
*/
    static ArrayList<Integer> hashSet(int[] arr) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            if (set.contains(val)) list.add(val);
            set.add(val);
        }

        return list;
    }

/*
⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷-Cycle-sort-⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷
TC : O(~n)
SC : O(1)
*/
    static ArrayList<Integer> cycleSort(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            while (arr[i] != -1 && arr[i] - 1 != i) {
                int idx = arr[i] - 1;

                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                if (arr[i] == arr[idx]) {
                    list.add(arr[i]);
                    arr[i] = -1;
                    arr[idx] = -1;
                    break;
                }
            }

        }

        return list;
    }

/*
⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷-Negative-Marking-⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷⩷
TC : O(n)
SC : O(1)
*/
    static ArrayList<Integer> findDuplicates(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = Math.abs(arr[i]);
            int index = value - 1;

            if (arr[index] < 0) list.add(value);
            arr[index] *= -1;
        }

        return list;
    }
}
