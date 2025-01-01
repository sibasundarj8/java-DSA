package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 *
 * # Trapping Rain Water
 *
 *   Q. Given an array arr[] with non-negative integers representing the height of blocks. If the width of
 *      each block is 1, compute how much water can be trapped between the blocks during the rainy season.
 *    Ex.
 *      Input : arr[] = [3, 0, 0, 2, 0, 4]
 *      Output: 10
 *      Explanation:               [*]
 *                   [*]%%%%%%%%%%%[*]
 *                   [*]%%%%%[*]%%%[*]
 *                   [*]%%%%%[*]%%%[*]
 *                    3  0 0  2  0  4
 *                  -------------------
 *                    0+ 3+3+ 1+ 3+ 0 = 10
 */
import java.util.Arrays;
import java.util.Scanner;

public class Array_Trapping_Rain_Water {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(trappingWater(arr));
    }

    /// Solution
    static int trappingWater(int...arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        // calculating amount of water
        int i = 0, j = n-1;
        while (i < j){
            leftMax = Math.max(leftMax, arr[i]);
            rightMax = Math.max(rightMax, arr[j]);
            if (leftMax > rightMax) ans += rightMax - arr[j--];
            else ans += leftMax - arr[i++];
        }

        return ans;
    }
}
