package Matrix;/*
 *
 * https://www.geeksforgeeks.org/problems/find-rectangle-with-corners-as-1--141631/1
 *
 * # Find rectangle with corners as 1
 *
 *   Q. Given an n x m binary matrix mat[][] containing only 0s and 1s, determine if there exists a rectangle
 *      within the matrix such that all four corners of the rectangle are 1. If such a rectangle exists, return true; otherwise, return false.
 *    Ex.
 *      Input : mat[][] = [[1, 0, 0, 1, 0],
 *                         [0, 0, 1, 0, 1],
 *                         [0, 0, 0, 1, 0],
 *                         [1, 0, 1, 0, 1]]
 *      Output: true
 *      Explanation: Valid corners are at index (1,2), (1,4), (3,2), (3,4)
 */
import java.util.Scanner;

public class Matrix_Find_rectangle_with_corners_as_1 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensions of binary array: ");
        int r = sc.nextByte();
        int c = sc.nextByte();

        int[][] mat = new int[r][c];

        System.out.println("Enter elements: ");
        for (int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                mat[i][j] = sc.nextByte();
            }
        }

        System.out.println("Present rectangle: " + ValidCorner(mat));
    }

    /// Solution
    static boolean ValidCorner(int[][] mat) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                
                if (mat[i][j] == 1){
                    for (int x = j+1;x < m;x++){
                        
                        if (mat[i][x] == 1) {
                            for (int y = i+1;y < n;y++){
                                
                                if (mat[y][j] == 1 && mat[y][x] == 1){
                                    return true;
                                }
                                
                            }
                        }
                        
                    }
                }
                
            }
        }
        
        return false;
    }
}
