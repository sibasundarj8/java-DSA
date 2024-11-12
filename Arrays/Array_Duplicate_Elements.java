package Array;/*
 *      Q. Given an array arr of size n which contains elements in range from 0 to n-1,
 *         you need to find all the elements occurring more than once in the given array.
 *         Return the answer in ascending order. If no such element is found, return list
 *         containing [-1].
 *
 *       Note: Try and perform all operations within the provided array. The extra (non-constant)
 *            space needs to be used only for the array to be returned.
 *
 *       Examples:
 *              Input : arr[] = {0,3,1,2}, n = 4
 *              Output: -1
 *         Explanation: There is no repeating element in the array. Therefore, output is -1.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Array_Duplicate_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements must be smaller then n :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(duplicates(arr));
    }
    static ArrayList<Integer> duplicates(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < n;i++){
            int idx = arr[i]%n;
            arr[idx] += n;
        }
        for(int i = 0;i < n;i++)
            if(arr[i]/n > 1)
                ans.add(i);

        if (ans.isEmpty())ans.add(-1);
        return ans;
    }
}