package GFG;
/*
 *   Q. Given an array of elements arr[] with indices ranging from 0 to arr.size() - 1,
 *      your task is to write a program that rearranges the elements of the array such that
 *      arr[i] = i. If an element i is not present in the array, -1 should be placed at the
 *      corresponding index.
 *   Ex.
 *      Input  : arr[] = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
 *      Output : ans[] = [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POTD_Reorganize_The_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr.add(sc.nextInt());
        }

        System.out.println(rearrange(arr));
    }
    static List<Integer> rearrange(List<Integer> arr) {
        // potd.code.hub
        int n = arr.size();
        List<Integer> ans = new ArrayList<>();

        // initializing ans list with -1.
        for (int i = 0;i < n;i++)
            ans.add(-1);

        // overwriting ans list if element present in arr list
        for (int i : arr)
            if(i < n  &&  i >= 0  &&  ans.get(i) == -1)
                ans.set(i, i);

        return ans;
    }
}