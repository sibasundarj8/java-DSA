package GFG;/*
 *   Q. Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach
 *      the destination at (n - 1, n - 1). Find all possible paths that the rat can take to
 *      reach from source to destination. The directions in which the rat can move are 'U'(up),
 *      'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it
 *      is blocked and rat cannot move to it while value 1 at a cell in the matrix represents
 *      that rat can be travel through it.
 *      Note: In a path, no cell can be visited more than one time.
 *            If the source cell is 0, the rat cannot move to any other cell.
 *            In case of no path, return an empty list.
 *            The driver will output "-1" automatically.
 *      Examples:
 *              Input: mat[][] = [[1, 0, 0, 0],
 *                                [1, 1, 0, 1],
 *                                [1, 1, 0, 0],
 *                                [0, 1, 1, 1]]
 *              Output: DDRDRR DRDDRR
 *              Explanation: The rat can reach the destination at (3, 3) from (0, 0) by
 *                           two paths - DRDDRR and DDRDRR
 *                           when printed in sorted order we get DDRDRR DRDDRR.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Rat_in_a_Maze_Problem_I {
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][]arr = new int[r][c];
        System.out.println("Elements :");
        for (int i = 0; i < r; i++)
            for (int j = 0;j < c;j++)
                arr[i][j] = sc.nextInt();
        System.out.println(findPath(arr));
    }
    static ArrayList<String> findPath(int[][] mat) {
        // potd.code.hub
        int r = mat.length;
        int c = mat[0].length;
        int[][]visit = new int[r][c];
        if (mat[0][0] == 0 || mat[r-1][c-1] == 0)
            return ans;
        recPath(0,0,"",visit,mat);
        return ans;
    }
    static void recPath(int i,int j,String s,int[][]visit,int[][]mat)
    {
        int r = mat.length;
        int c = mat[0].length;
        // Base Case
        if (i<0||j<0||i>r-1||j>c-1||visit[i][j]==1||mat[i][j]==0)
            return;
        // Self Work
        if (i == r-1 && j == c-1){
            ans.add(s);
            return;
        }
        // Recursive Work
        visit[i][j] = 1;
        recPath(i-1,j,s+"U",visit,mat); //up
        recPath(i+1,j,s+"D",visit,mat); //down
        recPath(i,j-1,s+"L",visit,mat); //left
        recPath(i,j+1,s+"R",visit,mat); //right
        visit[i][j] = 0;
    }
}