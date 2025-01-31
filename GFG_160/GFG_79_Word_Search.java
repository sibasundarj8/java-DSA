package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/word-search/1
 *
 * # Word Search
 *
 *   Q. You are given a two-dimensional mat[][] of size n*m containing English alphabets and a
 *      string word. Check if the word exists on the mat. The word can be constructed by using
 *      letters from adjacent cells, either horizontally or vertically. The same cell cannot be
 *      used more than once.
 *    Ex.
 *      Input : mat[][] = [['T', 'E', 'E'],
 *                         ['S', 'G', 'K'],
 *                         ['T', 'E', 'L']]
 *              word = "GEEK"
 *      Output: true
 *      Explanation: The letter cells which are used to construct the "GEEK" are colored.
 */
import java.util.Scanner;

public class GFG_79_Word_Search {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dimensions: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][]arr = new char[n][m];

        System.out.println("Characters : must be capital");
        for (int i = 0;i < n;i++)
            for (int j = 0;j < m;j++)
                arr[i][j] = sc.next().charAt(0);

        System.out.println("Word: ");
        String word = sc.next();

        System.out.println(isWordExist(arr, word));
    }

    /// Solution
    static boolean isWordExist(char[][] mat, String word) {
        // potd.ode.hub
        int r = mat.length, c = mat[0].length;
        for (int i = 0;i < r;i++)
            for (int j = 0;j < c;j++)
                if (mat[i][j] == word.charAt(0))
                    if (exists(mat, word, r, c, i, j, 0))
                        return true;
        
        return false;
    }
    private static boolean exists(char[][]arr, String word, int r, int c, int row, int col, int idx){
        // base case
        if (row >= r || row < 0 || col >= c || col < 0 || arr[row][col] != word.charAt(idx))
            return false;
        if (idx == word.length()-1) return true;
        // self work
        arr[row][col] -= 'A';
        // recursive work
        boolean ans = exists(arr, word, r, c, row+1, col, idx+1) ||
                      exists(arr, word, r, c, row-1, col, idx+1) ||
                      exists(arr, word, r, c, row, col+1, idx+1) ||
                      exists(arr, word, r, c, row, col-1, idx+1);
        arr[row][col] += 'A';
        return ans;
    }
}
