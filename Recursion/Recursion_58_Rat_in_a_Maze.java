package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 *
 * # Rat in a Maze
 *
 *   Q. Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to
 *      reach the destination at position (n-1, n-1).
 *      The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 *
 *      The matrix contains only two possible values:
 *
 *      •  0: A blocked cell through which the rat cannot travel.
 *      •  1: A free cell that the rat can pass through.
 *
 *      Your task is to find all possible paths the rat can take to reach the destination, starting from
 *      (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along
 *      the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of
 *      the matrix and not blocked.
 *      •  If no path exists, return an empty list.
 *
 *      Note: Return the final result vector in lexicographically the smallest order.
 *   Ex.
 *      Input : maze[][] = [[1, 0, 0, 0],
 *                          [1, 1, 0, 1],
 *                          [1, 1, 0, 0],
 *                          [0, 1, 1, 1]]
 *      Output: ["DDRDRR", "DRDDRR"]
 *      Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR,
 *                   when printed in sorted order we get DDRDRR DRDDRR.
 *
 *  Constraints:
 *        2 ≤ n ≤ 5
 *        0 ≤ maze[i][j] ≤ 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_58_Rat_in_a_Maze {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of the squire matrix: ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter elements: (0/1)");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                maze[i][j] = sc.nextInt();

        // answer
        ArrayList<String> paths = ratInMaze(maze);

        System.out.println("Possible paths: ");
        for (String path : paths)
            System.out.println(path);
    }

    /// Solution
    static ArrayList<String> ratInMaze(int[][] maze) {
        // potd.code.hub
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> paths = new ArrayList<>();

        // updating paths
        getPaths(0, 0, n, maze, visited, new StringBuilder(), paths);

        return paths;
    }

    private static void getPaths(int i, int j, int n, int[][] maze, boolean[][] visited, StringBuilder path, ArrayList<String> paths) {
        // base case
        if (i == n - 1 && j == n - 1) {
            paths.add(path.toString());
            return;
        }

        // self work
        visited[i][j] = true;
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0}; // to get in lexicographical order
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int x = 0; x < 4; x++) {
            int ni = i + di[x];
            int nj = j + dj[x];
            if (0 <= ni && ni < n && 0 <= nj && nj < n && maze[ni][nj] == 1 && !visited[ni][nj]) {
                // go
                path.append(dir[x]);
                // recursive work
                getPaths(ni, nj, n, maze, visited, path, paths);
                // backtrack
                path.deleteCharAt(path.length() - 1);
            }
        }

        // backtrack
        visited[i][j] = false;
    }
}
