package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
 *
 * # Smallest Positive Missing Number
 * 
 *   Q. You are given an integer array arr[]. Your task is to find the smallest positive number missing 
 *      from the array.
 * 
 *      Note: Positive number starts from 1. The array can have negative integers too.
 *    Ex.
 *      Input : arr[] = [2, -3, 4, 1, 1, 7]
 *      Output: 3
 *      Explanation: Smallest positive missing number is 3.
 */
import java.util.Scanner;

public class GFG_13_Smallest_Positive_Missing_Number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Element: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(missingNumber(arr));
    }

    /// Solution
    static int missingNumber(int[]arr) {
        // potd.code.hub
        int n = arr.length;

        for (int i = n-1;i >= 0;i--){
            int ele = arr[i];
            if (ele > 0 && ele < n && arr[i] != arr[ele]){
                int temp = arr[i];
                arr[i] = arr[ele];
                arr[ele] = temp;
                i++;
            }
        }

        for (int i = 1;i < n;i++){
            if (arr[i] != i){
                return i;
            }
        }

        if (arr[0] != n)return n;

        return n+1;
    }
}
