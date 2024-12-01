/*
 *   Q. Given an array arr[] of non-negative integers. Each array element represents the maximum
 *      length of the jumps that can be made forward from that element. This means if arr[i] = x,
 *      then we can jump any distance y such that y ≤ x. Find the minimum number of jumps to reach
 *      the end of the array starting from the first element. If an element is 0, then you cannot
 *      move through that element.
 *
 *      Note:  Return -1 if you can't reach the end of the array.
 *
 *      Input : arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 *      Output: 3
 *      Explanation:
 *                  First jump from 1st element to 2nd element with value 3. From here we jump to
 *                  5th element with value 9, and from here we will jump to the last.
 */
package GFG;

import java.util.Scanner;

public class POTD_Minimum_Jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println(minJumps(arr));
    }
    static int minJumps(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int max = 0;
        int choice = 0;
        int jumps = 0;

        for (int i = 0;i < n-1;i++){
            max = Math.max(max, arr[i]+i);
            if (i == choice){
                choice = max;
                jumps++;
            }
            if (choice >= n-1) return jumps;
        }
        return -1;
    }
}