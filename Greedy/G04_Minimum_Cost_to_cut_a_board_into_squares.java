package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1
 *
 * # Minimum Cost to cut a board into squares
 *
 *   Q. Given a board of dimensions n × m that needs to be cut into n*m squares. The cost of making a cut along
 *      a horizontal or vertical edge is provided in two arrays:
 *
 *      x[]: Cutting costs along the vertical edges (length-wise).
 *      y[]: Cutting costs along the horizontal edges (width-wise).
 *
 *      Find the minimum total cost required to cut the board into squares optimally.
 *   Ex.
 *      Input : n = 4
 *              m = 6
 *              x[] = [2, 1, 3, 1, 4]
 *              y[] = [4, 1, 2]
 *                                          [Y]     2   1   3   1   4   ←-[X]
 *                                           ↓  +---+---+---+---+---+---+
 *                                              |   |   |   |   |   |   |
 *                                           4  +---+---+---+---+---+---+
 *                                              |   |   |   |   |   |   |
 *                                           1  +---+---+---+---+---+---+
 *                                              |   |   |   |   |   |   |
 *                                           2  +---+---+---+---+---+---+
 *                                              |   |   |   |   |   |   |
 *                                              +---+---+---+---+---+---+
 *      Output: 42
 *      Explanation:
 *          For above board optimal way to cut into square is:
 *          1. Pick 4 (from x) -> vertical cut, Cost = 4 × horizontal segments = 4,
 *             Vertical segments = 2, Total = 4.
 *          2. Pick 4 (from y) -> horizontal cut, Cost = 4 × vertical segments = 8,
 *             Horizontal segments = 2, Total = 12.
 *          3. Pick 3 (from x) -> vertical cut, Cost = 3 × horizontal segments = 6,
 *             Vertical segments = 3, Total = 18.
 *          4. Pick 2 (from x) -> vertical cut, Cost = 2 × horizontal segments = 4,
 *             Vertical segments = 4, Total = 22.
 *          5. Pick 2 (from y) -> horizontal cut, Cost = 2 × vertical segments = 8,
 *             Horizontal segments = 3, Total = 30.
 *          6. Pick 1 (from x) -> vertical cut, Cost = 1 × horizontal segments = 3,
 *             Vertical segments = 5, Total = 33.
 *          7. Pick 1 (from x) -> vertical cut, Cost = 1 × horizontal segments = 3,
 *             Vertical segments = 6, Total = 36.
 *          8. Pick 1 (from y) -> horizontal cut, Cost = 1 × vertical segments = 6,
 *             Horizontal segments = 4, Total = 42.
 *
 *    Constraints:
 *          2 ≤ n, m ≤ 10³
 *          1 ≤ x[i], y[j] ≤10³
 */

import java.util.Arrays;
import java.util.Scanner;

public class G04_Minimum_Cost_to_cut_a_board_into_squares {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of the box: (row ⨉ col)");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] x = new int[m - 1];
        int[] y = new int[n - 1];

        System.out.println("Cutting costs along the vertical edges (length-wise)");
        System.out.print("x[] = ");
        for (int i = 0; i < m - 1; i++) x[i] = sc.nextInt();

        System.out.println("Cutting costs along the horizontal edges (width-wise)");
        System.out.print("y[] = ");
        for (int i = 0; i < n - 1; i++) y[i] = sc.nextInt();

        System.out.println("Minimum cost: " + minCost(n, m, x, y));
    }

    /// Solution
    static int minCost(int n, int m, int[] x, int[] y) {
        
        int cost = 0;               // used to count the cost.
        int verticalSegment = 1;    // used to count the number of vertical segments till now.    
        int horizontalSegment = 1;  // used to count the number of horizontal segments till now.
        
        int xIdx = m - 2;           // used to track the x[] elements.
        int yIdx = n - 2;           // used to track the y[] elements.
        
        // sort the arrays to get larger elements at last.
        Arrays.sort(x);
        Arrays.sort(y);
        
        // two pointer approach
        while (xIdx >= 0 || yIdx >= 0) {
            if (yIdx == -1 || (xIdx >= 0 && x[xIdx] > y[yIdx])) {
                cost += x[xIdx--] * horizontalSegment;
                verticalSegment++;
            } else {
                cost += y[yIdx--] * verticalSegment;
                horizontalSegment++;
            }
        }

        return cost;
    }
}
