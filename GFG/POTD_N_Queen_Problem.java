/*
 *   Q. The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can
 *      attack each other.
 *      Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct
 *      board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3…n] in
 *      increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row
 *      with that number. For e.g., the below figure represents a chessboard [3 1 4 2].
 *    Ex.
 *      Input : Input: 4
 *      Output: [[2 4 1 3 ],
 *               [3 1 4 2 ]]
 *      Explanation: These are the 2 possible solutions.
 */
package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_N_Queen_Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chessboard Size :");
        int n = sc.nextInt();

        System.out.println(nQueen(n));
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // potd.code.hub
        int[][]board = new int[n][n];
        ArrayList<Integer>temp = new ArrayList<>();
        path(board,temp,n,0);
        return ans;
    }
    static ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
    static void path(int[][]board,ArrayList<Integer>temp,int n,int idx){
        // Base Case
        if (idx == n){
            ans.add(temp);
            return;
        }
        for (int c = 0;c < n;c++){
            if (isSafe(board,n,idx,c)){
                board[idx][c] = 1;
                temp.add(c+1);
                path(board,temp,n,idx+1);
                board[idx][c] = 0;
                temp = new ArrayList<>();
            }
        }
    }
    static boolean isSafe(int[][]board,int n,int r,int c) {
        int i,j;
        // E W N S
        for (i = 0;i < n;i++)
            if (board[i][c]==1 || board[r][i]==1)
                return false;
        // NE
        i = r;
        j = c;
        while (i >= 0 && j < n)
            if (board[i--][j++] == 1)return false;
        // SE
        i = r;
        j = c;
        while (i < n && j < n)
            if (board[i++][j++] == 1)return false;
        // SW
        i = r;
        j = c;
        while (i < n && j >= 0)
            if (board[i++][j--] == 1)return false;
        // NW
        i = r;
        j = c;
        while (i >= 0 && j >= 0)
            if (board[i--][j--] == 1)return false;
        return true;
    }
}