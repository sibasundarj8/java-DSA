package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 *
 * # Merge Without Extra Space
 *
 *   Q. Given two sorted arrays a[] and b[] in non-decreasing order. Merge them in sorted order without 
 *      using any extra space. Modify a so that it contains the first n elements and modify b so that it 
 *      contains the last m elements.
 *    Ex.
 *      Input : a[] = [1, 5, 9, 10, 15, 20]
 *              b[] = [2, 3, 8, 13]
 *      Output: 1 2 3 5 8 9
 *              10 13 15 20
 *      Explanation: After merging two sorted arrays we get 5 10 12 18 20.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_27_Merge_Without_Extra_Space {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("A size: ");
        int n = sc.nextInt();
        int[]a = new int[n];
        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }

        System.out.println("B size: ");
        n = sc.nextInt();
        int[]b = new int[n];
        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            b[i] = sc.nextInt();
        }

        mergeArrays(a, b);

        Arrays.stream(a).forEach(t -> System.out.print(t + " "));
        Arrays.stream(b).forEach(t -> System.out.print(t + " "));
    }

    /// Solution
    static void mergeArrays(int[]a, int[]b) {
        // potd.code.hub
        int n = a.length;
        int m = b.length;

        int len = n+m;
        int gap = (len/2) + (len%2);

        while (gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                // left in A[] & right in B[]
                if (left < n && right >= n){
                    swap(a, b, left, right-n);
                }
                // both in B[]
                else if (left >= n){
                    swap(b, b, left-n, right-n);
                }
                // both in A[]
                else {
                    swap(a, a, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }
    // Swap
    private static void swap(int[]arr, int[]brr, int i, int j){
        if (arr[i] > brr[j]){
            int temp = arr[i];
            arr[i] = brr[j];
            brr[j] = temp;
        }
    }
}
