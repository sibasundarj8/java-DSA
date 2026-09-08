package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-string-in-grid0111/1
 *
 * # Word in Grid - All Occurrences
 *
 *   Q. Given a 2D grid mat[][] of size n × m consisting of characters and a string word, find all starting positions
 *      where the word occurs in the grid.
 *
 *        ◦ The word can be formed from any cell by moving in any of the 8 directions (2 horizontal, 2 vertical, and
 *          4 diagonal) in a straight line without changing direction.
 *        ◦ Each cell can be used at most once per occurrence.
 *        ◦ Return all unique starting coordinates in lexicographically the smallest order.
 *
 *    Ex.
 *      Input : mat[][] = {{a, b, a, b},
 *                         {a, b, e, b},
 *                         {e, b, e, b}},
 *              word = "abe"
 *      Output: {{0, 0},
 *               {0, 2},
 *               {1, 0}}
 *      Explanation: From (0,0) we can find "abe" in right-down diagonal. From (0,2) we can find "abe" in left-down
 *                   diagonal. From (1,0) we can find "abe" in horizontally right direction.
 *
 *  Constraints:
 *        1 <= n <= m <= 50
 *        1 <= |word| <= 20
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POTD_Word_in_Grid_All_Occurrences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] mat = new char[n][m];

        System.out.println("enter the elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }
        sc.nextLine();

        System.out.println("enter the word: ");
        String word = sc.next();

        System.out.println("all unique starting coordinates: ");
        ArrayList<ArrayList<Integer>> coordinates = searchWord(mat, word);

        for (ArrayList<Integer> coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    /// Solution
    static ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        // potd.code.hub
        int n = mat.length;
        int m = mat[0].length;

        char[] s = word.toCharArray();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPossible(i, j, mat, s)) {
                    result.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }

        return result;
    }

    private final static int[] D_ROW = {0, -1, -1, -1, 0, 1, 1, 1};
    private final static int[] D_COL = {-1, -1, 0, 1, 1, 1, 0, -1};

    private static boolean isPossible(int i, int j, char[][] mat, char[] s) {
        if (mat[i][j] != s[0]) return false;

        int n = mat.length;
        int m = mat[0].length;
        int len = s.length;
        int r, c, k;

        for (int dir = 0; dir < 8; dir++) {
            r = i;
            c = j;

            for (k = 1; k < len; k++) {
                r += D_ROW[dir];
                c += D_COL[dir];

                if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] != s[k]) {
                    break;
                }
            }

            if (k == len) return true;
        }

        return false;
    }
}
