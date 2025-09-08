package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/assign-mice-holes3053/1
 *
 * # Assign Mice Holes
 *
 *   Q. You are given two arrays mices[] and holes[] of the same size. The array mices[] represents the positions
 *      of the mice on a straight line, while the array holes[] represents the positions of the holes on the same
 *      line. Each hole can accommodate exactly one mouse. A mouse can either stay in its current position, move
 *      one step to the right, or move one step to the left, and each move takes one minute. The task is to assign
 *      each mouse to a distinct hole in such a way that the time taken by the last mouse to reach its hole is
 *      minimized.
 *    Ex.
 *      Input : mices[] = [4, -4, 2]
 *              holes[] = [4, 0, 5]
 *      Output: 4
 *      Explanation: Assign the mouse at position 4 to the hole at position 4, so the time taken is 0 minutes.
 *                   Assign the mouse at position −4 to the hole at position 0, so the time taken is 4 minutes.
 *                   Assign the mouse at position 2 to the hole at position 5, so the time taken is 3 minutes.
 *                   Hence, the maximum time required by any mouse is 4 minutes.
 *   Constraints:
 *       1 ≤ mices.size() = holes.size() ≤ 10⁵
 *      -10⁵ ≤ mices[i] , holes[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class G02_Assign_Mice_Holes {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter position of mices: ");
        String[] m = sc.nextLine().split(" ");

        System.out.println("Enter position of holes: ");
        String[] h = sc.nextLine().split(" ");

        int n = m.length;
        if (n != h.length) {
            System.err.println("equal number of mices and holes are required.");
            return;
        }

        int[] mices = Arrays.stream(m)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] holes = Arrays.stream(h)
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Minimum time taken by the last mouse: ");
        System.out.println(assignHole(mices, holes));
    }

    /// Solution
    static int assignHole(int[] mices, int[] holes) {
        // potd.code.hub
        int n = mices.length;
        int ans = 0;

        Arrays.sort(mices);
        Arrays.sort(holes);

        for (int i = 0; i < n; i++)
            ans = Math.max(ans, Math.abs(mices[i] - holes[i]));

        return ans;
    }
}
