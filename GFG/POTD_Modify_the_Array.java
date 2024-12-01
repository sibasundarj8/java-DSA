package GFG;/*
 *   Q. Given an array arr. Return the modified array in such a way that if the current and next numbers are
 *      valid numbers and are equal then double the current number value and replace the next number with 0.
 *      After the modification, rearrange the array such that all 0's are shifted to the end.
 *    Note:
 *      1. Assume ‘0’ as the invalid number and all others as a valid number.
 *      2. The sequence of the valid numbers is present in the same order.
 *   Ex.
 *      Input : arr[] = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8]
 *      Output: [4, 2, 12, 8, 0, 0, 0, 0, 0, 0]
 *      Explanation: At index 5 and 6 both the elements are the same. So, we will change the element at index
 *                   5 to 12 and the element at index 6 is 0. We will change the element at index 1 to 4 and
 *                   the element at index 2 is 0. Then we shift all the zeros to the end of the array. So,
 *                   array will become [4, 2, 12, 8, 0, 0, 0, 0, 0, 0].
 */

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Modify_the_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(modifyAndRearrangeArr(arr));
    }
    static ArrayList<Integer> modifyAndRearrangeArr(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer>ans = new ArrayList<>();
        for (int i = 0;i < n-1;i++){
            if (arr[i] != 0){
                if (arr[i] == arr[i+1]){
                    ans.add(arr[i]*2);
                    i++;
                }
                else {
                    ans.add(arr[i]);
                }
            }
        }
        if (arr[n-1] != 0)ans.add(arr[n-1]);

        for (int i = ans.size();i < n;i++) ans.add(0);

        return ans;
    }
}