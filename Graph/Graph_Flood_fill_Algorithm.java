package Graph;/*
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

public class Graph_Flood_fill_Algorithm {

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
        bfs(image, visited, sr, sc, newColor);
        
        return image;
    }
    private static class Pair{
        int r, c;
        Pair (int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private static void bfs(int[][]image, boolean[][]visited, int sr, int sc, int newColor){
        int n = image.length;
        int m = image[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        int iColor = image[sr][sc];

        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};

        while (!q.isEmpty()){
            Pair p = q.poll();
            image[p.r][p.c] = newColor;
            for (int i = 0;i < 4;i++){
                int nr = p.r + dRow[i];
                int nc = p.c + dCol[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m &&
                        image[nr][nc] == iColor && !visited[nr][nc]){
                    q.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
