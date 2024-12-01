package GFG;/*
 *    Q. Given a binary matrix mat of size n * m, find out the maximum length
 *       of a side of a square sub-matrix with all 1s.
 *    Ex.
 *       Input: n = 6, m = 5
 *              mat = [[0, 1, 1, 0, 1],
 *                     [1, 1, 0, 1, 0],
 *                     [0, 1, 1, 1, 0],
 *                     [1, 1, 1, 1, 0],
 *                     [1, 1, 1, 1, 1],
 *                     [0, 0, 0, 0, 0]]
 *              Output: 3
 *     Explanation :
 *         The maximum length of a side of the square sub-matrix is 3 where every element is 1.
 */
import java.util.Scanner;

public class POTD_Largest_square_formed_in_a_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Row and Column");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][]arr = new int[r][c];
        System.out.println("Elements :");
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSquire(arr,r,c));
    }
    static int maxSquire(int[][]arr,int r,int c){
        int max = 0;
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                if (i != 0 && j != 0 && arr[i][j] != 0){
                    arr[i][j] += Math.min(arr[i-1][j-1],Math.min(arr[i][j-1],arr[i-1][j]));
                }
                max = Math.max(max,arr[i][j]);
            }
        }
        return max;
    }
}