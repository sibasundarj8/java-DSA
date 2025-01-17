package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
 *
 * # Product array puzzle
 *
 *   Q. Given an array, arr[] construct a product array, res[] where each element in res[i] is the
 *      product of all elements in arr[] except arr[i]. Return this resultant array, res[].
 *
 *      Note: Each element is res[] lies inside the 32-bit integer range.
 *    Ex.
 *      Input : arr[] = [10, 3, 5, 6, 2]
 *      Output: [180, 600, 360, 300, 900]
 *      Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
 *                   For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
 *                   For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
 *                   For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
 *                   For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_64_Product_array_puzzle {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)arr[i] = sc. nextInt();

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    /// Solution
    static int[] productExceptSelf(int...arr) {
        // potd.code.hub
        int n = arr.length, zero = 0, prod = 1;
        int []ans = new int[n];
        for (int i : arr){
            if (i != 0) prod *= i;
            prod %= (int)(1e9+7);
            if (i == 0) zero++;
        }
        if (zero < 2)
            for (int i = 0;i < n;i++)
                ans[i] = (zero == 1) ? (arr[i] == 0) ? prod : 0 : prod/arr[i];

        return ans;
    }
}
