package Array;/*
 * # Minimum Jumps
 *
 * Q. Given an array of integers points of size n, you can move from ith point to (i+l)th point in
 *    one jump, or you can move from ith point to jth point in one jump if both points[i] and points[j]
 *    are perfect squares. You are at 1st point initially. You need to determine the minimum number
 *    of jumps required to reach the nth point.
 *  Ex.
 *     Input: points[] = [1, 2, 3]
 *     Output: 2
 *     Explanation: First jump from 1st point to 2nd point and then from 2nd point to 3rd point.
 */
import java.util.Scanner;

public class Array_Minimum_Jumps {

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

        System.out.println(minimumJump(arr));
    }

    /// Solution
     static int minimumJump(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = n-1;
        int i = 0;
        int j = n-1;
        while (i < j) {
            if (isSqr(arr[i]) && isSqr(arr[j])){
                ans = n - j + i;
                break;
            }
            if (!isSqr(arr[i])) i++;
            if (!isSqr(arr[j])) j--;
        }
        return ans;
    }
    private static boolean isSqr (int x) {
        int n = (int)Math.sqrt(x);
        return n * n == x;
    }
}
