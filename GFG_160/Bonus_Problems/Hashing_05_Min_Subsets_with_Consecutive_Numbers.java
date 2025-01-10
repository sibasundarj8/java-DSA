package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/min-subsets-with-consecutive-numbers0601/0
 *
 * # Min Subsets with Consecutive Numbers
 *
 *   Q. Given an array of distinct positive numbers, the task is to calculate the minimum number of
 *      subsets (or subsequences) from the array such that each subset contains consecutive numbers.
 *    Ex.
 *      Input : arr[] = [100, 56, 5, 6, 102, 58, 101, 57, 7, 103]
 *      Output:3
 *      Explanation: {5, 6, 7}, {56, 57, 58}, {100, 101, 102, 103} are 3 subset
 *                   in which numbers are consecutive.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Hashing_05_Min_Subsets_with_Consecutive_Numbers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println(numOfSubset(arr));
    }

    /// Solution
    static int numOfSubset(int...arr) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : arr) set.add(i);
        for (int i : arr) if (!set.contains(i-1)) count++;

        return count;
    }
}
