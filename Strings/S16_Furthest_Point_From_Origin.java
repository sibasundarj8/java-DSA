package Strings;/*
 *
 * https://leetcode.com/problems/furthest-point-from-origin/
 *
 *   Q. You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your
 *      movement on a number line starting from the origin 0.
 *
 *      In the ith move, you can choose one of the following directions:
 *
 *      move to the left if moves[i] = 'L' or moves[i] = '_'
 *      move to the right if moves[i] = 'R' or moves[i] = '_'
 *      Return the distance from the origin of the furthest point you can get to after n moves.
 *
 *   Ex.
 *      Input : moves = "_R__LL_"
 *      Output: 5
 *      Explanation: The furthest point we can reach from the origin 0 is point -5 through the following sequence
 *                   of moves "LRLLLLL".
 *
 *  Constraints:
 *          1 <= moves.length == n <= 50
 *          moves consists only of characters 'L', 'R' and '_'.
 */

import java.util.Scanner;

public class S16_Furthest_Point_From_Origin {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter directions like('LR_R__L_')");
        String moves = sc.next();

        System.out.println("Distance from the origin of the furthest point after n moves: ");
        System.out.println(furthestDistanceFromOrigin(moves));
    }

    /// Solution
    static int furthestDistanceFromOrigin(String moves) {
        // potd.code.hub
        int n = moves.length();
        int pos = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') pos--;
            else if (moves.charAt(i) == 'R') pos++;
            else count++;
        }

        return Math.abs(pos) + count;
    }
}
