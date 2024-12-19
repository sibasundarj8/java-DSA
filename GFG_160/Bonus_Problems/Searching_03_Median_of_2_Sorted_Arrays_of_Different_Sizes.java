package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1
 *
 * # Median of 2 Sorted Arrays of Different Sizes
 *
 *   Q. Given two sorted arrays a[] and b[]. You need to find and return the median of the combined array
 *      after merging them into a single sorted array.
 *    Ex.
 *      Input : a[] = [-5, 3, 6, 12, 15]
 *              b[] = [-12, -10, -6, -3, 4, 10]
 *      Output: 3
 *      Explanation: The merged array is [-12, -10, -6, -5, -3, 3, 4, 6, 10, 12, 15]. So the median of the
 *                   merged array is 3.
 */
import java.util.Scanner;

public class Searching_03_Median_of_2_Sorted_Arrays_of_Different_Sizes {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ensure that, Elements of both arrays must be in sorted order.");

        System.out.println("Size of A[]: ");
        int n = sc.nextInt();

        int[]a = new int[n];

        System.out.println("Elements of A[]: ");
        for (int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }

        System.out.println("Size of B[]: ");
        n = sc.nextInt();

        int[]b = new int[n];

        System.out.println("Elements of B[]: ");
        for (int i = 0;i < n;i++){
            b[i] = sc.nextInt();
        }

        System.out.println(medianOf2(a, b));
    }

    /// Solution
    static double medianOf2(int[]a, int[]b) {
        // potd.code.hub
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return medianOf2(b, a);

        int i = 0, j = n1;
        int total = (n1+n2+1)/2;
        while (i <= j){
            int mid1 = i + (j-i)/2;
            int mid2 = total - mid1;
            int l1 = (mid1-1 >= 0) ? a[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2-1 >= 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1){
                if ((n1+n2) % 2 == 1) return Math.max(l1, l2);
                else return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
            else if (l1 > r2) j = mid1-1;
            else i = mid1+1;
        }
        return 0;
    }
}
