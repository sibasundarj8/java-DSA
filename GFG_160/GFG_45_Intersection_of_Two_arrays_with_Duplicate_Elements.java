package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/intersection-of-two-arrays-with-duplicate-elements/1
 *
 * #
 *   Q. Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection
 *      of two arrays is said to be elements that are common in both arrays. The intersection should not have
 *      duplicate elements and the result should contain items in any order.
 *
 *      Note: The driver code will sort the resulting array in increasing order before printing.
 *    Ex.
 *      Input : a[] = [1, 2, 1, 3, 1]
 *              b[] = [3, 1, 3, 4, 1]
 *      Output: [1, 3]
 *      Explanation: 1 and 3 are the only common elements, and we need to print only one occurrence of common
 *                   elements.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GFG_45_Intersection_of_Two_arrays_with_Duplicate_Elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of A[]: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements of A[]: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("Size of B[]: ");
        n = sc.nextInt();

        int[] brr = new int[n];

        System.out.println("Elements of B[]: ");
        for (int i = 0; i < n; i++) brr[i] = sc.nextInt();

        System.out.println(intersectionWithDuplicates(arr, brr));
    }

    /// Solution
    static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // potd.code.hub
        if (b.length < a.length) return intersectionWithDuplicates(b, a);
        
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();
        for (int i : a) temp.add(i);
        for (int i : b){
            if (temp.contains(i)){
                ans.add(i);
                temp.remove(i);
            }
        }
        
        return ans;
    }
}
