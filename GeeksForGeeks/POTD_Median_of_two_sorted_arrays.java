package GFG;/*
 *   Q. Given 2 sorted integer arrays arr1 and arr2. Find the median of two sorted arrays
 *      arr1 and arr2.
 *
 *      Examples:
 *              Input: arr1 = [1, 2, 4, 6, 10]
 *                     arr2 = [4, 5, 6, 9, 12]
 *              Output: 11
 *              Explanation:
 *                          The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12].
 *                          Sum of middle elements is 11 (5 + 6).
 */
import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Median_of_two_sorted_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[]arr2 = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Elements of 2nd Array :");
        for (int i = 0;i < n;i++)
            arr2[i] = sc.nextInt();
        System.out.println(sumOfMiddleElements(arr,arr2));
    }
    static int sumOfMiddleElements(int[]arr1, int[]arr2) {
        // potd.code.hub
        int n = arr1.length;
        ArrayList<Integer>ans = new ArrayList<>();
        int i = 0, j = 0,count = 0;
        while(count <= n){
            if (arr1[i] < arr2[j]){
                if (count == n-1 || count == n)
                    ans.add(arr1[i]);
                i++;
            }
            else {
                if (count == n-1 || count == n)
                    ans.add(arr2[j]);
                j++;
            }
            count++;
        }
        return ans.get(0)+ans.get(1);
    }
}