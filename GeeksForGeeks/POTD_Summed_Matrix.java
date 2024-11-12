package GFG;/*
 *   Q. A matrix is constructed of size n*n and given an integer ‘q’.
 *      The value at every cell of the matrix is given as, M(i,j) = i+j,
 *      where ‘M(i,j)' is the value of a cell, ‘i’ is the row number,
 *      and ‘j’ is the column number.
 *      Return the number of cells having value ‘q’.
 *
 *  Note: Assume, the array is in 1-based indexing.
 *  Ex.
 *      Input : n = 4
 *              q = 7
 *     Output : 2
 * Explanation: Matrix becomes
 *                              2 3 4 5
 *                              3 4 5 6
 *                              4 5 6 7
 *                              5 6 7 8
 *              The count of 7 is 2.
 */
import java.util.Scanner;

public class POTD_Summed_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size : ");
        long n = sc.nextInt();

        // Print Matrix..
        for (long i = 1;i <= n;i++){
            for (long j = 1;j <= n;j++){
                System.out.print(i+j + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the number which frequency you want :");
        long q = sc.nextInt();

        System.out.println(sumMatrix(n,q));
    }
    static long sumMatrix(long n,long q){
        // last element can't be greater than 2*n;
        if (q > n*2) return 0;
        long ch;
        if (q == n+1)return n;
        else ch = Math.abs((n+1)-q);
        return n-ch;
    }
}