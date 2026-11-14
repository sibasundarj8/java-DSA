package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1
 *
 * # Max Equal Sum in 3 Stacks
 *
 *   Q. Given three stacks s1, s2, and s3, represented by arrays where the first element of each array represents
 *      the top of the corresponding stack.
 *
 *      Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more
 *      elements from the top of each stack.
 *
 *      If it is not possible to make the sum of all three stacks equal, return 0.
 *
 *    Ex.
 *      Input : s1 = [3, 2, 1, 1, 1],
 *              s2 = [4, 3, 2],
 *              s3 = [2, 5, 4, 1]
 *      Output: 5
 *      Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal
 *                   to 5.
 *
 *  Constraints:
 *        ◦ 1 ≤ s1.size(), s2.size(), s3.size() ≤ 5 * 10⁵
 *        ◦ 1 ≤ s1[i], s2[i], s3[i] ≤ 10³
 */

import java.util.ArrayList;
import java.util.Arrays;

public class POTD_Max_Equal_Sum_in_3_Stacks {

    /// main Method
    public static void main(String[] args) {
        ArrayList<Integer> s1 = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1));
        ArrayList<Integer> s2 = new ArrayList<>(Arrays.asList(4, 3, 2));
        ArrayList<Integer> s3 = new ArrayList<>(Arrays.asList(2, 5, 4, 1));

        System.out.print("output: ");
        System.out.println(maxEqualSum(s1, s2, s3));

        System.out.print("expected: 5");
    }

    /// Solution
    static int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        // potd.code.hub
        int sum1, sum2, sum3;
        sum1 = sum2 = sum3 = 0;

        for (int ele : s1) sum1 += ele;
        for (int ele : s2) sum2 += ele;
        for (int ele : s3) sum3 += ele;

        int i, j, k;
        i = j = k = 0;

        while (true) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j++);
            } else {
                sum3 -= s3.get(k++);
            }
        }
    }
}
