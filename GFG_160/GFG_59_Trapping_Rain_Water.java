package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/0
 *
 * # Trapping Rain Water
 *
 *   Q. Given an array arr[] with non-negative integers representing the height of blocks. If the width of
 *      each block is 1, compute how much water can be trapped between the blocks during the rainy season.
 *    Ex.
 *      Input : arr[] = [3, 0, 0, 2, 0, 4]
 *      Output: 10
 *      Explanation:               [ ]
 *                   [ ]%%%%%%%%%%%[ ]
 *                   [ ]%%%%%[ ]%%%[ ]
 *                   [ ]%%%%%[ ]%%%[ ]
 *                    3  0 0  2  0  4
 *                  ------------------
 *                    0  3 3  1  3  0 += 10
 */
import java.util.Scanner;

public class GFG_59_Trapping_Rain_Water {

    /// main Method
    public static void main(String...args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Heights: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(maxWater(arr));
    }

    /// Solution
    static int maxWater(int...arr) {
        // potd.code.hub
        int n = arr.length, lMax = 0, rMax = 0, ans = 0;

        int i = 0, j = n-1;
        while (i < j){
            lMax = Math.max(lMax, arr[i]);
            rMax = Math.max(rMax, arr[j]);
            if (lMax < rMax) ans += lMax - arr[i++];
            else ans += rMax - arr[j--];
        }

        return ans;
    }
}
