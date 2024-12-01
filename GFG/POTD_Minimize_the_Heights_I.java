package GFG;/*
 * https://www.geeksforgeeks.org/problems/minimize-the-heights-i/1
 *
 * # Minimize the Heights I
 *
 *   Q. Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the
 *      height of each tower either by increasing or decreasing them by k only once.
 *
 *      Find out what could be the possible minimum difference of the height of shortest and longest towers
 *      after you have modified each tower.
 *    Ex.
 *      Input : k = 2
 *              arr[] = [1, 5, 8, 10]
 *      Output: 5
 *      Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the
 *                   smallest is 8 - 3 = 5.
 */
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Minimize_the_Heights_I {

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

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println(getMinDiff(k, arr));
    }

    /// Solution
    static int getMinDiff(int k, int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        int l = arr[n-1];
        int s = arr[0];
        int ans = l-s;

        for (int i = 1;i < n;i++){
            l = Math.max(arr[n-1]-k, arr[i-1]+k);
            s = Math.min(arr[0]+k, arr[i]-k);
            ans = Math.min(ans, l-s);
        }

        return ans;
    }
}