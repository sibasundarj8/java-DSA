/*
 *   Q. Given two sorted arrays of distinct integers arr1 and arr2. Each array may have some elements
 *      in common with the other array. Find the maximum sum of a path from the beginning of any array
 *      to the end of any array. You can switch from one array to another array only at the common
 *      elements.
 *    Note: When we switch from one array to other, we need to consider the common element only once
 *          in the result.
 *    Ex :
 *         Input: arr1 = [2, 3, 7, 10, 12] ,
 *                arr2 = [1, 5, 7, 8]
 *         Output: 35
 *         Explanation: The path will be 1+5+7+10+12 = 35, where 1 and 5 come from arr2 and then 7 is
 *                      common so we switch to arr1 and add 10 and 12.
 */
package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POTD_Max_sum_path_in_two_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();
        List<Integer>arr1 = new ArrayList<>();
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr1.add(sc.nextInt());

        System.out.println("Size :");
        int m = sc.nextInt();
        List<Integer>arr2 = new ArrayList<>();
        System.out.println("Elements :");
        for (int i = 0;i < m;i++)
            arr2.add(sc.nextInt());

        System.out.println("Output :");
        System.out.println(maxPathSum(arr1,arr2,n,m));
    }
    static int maxPathSum(List<Integer>arr1, List<Integer>arr2,int n, int m) {
        // potd.code.hub
        int sum1 = 0,sum2 = 0;
        int i = 0,j = 0;
        int ans = 0;

        while (i < n && j < m){
            if (arr1.get(i).equals(arr2.get(j))){
                ans += Math.max(sum1,sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
            else if (arr1.get(i) > arr2.get(j))
                sum2 += arr2.get((j++));
            else sum1 += arr1.get(i++);
        }

        while(i < n)
            sum1 += arr1.get(i++);

        while (j < m)
            sum2 += arr2.get(j++);

        ans += Math.max(sum1,sum2);

        return ans;
    }
}