package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * # LC. 628. Maximum Product of Three Numbers
 *
 *   Q. Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3, 4]
 *      Output: 24
 *
 *  Constraints:
 *        ◦ 3 <= nums.length <= 10⁴
 *        ◦ -1000 <= nums[i] <= 1000
 */

import java.io.*;
import java.util.StringTokenizer;

public class LeetCode_628_Maximum_Product_of_Three_Numbers {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        bw.write("Enter the elements of array: \n");
        bw.flush();
        st = new StringTokenizer(br.readLine());

        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write("Maximum triplet product: \n");
        bw.write(String.valueOf(maximumProduct(arr)));
        bw.flush();
    }

    /// Solution
    static int maximumProduct(int[] nums) {
        int max_1 = Integer.MIN_VALUE;
        int max_2 = Integer.MIN_VALUE;
        int max_3 = Integer.MIN_VALUE;
        int min_1 = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;

        for (int ele : nums) {
            if (ele > max_3) {
                if (ele > max_1) {
                    max_3 = max_2;
                    max_2 = max_1;
                    max_1 = ele;
                } else if (ele > max_2) {
                    max_3 = max_2;
                    max_2 = ele;
                } else {
                    max_3 = ele;
                }
            }

            if (ele < min_2) {
                if (ele < min_1) {
                    min_2 = min_1;
                    min_1 = ele;
                } else {
                    min_2 = ele;
                }
            }
        }

        int product_1 = max_1 * max_2 * max_3;
        int product_2 = min_1 * min_2 * max_1;

        return Math.max(product_1, product_2);
    }
}
