package LeetCode;/*
 *
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
 *
 * # 3394. Check if Grids can be Cut into Sections
 *
 *   Q. You are given an integer n representing the dimensions of an n x n grid, with the origin in
 *      the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles,
 *      where rectangles[i] is in the form [startX, startY, endX, endY], representing a rectangle on
 *      the grid. Each rectangle is defined as follows:
 *
 *       • (startX, startY): The bottom-left corner of the rectangle.
 *       • (endX, endY): The top-right corner of the rectangle.
 *      Note that the rectangles do not overlap. Your task is to determine if it is possible to make
 *      either two horizontal or two vertical cuts on the grid such that:
 *
 *       • Each of the three resulting sections formed by the cuts contains at least one rectangle.
 *       • Every rectangle belongs to exactly one section.
 *      
 *      Return true if such cuts can be made; otherwise, return false.
 *   Ex.
 *      Input : n = 5, rectangles = [[1,0,5,2],
 *                                   [0,2,2,4],
 *                                   [3,2,5,3],
 *                                   [0,4,4,5]]
 *      Output: true
 */
import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3394_Check_if_Grid_can_be_Cut_into_Sections {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int m = sc.nextInt();

        int[][] rectangles = new int[m][4];

        System.out.println("Dimensions: ");
        for (int i = 0; i < m; i++){
            rectangles[i][0] = sc.nextInt();
            rectangles[i][1] = sc.nextInt();
            rectangles[i][2] = sc.nextInt();
            rectangles[i][3] = sc.nextInt();
        }

        System.out.println("n: ");
        int n = sc.nextInt();

        System.out.println(checkValidCuts(n, rectangles));
    }

    /// Solution
    static boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length;
        int[][]x = new int[m][2];
        int[][]y = new int[m][2];
        for (int i = 0;i < m;i++){
            x[i][0] = rectangles[i][0];
            y[i][0] = rectangles[i][1];
            x[i][1] = rectangles[i][2];
            y[i][1] = rectangles[i][3];
        }

        return check(x) || check(y);
    }
    private static boolean check (int[][]arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;
        int max = arr[0][1], count = 0;
        for (int i = 1;i < n;i++){
            if (arr[i][0] >= max) count++;
            if (arr[i][1] > max)
                max = arr[i][1];
        }
        return count > 1;
    }
}
