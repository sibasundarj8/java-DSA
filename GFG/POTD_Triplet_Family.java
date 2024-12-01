package GFG;

import java.util.Arrays;
import java.util.Scanner;

/*
 *      # 3-SUM approach
 *
 *       Q. Given an array arr of integers. Find whether three numbers are such that the sum of two elements
 *          equals the third element.
 *      Example:
 *          Input : arr[] = [1, 2, 3, 4, 5]
 *          Output: true
 *         Explanation: The pair (1, 2) sums to 3.
 */
public class POTD_Triplet_Family {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size:");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements:");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("isTriplet : " + findTriplet(arr, n));
    }
    static boolean findTriplet(int[]arr,int n){
        Arrays.sort(arr);
        for (int k = n-1;k > 1;k--){
            int i = 0, j = k-1;
            while (i < j){
                if (arr[i] + arr[j] == arr[k]) return true;
                else if (arr[i] + arr[j] < arr[k])i++;
                else j--;
            }
        }
        return false;
    }
}