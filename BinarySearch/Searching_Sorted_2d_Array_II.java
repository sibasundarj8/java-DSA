package Binary_Search;/*
 *  Q. Write an efficient algorithm that searches for a value target in an m x n integer arr matrix.
 *     This matrix has the following properties :
 *      ● Integers in each row are sorted in ascending from left to right.
 *      ● Integers in each column are sorted in ascending from top to bottom.
 *    Ex.
 *      Input: matrix = [[1, 4, 7, 11,15],
 *                       [2, 5, 8, 12,19],
 *                       [3, 6, 9, 16,22],
 *                       [10,13,14,17,24],
 *                       [18,21,23,26,30]]
 *             target = 5
 *      Output: {1, 1}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Searching_Sorted_2d_Array_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][]arr = new int[r][c];

        System.out.println("Elements are must be sorted,\nit must be in column wise also\nElements :");
        for (int i = 0;i < r;i++)
            for (int j = 0;j < c;j++)
                arr[i][j] = sc.nextInt();

        System.out.println("Enter target :");
        int x = sc.nextInt();

        System.out.println("Output : "+ find(arr,r,c,x));
    }
    static ArrayList<Integer>find(int[][]arr,int r,int c,int target){
        int i = 0;
        int j = c-1;
        ArrayList<Integer>ans = new ArrayList<>();
        while (i < r && j >= 0){
            if (arr[i][j] == target){
                ans.add(i);
                ans.add(j);
                return ans;
            }
            else if (target < arr[i][j])j--;
            else i++;
        }
        ans.add(-1);
        return ans;
    }
}