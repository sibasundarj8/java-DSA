package Stack;/*
 * https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1?page=1&category=Stack&sortBy=submissions
 *
 * # Immediate Smaller Element
 *
 *   Q. Given an integer array arr of size n. For each element in the array, check whether the right adjacent
 *      element (on the next immediate position) of the array is smaller. If next element is smaller, update
 *      the current index to that element. If not, then  -1.
 *
 *      Note : You need to make changes in the array itself.
 *   Ex.
 *    Input : n = 5
 *            arr[] = {4, 2, 1, 5, 3}
 *    Output: 2 1 -1 3 -1
 *    Explanation: Array elements are 4, 2, 1, 5, 3. Next to 4 is 2 which is smaller, so we print 2. Next of
 *                 2 is 1 which is smaller,so we print 1. Next of 1 is 5 which is greater, so we print -1.
 *                 Next of 5 is 3 which is smaller, so we print 3.  Note that for last element, output is
 *                 always  going to be -1 because there is no element on right.
 */
import java.util.Scanner;

public class S0_Immediate_Smaller_Element {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        immediateSmaller(arr, n);

        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    /// Solution
    static void immediateSmaller(int[]arr, int n) {
        // potd.code.hub
        for(int i = 0;i < n-1;i++) {
            arr[i] = arr[i + 1] < arr[i] ? arr[i + 1] : -1;
        }
        arr[n-1] = -1;
    }
}