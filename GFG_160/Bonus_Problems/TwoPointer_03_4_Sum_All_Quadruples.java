package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
 *
 * # 4 Sum - All Quadruples
 * 
 *   Q. Given an array arr[] of integers and another integer target. Find all unique quadruples from
 *      the given array that sums up to target.
 *
 *      Note: All the quadruples should be internally sorted, ie for any quadruple [q1, q2, q3, q4]
 *            it should be : q1 <= q2 <= q3 <= q4.
 *    Ex.
 *      Input : arr[] = [10, 2, 3, 4, 5, 7, 8]
 *              target = 23
 *      Output: [[2, 3, 8, 10],
 *               [2, 4, 7, 10],
 *               [3, 5, 7, 8]]
 *      Explanation: Sum of 2, 3, 8, 10 is 23,
 *                   sum of 2, 4, 7, 10 is 23 and
 *                   sum of 3, 5, 7, 8 is also 23.
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointer_03_4_Sum_All_Quadruples {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        for (List<Integer> list : fourSum(arr, target)){
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    /// Solution
    static List<List<Integer>> fourSum(int[] arr, int target) {
        // potd.code.hub
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0;i < n-3;i++){
            if (i > 0 && arr[i] == arr[i-1])continue;
            for (int j = i+1;j < n-2;j++){
                if (j > i+1 && arr[j] == arr[j-1]) continue;
                int l = j+1, r = n-1;
                while (l < r){
                    int total = arr[i] + arr[j] + arr[l] + arr[r];
                    if (total == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[l++], arr[r--]));
                        while (l < r && arr[l] == arr[l-1]) l++;
                        while (l < r && arr[r] == arr[r+1]) r--;
                    }
                    else if (total < target) l++;
                    else r--;
                }
            }
        }

        return ans;
    }
}
