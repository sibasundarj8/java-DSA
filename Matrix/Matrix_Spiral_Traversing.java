package Matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix_Spiral_Traversing {
    static ArrayList<Integer>spiralTraverse(int[][]matrix) {
        // potd.code.hub
        int r = matrix.length;
        int c = matrix[0].length;
        int lc = 0;     // Left Col
        int tr = 0;     // Top Row
        int rc = c-1;   // Right Col
        int br = r-1;   // Bottom Row
        int te = r*c;   // Total Element
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0;i < te;i++){
            for (int j = lc;j <= rc;j++)
                ans.add(matrix[tr][j]);
            tr++;
            for (int j = tr;j <= br;j++)
                ans.add(matrix[j][rc]);
            rc--;
            if (tr <= br)
                for (int j = rc;j >= lc;j--)
                    ans.add(matrix[br][j]);
            br--;
            if (lc <= rc)
                for (int j = br;j >= tr;j--)
                    ans.add(matrix[j][lc]);
            lc++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions :");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Elements :");
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Spiral Traversing of the Matrix is :");
        System.out.println(spiralTraverse(arr));
    }
}