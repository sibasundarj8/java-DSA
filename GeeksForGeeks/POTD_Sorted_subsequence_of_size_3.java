/*
 *   Q. You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k]
 *      and i < j < k.
 *
 *      Example :
 *              Input: arr = [1, 2, 1, 1, 3]
 *              Output: 1
 *              Explanation: A subsequence 1 2 3 exist.
 */
package GFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POTD_Sorted_subsequence_of_size_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements : ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println(find3Numbers(arr));
    }
    static List<Integer> find3Numbers(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        int[]small = new int[n];
        int[]large = new int[n];
        List<Integer>ans = new ArrayList<>();
        // Left Small Array
        int temp = arr[0];
        for (int i = 0;i < n;i++){
            small[i] = Math.min(temp,arr[i]);
            temp = Math.min(temp,arr[i]);
        }
        // Right Large Array
        temp = arr[n-1];
        for (int i = n-1;i >= 0;i--){
            large[i] = Math.max(temp,arr[i]);
            temp = Math.max(temp,arr[i]);
        }
        // Answer
        for (int i = 0;i < n;i++){
            if (small[i] < arr[i] && arr[i] < large[i]){
                ans.add(small[i]);
                ans.add(arr[i]);
                ans.add(large[i]);
                return ans;
            }
        }
        return new ArrayList<>();
    }
    static void printArray(int[]arr){
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}