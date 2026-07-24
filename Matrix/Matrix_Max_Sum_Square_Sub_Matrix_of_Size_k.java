package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/coins-of-geekland--141631/1
 *
 * # Max Sum Square Sub-Matrix of Size k
 *
 *   Q. Given an n × n grid mat[][] of integers where values can be negative, find the maximum sum among all possible
 *      k × k sub-grids.
 *
 *    Ex.
 *      Input : k = 3,
 *              mat[][] = [[ 1,  2, -1,  4],
 *                         [-8, -3,  4,  2],
 *                         [ 3,  8, 10, -8],
 *                         [-4, -1,  1,  7]]
 *      Output: 20
 *      Explanation:
 *              The 3 × 3 sub-grid  [[-3,  4,  2]   highlighted in red has the maximum sum of 20.
 *                                   [ 8, 10, -8],
 *                                   [-1,  1,  7]]
 *
 *  Constraints:
 *        ◦ 1 ≤ n ≤ 1000
 *        ◦ 1 ≤ k ≤ n
 *        ◦ -1000 ≤ mat[i][j] ≤ 1000
 */


import java.io.*;
import java.util.StringTokenizer;

public class Matrix_Max_Sum_Square_Sub_Matrix_of_Size_k {

    /// main Method
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        bw.write("Enter the size of square matrix:\n");
        bw.flush();

        int n = Integer.parseInt(br.readLine().trim());

        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Matrix size must lie between 1 and 1000");
        }

        int[][] mat = new int[n][n];

        bw.write("Enter array elements:\n");
        bw.flush();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write("Enter sub-grid size k:\n");
        bw.flush();

        int k = Integer.parseInt(br.readLine().trim());
        bw.write("Maximum square sum of size k: " + maximumSum(mat, k) + "\n");

        bw.flush();
    }

    /// Solution
/*
-------------------------------------------------------prefix-sum-------------------------------------------------------
TC : O(n²)
SC : O(n²)
*/
    static int approach_1(int[][] mat, int k) {
        // potd.code.hub
        int n = mat.length;
        int[][] temp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
              
                if (i >= k) temp[i - k][j] -= mat[i][j];
              
                temp[i][j] += mat[i][j];
              
                if ((i < n - 1)) temp[i][j] += temp[i + 1][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
          
            int sum = 0;
            for (int j = 0; j < n; j++) {
              
                sum += temp[i][j];
                if (j >= k) sum -= temp[i][j - k];
                if (j >= k - 1) max = Math.max(sum, max);
            }
        }

        return max;
    }
    
/*
-----------------------------------------------------space-optimized-----------------------------------------------------
TC : O(n²)
SC : O(n)
*/
    static int maximumSum(int[][] mat, int k) {
        // potd.code.hub
        int n = mat.length;
        int max = Integer.MIN_VALUE;
        int[] row = new int[n];

        for (int i = 0; i < n; i++) {
          
            int sum = 0;
            for (int j = 0; j < n; j++) {
              
                row[j] += mat[i][j];
                if (i >= k) row[j] -= mat[i - k][j];
              
                sum += row[j];
                if (j >= k) sum -= row[j - k];
                if (i >= k - 1 && j >= k - 1) max = Math.max(sum, max);
            }
        }

        return max;
    }
}
