package Binary_Search;/*
 *   Q. Given an array of integers ‘arr’ and an integer threshold ‘k’, we will choose a positive
 *      integer divisor ‘x’, divide all the array elements by it, and sum the division's result.
 *      Find the smallest divisor such that the result mentioned above is less than or equal to
 *      threshold. Each result of the division is rounded to the nearest integer greater than or
 *      equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 *      Note: Arr[i] <= 1000000000, for all i.
 *
 *      Example :
 *              Input : n = 4
 *                      Arr = [1, 2, 5, 9]
 *                      k = 6
 *              Output :
 *                      5
 */
import java.util.Scanner;

public class Searching_Smallest_Divisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Threshold :");
        int k = sc.nextInt();

        System.out.println(find(arr,k));
    }
    static int find(int[]arr,int k){
        int i = 1;
        int j = (int)1e9;
        int ans = (int)1e9;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (elementsSum(arr,mid) > k)
                i = mid+1;
            else {
                ans = mid;
                j = mid-1;
            }
        }
        return ans;
    }
    static int elementsSum(int[]arr,int k){
        int ans = 0;
        for (int i : arr) ans += divide(i, k);
        return ans;
    }
    static int divide(int x,int t){
        int rem = x%t;
        int ans = x/t;
        if (rem != 0)return ans+1;
        return ans;
    }
}