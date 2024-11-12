/*
 *   Q. Given an integer array arr of integers, the task is to find the maximum absolute difference
 *      between the nearest left smaller element and the nearest right smaller element of every element
 *      in array arr. If for any component of the arr, the nearest smaller element doesn't exist then
 *      consider it as 0.
 *    Examples:
 *          Input: arr = [2, 4, 8, 7, 7, 9, 3]
 *          Output: 4
 *     Explanation: left smaller array ls = [0, 2, 4, 4, 4, 7, 2],
 *                  right smaller Array rs = [0, 3, 7, 3, 3, 3, 0].
 *                  Maximum Diff of abs(ls[i] - rs[i]) = abs(7 - 3) = 4
 */
package GFG;


import java.util.Scanner;
import java.util.Stack;

public class POTD_Maximum_Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Output :");
        System.out.println(findMaxDiff(arr));
    }
    static int findMaxDiff(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int[]left = new int[n];
        int[]right = new int[n];
        Stack<Integer>s1 = new Stack<>();
        Stack<Integer>s2 = new Stack<>();
        s1.push(0);
        s2.push(0);
        for (int i = 0;i < n;i++) {
            while (!s1.isEmpty() && s1.peek() >= arr[i])
                s1.pop();
            left[i] = s1.peek();
            s1.push(arr[i]);
        }
        for (int i = n-1;i >= 0;i--){
            while (!s2.isEmpty() && s2.peek() >= arr[i])
                s2.pop();
            right[i] = s2.peek();
            s2.push(arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i < n;i++)
            ans = Math.max(ans, Math.abs(left[i]-right[i]));
        return ans;
    }
}