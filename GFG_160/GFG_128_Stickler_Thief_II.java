package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/house-robber-ii/0
 *
 * # Stickler Thief II
 *
 *   Q. You are given an array arr[] which represents houses arranged in a circle, where each house
 *      has a certain value. A thief aims to maximize the total stolen value without robbing two
 *      adjacent houses.
 *      Determine the maximum amount the thief can steal.
 *
 *      Note: Since the houses are in a circle, the first and last houses are also considered
 *            adjacent.
 *   Ex.
 *      Input : arr[] = [2, 2, 3, 1, 2]
 *      Output: 5
 *      Explanation: Maximum stolen value: arr[0] + arr[2] = 2 + 3 = 5 or
 *                   arr[2] + arr[4] = 3 + 2 = 5
 */ 
import java.util.Scanner;

public class GFG_128_Stickler_Thief_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Value of houses: ");
        String[] s = sc.nextLine().split(" ");
        int[]houses = new int[s.length];
        for (int i = 0;i < s.length;i++)
            houses[i] = Integer.parseInt(s[i]);

        System.out.println(maxValue(houses));
    }

    /// Solution
    static int maxValue(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int pickFirst = solve(0, n-2, arr);
        int pickLast = solve(1, n-1, arr);

        return Math.max(pickFirst, pickLast);
    }
    private static int solve (int i, int j, int[]arr){
        int p = arr[i++], p2 = 0;
        for (;i <= j;i++){
            int curr = Math.max (arr[i] + p2, p);
            p2 = p;
            p = curr;
        }
        return p;
    }
}
