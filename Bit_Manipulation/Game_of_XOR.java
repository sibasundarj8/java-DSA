package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/game-of-xor1541/1
 *
 * # Game of XOR
 *
 *   Q. You are given an integer array arr[]. The value of a subarray is defined as the bitwise XOR of all elements in
 *      that subarray. Your task is to compute the bitwise XOR of the values of all possible subarrays of arr[].
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3]
 *      Output: 2
 *      Explanation: xor[1] = 1
 *                   xor[1, 2] = 3
 *                   xor[2, 3] = 1
 *                   xor[1, 2, 3] = 0
 *                   xor[2] = 2
 *                   xor[3] = 3
 *                   Result : 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game_of_XOR {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Bitwise XOR of the values of all possible sub-arrays: ");
        System.out.println(subarrayXor(arr));
    }

    /// Solution
    public static int subarrayXor(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int xor = 0;

        if(n % 2 == 0) return 0;

        for(int i = 0; i < n; i += 2) xor ^= arr[i];
        
        return xor;
    }
}
