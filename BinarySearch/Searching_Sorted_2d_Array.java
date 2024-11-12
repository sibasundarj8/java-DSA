package Binary_Search;/*
 *   Q. You are given an m x n integer matrix arr with the following two properties:
 *      ● Each row is sorted in non-decreasing order.
 *      ● The first integer of each row is greater than the last integer of the previous row.
 *      ● Given an integer target, return true if target is in matrix or false otherwise.
 *      You must write a solution in O(log(m * n)) time complexity.
 *    Ex.
 *      Input :
 *              Row = 3
 *              Col = 4
 *              Elements : 1  3  5  7
 *                         10 11 16 20
 *                         23 30 34 60
 *              Target : 30
 *      Output :
 *              {2,1}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Searching_Sorted_2d_Array {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]arr = new int[r][c];

        System.out.println("Elements are must be sorted,\nFirst element of row must be\n greater then last element of\n previous row.\nElements :");
        for (int i = 0;i < r;i++)
            for (int j = 0;j < c;j++)
                arr[i][j] = sc.nextInt();

        System.out.println("Enter Target :");
        int x = sc.nextInt();

        System.out.println(find(arr,x));
    }
    static ArrayList<Integer>find(int[][]arr,int target){
        ArrayList<Integer>ans = new ArrayList<>();
        int row = arr.length;
        int col = arr[0].length;
        int start = 0;
        int end = row*col - 1;
        while (start <= end){
            int mid = start + (end-start)/2;
            int midEle = arr[mid/col][mid%col];
            if (midEle == target){
                ans.add(mid/col);
                ans.add(mid%col);
                return ans;
            }
            else if (target < midEle)
                end = mid-1;
            else start = mid+1;
        }
        ans.add(-1);
        return ans;
    }
}