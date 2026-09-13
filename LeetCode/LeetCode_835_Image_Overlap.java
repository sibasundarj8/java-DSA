package LeetCode;/*
 *
 * https://leetcode.com/problems/image-overlap/
 *
 * # LC. 835. Image Overlap
 *
 *   Q. You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix
 *      has only 0s and 1s as values.
 *
 *      We translate one image however we choose by sliding all the 1 bit's left, right, up, and/or down any number of
 *      units. We then place it on top of the other image. We can then calculate the overlap by counting the number of
 *      positions that have a 1 in both images.
 *
 *      Note also that a translation does not include any kind of rotation. Any 1 bit's that are translated outside the
 *      matrix borders are erased.
 *
 *      Return the largest possible overlap.
 *
 *    Ex.
 *      Input : img1 = [[1, 1, 0],
 *                      [0, 1, 0],
 *                      [0, 1, 0]],
 *              img2 = [[0, 0, 0],
 *                      [0, 1, 1],
 *                      [0, 0, 1]]
 *      Output: 3
 *      Explanation: We translate img1 to right by 1 unit and down by 1 unit.
 *
 *                      1  1  0    >     0  1  1     v     0  0  0
 *                      0  1  0   --->   0  0  1    --->   0  1  1
 *                      0  1  0          0  0  1           0  0  1
 *
 *  Constraints:
 *        ◦ n == img1.length == img1[i].length
 *        ◦ n == img2.length == img2[i].length
 *        ◦ 1 <= n <= 30
 *        ◦ img1[i][j] is either 0 or 1.
 *        ◦ img2[i][j] is either 0 or 1.
 */

import java.util.Scanner;

public class LeetCode_835_Image_Overlap {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.println("img-1: (n × n binary matrix)");
        int[][] img1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img1[i][j] = sc.nextInt();
                if (img1[i][j] != 1 && img1[i][j] != 0) {
                    throw new IllegalArgumentException("Invalid input");
                }
            }
        }

        System.out.println("img-2: (n × n binary matrix)");
        int[][] img2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                img2[i][j] = sc.nextInt();
                if (img2[i][j] != 1 && img2[i][j] != 0) {
                    throw new IllegalArgumentException("Invalid input");
                }
            }
        }

        System.out.println("Max overlap after translate: ");
        System.out.println(largestOverlap(img1, img2));
    }

    /// Solution
    static int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int m1 = 0;
        int m2 = 0;
        int[][] a = new int[n * n][2];
        int[][] b = new int[n * n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    a[m1][0] = i;
                    a[m1++][1] = j;
                }

                if (img2[i][j] == 1) {
                    b[m2][0] = i;
                    b[m2++][1] = j;
                }
            }
        }

        int max = 0;
        int[][] shiftCount = new int[n << 1][n << 1];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < m2; j++) {
                int dx = a[i][0] - b[j][0] + n; // row shift
                int dy = a[i][1] - b[j][1] + n; // col shift

                shiftCount[dx][dy]++;
                max = Math.max(max, shiftCount[dx][dy]);
            }
        }

        return max;
    }
}
