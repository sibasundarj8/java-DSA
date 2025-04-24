package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1
 *
 * # Unique Number III
 *
 *   Q. Given an array of integer arr[] where, every element appears thrice except for one which
 *      occurs once.
 *
 *      Find that element which occurs once.
 *   Ex.
 *      Input : arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
 *      Output: 3
 *      Explanation: All elements except 3 occur thrice in the array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Unique_Number_III {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[]arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(getSingle(arr));
    }

    /// Solution

/*----------------------------------------------------O(32 * n)---------------------------------------------------------*/
    /*static int getSingle(int[] arr) {
        // potd.code.hub
        int ans = 0;
        for (int i = 0;i <= 31;i++){
            int count = 0;
            for (int j : arr){
                if ((j & (1 << i)) != 0){
                    count++;
                }
            }
            if (count % 3 == 1){
                ans |= (1 << i);
            }
        }
        return ans;
    }*/

/*----------------------------------------------------O(n log n)--------------------------------------------------------*/
    static int getSingle(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 1;i < n;i += 3){
            if (arr[i] != arr[i-1]){
                return arr[i-1];
            }
        }
        return arr[n-1];
    }
}
