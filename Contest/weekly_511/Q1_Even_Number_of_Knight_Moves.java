package Contest.weekly_511;/*
 *
 * https://leetcode.com/contest/weekly-contest-511/problems/even-number-of-knight-moves/
 *
 * # Q1. Even Number of Knight Moves
 *
 *   Q. You are given two integer arrays start and target, where each array is of the form [x, y] representing a cell on
 *      a standard 8 x 8 chessboard.
 *
 *      Return true if a knight can move from start to target in an even number of moves. Otherwise, return false.
 *
 *      Note: A valid knight move consists of moving two squares in one direction and one square perpendicular to it.
 *            The figure below illustrates all eight possible moves from a cell.
 *
 *    Ex.
 *      Input : start = [1,1], target = [2,2]
 *      Output: true
 *      Explanation:
 *              One possible sequence of moves is (1, 1) -> (3, 2) -> (2, 4) -> (4, 3) -> (2, 2).
 *              The knight reaches the target in 4 moves, which is even. Thus, the answer is true.
 *
 *  Constraints:
 *       start.length == target.length == 2
 *       0 <= start[i], target[i] <= 7
 */

public class Q1_Even_Number_of_Knight_Moves {

    /// Solution
    public boolean canReach(int[] start, int[] target) {
        // if both knights are in same color then it will take even number of steps.
        return ((start[0] + start[1]) & 1) == ((target[0] + target[1]) & 1);
    }
}
