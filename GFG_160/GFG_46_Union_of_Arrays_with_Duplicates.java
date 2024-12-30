package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
 *
 * # Union of Arrays with Duplicates
 *
 *   Q. Given two arrays a[] and b[], the task is to find the number of elements in the union between these
 *      two arrays.
 *
 *      The Union of the two arrays can be defined as the set containing distinct elements from both arrays.
 *      If there are repetitions, then only one element occurrence should be there in the union.
 *
 *      Note: Elements of a[] and b[] are not necessarily distinct.
 *    Ex.
 *      Input : a[] = [1, 2, 3, 4, 5]
 *              b[] = [1, 2, 3]
 *      Output: 5
 *      Explanation: Union set of both the arrays will be 1, 2, 3, 4 and 5. So count is 5.
 */
import java.util.HashSet;
import java.util.Scanner;

public class GFG_46_Union_of_Arrays_with_Duplicates {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of A[]:");
        int n = sc.nextInt();

        int[]a = new int[n];

        System.out.println("Elements of A[]:");
        for (int i = 0;i < n;i++) a[i] = sc.nextInt();

        System.out.println("Size of B[]:");
        n = sc.nextInt();

        int[]b = new int[n];

        System.out.println("Elements of B[]:");
        for (int i = 0;i < n;i++) b[i] = sc.nextInt();

        System.out.println(findUnion(a, b));
    }

    /// Solution
    static int findUnion(int []a, int []b) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);
        for (int i : b) set.add(i);

        return set.size();
    }
}
