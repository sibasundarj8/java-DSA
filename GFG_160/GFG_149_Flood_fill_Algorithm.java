package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 *
 * # Flood fill Algorithm
 *
 *   Q. An image is represented by a 2-D array of integers, each integer representing the pixel
 *      value of the image.
 *
 *      Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood
 *      fill, and a pixel value newColor, "flood fill" the image.
 *
 *      To perform a "flood fill", consider the starting pixel, plus any pixels connected
 *      4-directionally to the starting pixel of the same color as the starting pixel, plus
 *      any pixels connected 4-directionally to those pixels (also with the same color as the
 *      starting pixel), and so on. Replace the color of all the aforementioned pixels with
 *      the new color.
 *   Ex.
 *      Input : image = [[1, 1, 1],
 *                       [1, 1, 0],
 *                       [1, 0, 1]]
 *              sr = 1
 *              sc = 1
 *              newColor = 2
 *      Output: [[2, 2, 2],
 *               [2, 2, 0],
 *               [2, 0, 1]]
 *      Explanation: From the center of the image (with position (sr, sc) = (1, 1)), all pixels
 *                   connected by a path of the same color as the starting pixel are colored with
 *                   the new color.Note the bottom corner is not colored 2, because it is not
 *                   4-directionally connected to the starting pixel.
 */

import java.util.LinkedList;
import java.util.Queue;

public class GFG_149_Flood_fill_Algorithm {

    /// main Method
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] ans = floodFill(image, sr, sc, newColor);

        for (int[] i : ans){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // potd.code.hub
        int n = image.length;
        int m = image[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        
        bfs(sr, sc, n, m, image, visited, image[sr][sc]);
        
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                ans[i][j] = (visited[i][j]) ? newColor : image[i][j];
            }
        }
        
        return ans;
    }
    private static void bfs (int r, int c, int n, int m, int[][] image, boolean[][] visited, int iColor){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;
        
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};
        
        while (!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0;i < 4;i++){
                int nr = p.r + dRow[i];
                int nc = p.c + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                    !visited[nr][nc] && image[nr][nc] == iColor){
                    q.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
    private static class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
