package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/box-stacking/1
 *
 * # Box Stacking
 *
 *   Q. Given three arrays height[], width[], and length[] of size n, where height[i], width[i], and length[i]
 *      represent the dimensions of the ith box, find the maximum possible height of a stack formed using these
 *      boxes.
 *
 *        ◦ A box can be rotated so that any of its dimensions becomes its height.
 *        ◦ A box can be placed on top of another only if both dimensions of its base are strictly smaller than
 *          those of the box below.
 *        ◦ Multiple instances of the same box can be used.
 *
 *    Ex.
 *      Input : height[] = [4, 1, 4, 10],
 *              width [] = [6, 2, 5, 12],
 *              length[] = [7, 3, 6, 32]
 *      Output: 60
 *      Explanation: One possible arrangement of the boxes from bottom to top is shown below.
 *                   Note that there can be multiple instances of a box type.
 *
 *                                                    (1, 2, 3)
 *                                                    (2, 3, 1)
 *                                                    (4, 5, 6)
 *                                                    (5, 6, 4)
 *                                                    (6, 7, 4)
 *                                                  (10, 12, 32)
 *                                                  (12, 32, 10)
 *                                                    A   B   H
 *                   Hence, the total height of this stack is 10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
 *                   No other combination of boxes produces a height greater than this.
 *
 *  Constraints:
 *        ◦ 1 ≤ height.size(), width.size(), length.size() ≤ 100
 *        ◦ 1 ≤ height[i], width[i], length[i] ≤ 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Box_Stacking {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("height[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] height = new int[n];
        int[] width = new int[n];

        System.out.print("width[]: ");
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(s[i]);
            width[i] = sc.nextInt();
        }

        System.out.print("length: ");
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        System.out.println("Maximum possible height of a stack: ");
        System.out.println(maxHeight(height, width, length));
    }

    /// Solution
    static int maxHeight(int[] height, int[] width, int[] length) {
        // potd.code.hub
        int n = height.length;
        int[][] dimension = new int[3 * n][3];

        for (int i = 0; i < n; i++) {
            int h = height[i];
            int w = width[i];
            int l = length[i];
            int idx = 3 * i;

            dimension[idx][0] = Math.min(l, w);
            dimension[idx][1] = Math.max(l, w);
            dimension[idx][2] = h;

            dimension[idx + 1][0] = Math.min(h, w);
            dimension[idx + 1][1] = Math.max(h, w);
            dimension[idx + 1][2] = l;

            dimension[idx + 2][0] = Math.min(h, l);
            dimension[idx + 2][1] = Math.max(h, l);
            dimension[idx + 2][2] = w;
        }

        Arrays.sort(dimension, (d1, d2) -> {
            if (d1[1] == d2[1]) return d1[0] - d2[0];
            return d1[1] - d2[1];
        });

        int m = 3 * n;
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int idx = 1; idx <= m; idx++) {
            for (int prv = 0; prv <= m; prv++) {

                // recursive work simulation
                int notPick = prev[prv];
                int pick = 0;

                if (prv == 0 || dimension[idx - 1][0] < dimension[prv - 1][0] && dimension[idx - 1][1] != dimension[prv - 1][1]) {
                    pick = dimension[idx - 1][2] + prev[idx];
                }

                curr[prv] = Math.max(notPick, pick);
            }

            int[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[0];
    }
}
