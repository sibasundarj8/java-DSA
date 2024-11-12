package Binary_Search;/*
 *   Q. You are given an integer mountain array arr of length n where the values increase
 *      to a peak element and then decrease.
 *      Return the index of the peak element.
 *      Your task is to solve it in O(log(n)) time complexity.
 *    Ex.
 *      Input : arr = [0,10,5,2]
 *      Output: 1
 */
import java.util.Scanner;

public class Searching_peak_index_Mountain_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size : ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Output : " + find(arr,n));
    }
    static int find(int[]arr,int n){
        int i = 0;
        int j = n-1;
        int ans = -1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid] < arr[mid+1]) {
                ans = mid+1;
                i = mid + 1;
            }
            else j = mid-1;
        }
        return ans;
    }
}