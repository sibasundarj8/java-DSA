package GFG;/*
 *   Q. Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element
 *      that would be at the kth position of the combined sorted array.
 *    Example :
 *      Input : k = 5
 *              arr1[] = [2, 3, 6, 7, 9]
 *              arr2[] = [1, 4, 8, 10]
 *      Output: 6
 *      Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10.
 *                   The 5th element of this array is 6.
 */
import java.util.Scanner;

public class POTD_K_th_element_of_two_Arrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size of Array 1 :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Size of Array 2 :");
        int m = sc.nextInt();
        int[]arr2 = new int[m];
        System.out.println("Enter Elements :");
        for (int i = 0;i < m;i++)
            arr2[i] = sc.nextInt();

        System.out.println("k : ");
        int k = sc.nextInt();

        System.out.println(kthElement(k,arr,arr2));
    }
    static long kthElement(int k, int[]arr1, int[]arr2) {
        // potd.code.hub
        int n = arr1.length;
        int m = arr2.length;
        int i = 0,j = 0,count = 0;
        long ans = -1;

        while (i < n && j < m){
            ans = Math.min(arr1[i],arr2[j]);
            count++;
            if (count == k)return ans;
            if (arr1[i] < arr2[j])i++;
            else j++;
        }
        while (i < n && count < k){
            ans = arr1[i++];
            count++;
        }
        while (j < m && count < k){
            ans = arr2[j++];
            count++;
        }
        return ans;
    }
}