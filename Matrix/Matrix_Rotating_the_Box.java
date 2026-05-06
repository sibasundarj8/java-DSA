package Matrix;/*
 *
 * https://leetcode.com/problems/rotating-the-box/
 *
 * # 1861. Rotating the Box
 *
 *   Q. You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one
 *      of the following:
 *        ◦ A stone '#'
 *        ◦ A stationary obstacle '*'
 *        ◦ Empty '.'
 *
 *      The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down
 *      until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles'
 *      positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 *
 *      It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
 *
 *      Return an n x m matrix representing the box after the rotation described above.
 *
 *    Ex.
 *          Before Rotation (90°)                                       After Rotation  ↻ 90°
 *          +---+---+---+---+---+---+                                       +---+---+---+
 *          | 🁢 | 🁢 | 💢 | . | 💢| . |                                       | . | 🁢 | 🁢 |
 *          +---+---+---+---+---+---+                                       +---+---+---+
 *          | 🁢 | 🁢 | 🁢 | 💢 | . | . |                                       | . | 🁢 | 🁢 |
 *          +---+---+---+---+---+---+                                       +---+---+---+
 *          | 🁢 | 🁢 | 🁢 | . | 🁢 | . |                                       | 🁢 | 🁢 | 💢 |
 *          +---+---+---+---+---+---+                                       +---+---+---+
 *                                                                          | 🁢 | 💢 | . |
 *      Input : boxGrid = [["#", "#", "*", ".", "*", "."],                  +---+---+---+
 *                         ["#", "#", "#", "*", ".", "."],                  | 🁢 | . | 💢 |
 *                         ["#", "#", "#", ".", "#", "."]]                  +---+---+---+
 *      Output: [[".", "#", "#"],                                           | 🁢 | . | . |
 *               [".", "#", "#"],                                           +---+---+---+
 *               ["#", "#", "*"],
 *               ["#", "*", "."],
 *               ["#", ".", "*"],
 *               ["#", ".", "."]]
 *
 *  Constraints:
 *          m == boxGrid.length
 *          n == boxGrid[i].length
 *          1 <= m, n <= 500
 *          boxGrid[i][j] is either '#', '*', or '.'.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Rotating_the_Box {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];

        System.out.println("""
                Enter elements:
                    ◦ A stone '#'
                    ◦ A stationary obstacle '*'
                    ◦ Empty '.'
                """);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = sc.next().charAt(0);

                if (!(ch == '#' || ch == '.' || ch == '*')) {
                    throw new IllegalArgumentException();
                }

                grid[i][j] = ch;
            }
        }

        char[][] ans = rotateTheBox(grid);

        System.out.println("Rotated array: ");
        for (char[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    /// Solution
    static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] newGrid = new char[m][n];

        // rotating the box by 90°
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int col = n - 1 - i;
                newGrid[j][col] = boxGrid[i][j];
            }
        }

        // applying gravity on the box
        int[] down = new int[n];
        Arrays.fill(down, m - 1);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                char ch = newGrid[i][j];
                if (ch == '*') {
                    down[j] = i - 1;
                } else if (ch == '#') {
                    char temp = newGrid[down[j]][j];
                    newGrid[down[j]][j] = ch;
                    newGrid[i][j] = temp;
                    down[j]--;
                }
            }
        }

        return newGrid;
    }
}
