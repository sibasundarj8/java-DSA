package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
 *
 * # Count Sub-arrays with given XOR
 *
 *   Q. Given an array of integers arr[] and a number k, count the number of sub-arrays having XOR of their
 *      elements as k.
 *    Ex.
 *      Input : arr[] = [4, 2, 2, 6, 4]
 *              k = 6
 *      Output: 4
 *      Explanation: The sub-arrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6]
 *                   and [6]. Hence, the answer is 4.
 */
import java.util.HashMap;
import java.util.Scanner;

public class GFG_50_Count_SubArrays_with_given_XOR {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc. nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("K:");
        int k = sc.nextInt();

        System.out.println(subarrayXor(arr, k));
    }

    /// Solution
    static long subarrayXor(int []arr, int k) {
        // potd.code.hub
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int x = 0, ans = 0;
        for (int i : arr){
            x ^= i;
            ans += map.getOrDefault(x^k, 0);
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        return ans;
    }
}
