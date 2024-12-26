package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/key-pair5616/1
 *
 * # Two Sum - Pair with Given Sum
 *
 *   Q. Given an array arr[] of positive integers and another integer target. Determine if there exists two
 *      distinct indices such that the sum of their elements is equals to target.
 *    Ex.
 *      Input : arr[] = [1, 4, 45, 6, 10, 8]
 *              target = 16
 *      Output: true
 *      Explanation: arr[3] + arr[4] = 6 + 10 = 16.
 */
import java.util.HashSet;
import java.util.Scanner;

public class GFG_42_Two_Sum_Pair_with_Given_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(twoSum(arr, target));
    }

    /// Solution
    static boolean twoSum(int[]arr, int target) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr){
            if (set.contains(target - i)) return true;
            set.add(i);
        }

        return false;
    }
}
