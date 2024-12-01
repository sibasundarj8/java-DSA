package GFG;/*
 *   Q. Given an array of integers arr, return true if it is possible to split it in two subArrays
 *      (without reordering the elements), such that the sum of the two subArrays are equal. If it
 *      is not possible then return false.
 *    Examples:
 *          Input: arr = [1, 2, 3, 4, 5, 5]
 *          Output: true
 *          Explanation:
 *                  In the above example, we can divide the array into two subArrays with equal sum.
 *                  The two subArrays are: [1, 2, 3, 4] and [5, 5]. The sum of both the subArrays are 10.
 *                  Hence, the answer is true.
 */
import java.util.Scanner;

public class POTD_Split_an_array_into_two_equal_Sum_subArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of the Array :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println(canSplit(arr));
    }
    static boolean canSplit(int[]arr) {
        // @ potd.code.hub
        for (int i = 1;i < arr.length;i++)
            arr[i] += arr[i-1]; // prefix sum
        for (int i : arr)
            if (2*i == arr[arr.length-1])
                return true;
        return false;
    }
}
