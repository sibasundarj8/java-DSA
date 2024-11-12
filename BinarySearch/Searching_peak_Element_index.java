package Binary_Search;/*
 *   Q. A peak element is an element that is strictly greater than its neighbors.
 *      Given a 0-indexed integer array nums, find a peak element, and return its index.
 *      If the array contains multiple peaks, return the index to any of the peaks.
 *      You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
 *      considered to be strictly greater than a neighbor that is outside the array.
 *      You must write an algorithm that runs in O(log n) time.
 *    Example :
 *              Input: nums = [1,2,1,3,5,6,4]
 *              Output: 5
 *              Explanation: Your function can return either index number 1 where the peak
 *                           element is 2, or index number 5 where the peak element is 6.
 */
import java.util.Scanner;

public class Searching_peak_Element_index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("output : " + findPeakElement(arr));
    }
    static int findPeakElement(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i <= j){
            int mid = i + (j-i)/2;
            if((mid==0 || arr[mid]>arr[mid-1]) && (mid==arr.length-1 || arr[mid]>arr[mid+1])){
                return mid;
            }
            else if (arr[mid] < arr[mid+1]) i = mid+1;
            else j = mid-1;
        }
        return -1;
    }
}
