package Recursion;/*
 *
 * # The Knight's tour problem
 *
 *   Q. You are given an integer n, there is an n × n chessboard with a Knight starting in the top-left
 *      corner (0, 0). Your task is to determine a valid Knight's Tour, where the Knight visits every
 *      square exactly once, following the standard movement rules of a chess Knight (two steps in one
 *      direction and one step perpendicular), for example if a Knight is placed at cell (2, 2), in one
 *      move it can move to any of the following cells: (4, 3), (4, 1), (0, 3), (0, 1), (3, 4), (3, 0),
 *      (1, 4) and (1, 0).
 *
 *      You have to return the order in which each cell is visited. If a solution exists, return the
 *      sequence of numbers (starting from 0) representing the order of visited squares. If no solution
 *      is possible, return an empty list.
 *
 *      Note: You can return any valid ordering, if it is correct the driver code will print true else it
 *            will print false.
 *   Ex.
 *      Input : n = 5
 *      Output: true
 *      Explanation: A possible Knight's Tour in a 5x5 chessboard is given below where Each number
 *                   represents the step at which the Knight visits that cell, starting from (0, 0)
 *                   as step 0.
 *                              [[0, 11, 2, 17, 20],    |   [[0,  15, 10, 19,  2],
 *                               [3, 16, 19, 12, 7],    |    [9,  20, 1,  16, 11],
 *                               [10, 1, 6, 21, 18],    |    [14, 23, 18,  3,  6],
 *                               [15, 4, 23, 8, 13],    |    [21, 8,   5, 12, 17],
 *                               [24, 9, 14, 5, 22]]    |    [24, 13, 22,  7,  4]]
 *  Constraints:
 *       1 ≤ n ≤ 6
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_59_The_Knights_tour_problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of chess board: ");
        int n = sc.nextInt();

        // answer
        ArrayList<ArrayList<Integer>> ans = knightTour(n);

        System.out.println("Order of visited squares by knight: ");
        for (ArrayList<Integer> list : ans)
            System.out.println(list);
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> knightTour(int n) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] di = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dj = {-1, 1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < n; i++) temp.add(null);
        for (int i = 0; i < n; i++) ans.add(new ArrayList<>(temp));
        ans.getFirst().set(0, 0);

        return getOrder(0, 0, 0, n, di, dj, ans) ? ans : new ArrayList<>();
    }

    private static boolean getOrder(int i, int j, int step, int n, int[] di, int[] dj, ArrayList<ArrayList<Integer>> ans) {
        // base case
        if (step == n * n - 1) return true;

        // self work
        for (int x = 0; x < 8; x++) {
            int ni = i + di[x];
            int nj = j + dj[x];
            
            if (0 <= ni && ni < n && 0 <= nj && nj < n && ans.get(ni).get(nj) == null) {
                // use
                ans.get(ni).set(nj, step + 1);
                
                // recursive case
                if (getOrder(ni, nj, step + 1, n, di, dj, ans)) return true;
                
                // backtrack
                ans.get(ni).set(nj, null);
            }
        }

        return false;
    }
}
