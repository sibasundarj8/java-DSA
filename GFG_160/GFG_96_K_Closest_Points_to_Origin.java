package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/k-closest-points-to-origin--172242/1
 *
 * # K Closest Points to Origin
 *
 *   Q. Given an array of points where each point is represented as points[i] = [xi, yi] on the
 *      X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 *      The distance between two points on the X-Y plane is the Euclidean distance, defined as:
 *
 *      sqrt( (x2 - x1)2 + (y2 - y1)2 )
 *
 *      Note: You can return the k closest points in any order, driver code will sort them before
 *            printing.
 *    Ex.
 *      Input : k = 2
 *              points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
 *      Output: [[-2, 2], [0, 1]]
 *      Explanation: The Euclidean distances from the origin are:
 *                   Point (1, 3) = sqrt(10)
 *                   Point (-2, 2) = sqrt(8)
 *                   Point (5, 8) = sqrt(89)
 *                   Point (0, 1) = sqrt(1)
 *                   The two closest points to the origin are [-2, 2] and [0, 1].
 */
import java.util.*;

public class GFG_96_K_Closest_Points_to_Origin {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("k:");
        int k = sc.nextInt();

        System.out.println("Number of points: ");
        int n = sc.nextInt();

        int[][] points = new int[n][2];

        System.out.println("Enter Graphical coordinates: ");
        for (int i = 0;i < n;i++){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    /// Solution
    static int[][] kClosest(int[][] points, int k) {
        // potd.code.hub
        PriorityQueue<int[]> q = new PriorityQueue<>(k+1, (x, y) -> dist(y) - dist(x));
        int[][]ans = new int[k][];
        for (int[] p : points){
            if (q.size() < k) q.offer(p);
            else if (dist(p) < dist(q.peek())){
                q.poll();
                q.offer(p);
            }
        }
        for (int i = 0;i < k;i++) ans[i] = q.poll();

        return ans;
    }
    private static int dist(int[]p){
        int x = p[0];
        int y = p[1];
        return (int) x*x + y*y;
    }
}
