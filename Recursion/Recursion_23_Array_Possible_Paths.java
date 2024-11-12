package Recursion;/*
*  Q.  Count all the possible paths on an m x n grid from top left (grid[0][0])
*      to bottom right (grid[m-1][n-1]) having constraints that from each cell
*      you can either move only to right or down.
*
*       Ex : Input : row : 2
*                    col : 3
*
*           OutPut : Possible Paths : 3
*/
import java.util.Scanner;

public class Recursion_23_Array_Possible_Paths
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions of 2D Array :");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Possible Paths : " + recPossiblePath(m,n,0,0));
    }
    static int recPossiblePath(int m,int n,int i,int j)
    {
        // Base Case
        if (i == m-1 && j == n-1)return 1;
        if (i >= m || j >= n)return 0;

        // Recursive Work
        return recPossiblePath(m,n,i+1,j) + recPossiblePath(m,n,i,j+1);
    }
}