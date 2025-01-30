package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-times-graph-cuts-x-axis/0
 *
 * # Number of times graph cuts X-axis
 *
 *   Q. Given an integer array arr[], where each arr[i] denotes the trajectory of the graph over the plane;
 *      i.e. arr[i]>0 means graph going above its current position by arr[i] value and arr[i]<0 means graph
 *      going down by arr[i] value. If initial position of the graph is at origin, determines the number of
 *      times graph crosses or touches the X-axis.
 *    Ex.
 *      Input : arr[] = [4, -6, 2, 8, -2, 3, -12]
 *      Output: 3
 *      Explanation: 10 |
 *                   9  |                            ●
 *                   8  |                       ●   / \
 *                   7  |                      / \ /   \
 *                   6  |                     /   ●     \
 *                   5  |                    /           \
 *                   4  |       ●           /             \
 *                   3  |        \         /               \
 *                   2  |         \       /                 \
 *                   1  |          \     /                   \
 *                   0--------------\---●---------------------\--------
 *                  -1  |            \ /                       \
 *                  -2  |             ●                         \
 *                  -3  |                                        ●
 *
 *                  Graph touches the X-axis three times through index 0 to 1, through index 1 to 2, and
 *                  through index 5 to 6.
 */
import java.util.Scanner;

public class PrefixSum_01_Number_of_times_graph_cuts_X_axis {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(touchedXaxis(arr));
    }

    /// Solution
    static int touchedXaxis(int[] arr) {
        // potd.code.hub
        int prefix = 0, ans = 0;
        for (int i : arr) {
            if (prefix > 0 && prefix + i <= 0) ans++;
            else if (prefix < 0 && prefix + i >= 0) ans++;
            prefix += i;
        }
        return ans;
    }
}
