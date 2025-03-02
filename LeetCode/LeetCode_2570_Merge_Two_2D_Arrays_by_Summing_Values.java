package LeetCode;/*
 *
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
 *
 * #2570. Merge Two 2D Arrays by Summing Values
 *
 *   Q. You are given two 2D integer arrays nums1 and nums2.
 *
 *        • Nums1[i] = [id, val] indicates that the number with the id has a value equal to val.
 *        • Nums2[i] = [id, val] indicates that the number with the id has a value equal to val.
 *
 *      Each array contains unique ids and is sorted in ascending order by id.
 *
 *      Merge the two arrays into one array that is sorted in ascending order by id, respecting the
 *      following conditions:
 *
 *        • Only ids that appear in at least one of the two arrays should be included in the resulting
 *          array.
 *
 *        • Each id should be included only once, and its value should be the sum of the values of this
 *          id in the two arrays. If the id does not exist in one of the two arrays, then assume its value
 *          in that array to be 0.
 *
 *      Return the resulting array. The returned array must be sorted in ascending order by id.
 *
 *      Ex:
 *          Input : nums1 = [[1,2],[2,3],[4,5]]
 *                  nums2 = [[1,4],[3,2],[4,1]]
 *          Output: [[1,6],[2,3],[3,2],[4,6]]
 *          Explanation: The resulting array contains the following:
 *                  - id = 1, the value of this id is 2 + 4 = 6.
 *                  - id = 2, the value of this id is 3.
 *                  - id = 3, the value of this id is 2.
 *                  - id = 4, the value of this id is 5 + 1 = 6.
 */
import java.util.ArrayList;

public class LeetCode_2570_Merge_Two_2D_Arrays_by_Summing_Values {

    /// main Method
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};

        for (int[]i : mergeArrays(nums1, nums2)){
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n && j < m){
            if(nums1[i][0] < nums2[j][0])
                list.add(new int[]{nums1[i][0], nums1[i++][1]});
            else if(nums1[i][0] > nums2[j][0])
                list.add(new int[]{nums2[j][0], nums2[j++][1]});
            else
                list.add(new int[]{nums1[i][0], nums1[i++][1] + nums2[j++][1]});
        }
        while (i < n) list.add(new int[]{nums1[i][0], nums1[i++][1]});
        while (j < m) list.add(new int[]{nums1[j][0], nums1[j++][1]});

        return list.toArray(new int[list.size()][]);
    }
}
