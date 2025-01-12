package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
 *
 * # Container With Most Water
 *
 *   Q. Given an array arr[] of non-negative integers, where each element arr[i] represents the height
 *      of the vertical lines, find the maximum amount of water that can be contained between any two
 *      lines, together with the x-axis.
 *
 *      Note: In the case of a single vertical line it will not be able to hold water.
 *    Ex.
 *      Input : arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
 *      Output: 25
 *      Explanation: 8 and 5 are 5 distance apart. So the size of the base is 5.
 *                   Height of container = min(8, 5) = 5.
 *                   So, the total area to hold water = 5 * 5 = 25.
 */
import java.util.Scanner;

public class GFG_60_Container_With_Most_Water {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(maxWater(arr));
    }

    /// Solution
    static int maxWater(int...arr) {
        // potd.code.hub
        int n = arr.length, i = 0, j = n-1, ans = 0;
        while (i < j){
            ans = Math.max(ans, Math.min(arr[i], arr[j]) * (j-i));
            if (arr[i] < arr[j]) i++;
            else j--;
        }
        return ans;
    }
}
