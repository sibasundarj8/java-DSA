package LeetCode;/*
 *
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * # 1331. Rank Transform of an Array
 *
 *   Q. Given an array of integers arr, replace each element with its rank.
 *
 *      The rank represents how large the element is. The rank has the following rules:
 *        ◦ Rank is an integer starting from 1.
 *        ◦ The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 *        ◦ Rank should be as small as possible.
 *
 *    Ex.
 *      Input : arr = [37, 12, 28, 9, 100, 56, 80, 5, 12]
 *      Output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
 *
 *  Constraints:
 *        0 <= arr.length <= 10⁵
 *        -10⁹ <= arr[i] <= 10⁹
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_1331_Rank_Transform_of_an_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Ranks: ");
        int[] res = arrayRankTransform(arr);
        System.out.println(Arrays.toString(res));
    }

    /// Solution
    static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        System.arraycopy(arr, 0, temp, 0, n);
        Arrays.sort(temp);

        int id = 1;

        for (int ele : temp) {
            if (!map.containsKey(ele)) {
                map.put(ele, id++);
            }
        }

        for (int i = 0; i < n; i++) {
            temp[i] = map.get(arr[i]);
        }

        return temp;
    }
}
