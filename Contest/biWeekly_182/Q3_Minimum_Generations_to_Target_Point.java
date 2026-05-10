package Contest.biWeekly_182;/*
 *
 * https://leetcode.com/contest/biweekly-contest-182/problems/minimum-generations-to-target-point/
 *
 * # Q3. Minimum Generations to Target Point
 *
 *   Q. You are given a 2D integer array points where points[i] = [xi, yi, zi] represents a point in 3D space, and an integer
 *      array target representing a target point.
 *
 *      Define generation 0 as the initial list of points. For each integer k >= 1, form generation k as follows:
 *        ◦ Consider every pair of two distinct points a = [x1, y1, z1] and b = [x2, y2, z2] taken from all points produced
 *          in generations 0 through k - 1.
 *        ◦ For each such pair, compute c = [floor((x1 + x2) / 2), floor((y1 + y2) / 2), floor((z1 + z2) / 2)] and collect
 *          every such c into a generation k.
 *        ◦ All points in the generation k are produced simultaneously from points in generations 0 through k - 1.
 *        ◦ After generation k is formed, the points in the generation k are considered available for forming later generations.
 *
 *      Return the smallest integer k such that the target appears in one of the generations 0 through k. If the target is
 *      already in the initial points, return 0. If it is impossible to obtain the target, return -1.
 *
 *      Notes:
 *        ◦ floor denotes rounding down to the nearest integer.
 *        ◦ "Two distinct points" means the two chosen points must have different (x, y, z) coordinates. A point cannot be
 *          paired with itself, and pairing two points with identical coordinates is not possible.
 *
 *    Ex.
 *      Input : points = [[0,0,0],[5,5,5]], target = [1,1,1]
 *      Output: 2
 *      Explanation:
 *              Generation 0: The initial points = [[0, 0, 0], [5, 5, 5]].
 *
 *              The target = [1, 1, 1] does not exist in generation 0.
 *
 *              Generation 1: For each pair of points in generation 0, we create new points.
 *                ◦ Using [0, 0, 0] and [5, 5, 5], we generate [2, 2, 2].
 *
 *              After generation 1, points = [[0, 0, 0], [5, 5, 5], [2, 2, 2]].
 *
 *              Generation 2: For each pair of points available after generation 1, we create new points.
 *                ◦ Using [0, 0, 0] and [5, 5, 5], we generate [2, 2, 2].
 *                ◦ Using [0, 0, 0] and [2, 2, 2], we generate [1, 1, 1].
 *                ◦ Using [5, 5, 5] and [2, 2, 2], we generate [3, 3, 3].
 *
 *              After generation 2, points = [[0, 0, 0], [5, 5, 5], [2, 2, 2], [1, 1, 1], [3, 3, 3]].
 *
 *              The target = [1, 1, 1] is found in generation 2, so the smallest k is 2.
 *
 *  Constraints:
 *        ◦ 1 <= points.length <= 20
 *        ◦ points[i] = [xi, yi, zi]
 *        ◦ 0 <= xi, yi, zi <= 6
 *        ◦ target.length == 3
 *        ◦ 0 <= target[i] <= 6
 *        ◦ The initial set of points contains no duplicates.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q3_Minimum_Generations_to_Target_Point {

    /// Solution
    public int minGenerations(int[][] points, int[] target) {
        List<int[]> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int step = 0;
        String targetCode = target[0] + "_" + target[1] + "_" + target[2];

        for (int[] point : points) {
            String hash = point[0] + "_" + point[1] + "_" + point[2];
            if (hash.equals(targetCode)) return 0;
            list.add(point);
            set.add(hash);
        }

        while (true) {
            List<int[]> newList = new ArrayList<>();
            int len = list.size();
            step++;

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int[] newPoint = generatePoint(list.get(i), list.get(j));
                    String hash = newPoint[0] + "_" + newPoint[1] + "_" + newPoint[2];

                    if (hash.equals(targetCode)) return step;

                    if (!set.contains(hash)) {
                        newList.add(newPoint);
                        set.add(hash);
                    }
                }
            }

            if (newList.isEmpty()) return -1;
            list.addAll(newList);
        }
    }

    private int[] generatePoint(int[] p1, int[] p2) {
        return new int[]{(p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2, (p1[2] + p2[2]) / 2};
    }
}
