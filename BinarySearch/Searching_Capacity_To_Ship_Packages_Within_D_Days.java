package BinarySearch;/*
 * 
 * https://www.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1
 * 
 * # Capacity To Ship Packages Within D Days
 * 
 *   Q. Given an array arr[] of n weights. Find the least weight capacity of a boat to ship all 
 *      weights within d days.
 *      
 *      The ith weight has a weight of arr[i]. Each day, we load the boat with weights given by 
 *      arr[i].We may not load more weight than the maximum weight capacity of the ship.
 * 
 *      Note: You have to load weights on the boat in the given order.
 *    Ex.
 *      Input:
 *              n = 3
 *              arr[] = {9, 8, 10}
 *              d = 3
 *      Output:
 *              10
 *      Explanation:
 *              We can ship the weights in 3 days
 *              in the following way:-
 *              Day 1- 9
 *              Day 2-8
 *              Day 3-10
 */
import java.util.Scanner;

public class Searching_Capacity_To_Ship_Packages_Within_D_Days {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of Days: ");
        int d = sc.nextInt();

        System.out.println(leastWeightCapacity(arr, d));
    }

    /// Solution
    static int leastWeightCapacity(int[] arr, int d) {
        // code here
        int i = 0, j = 0, ans = -1;
        for (int x : arr){
            i = Math.max(i, x);
            j += x;
        }
        
        while (i <= j){
            int mid = i + (j-i)/2;
            if (isValid(arr, d, mid)){
                j = mid - 1;
                ans = mid;
            }
            else {
                i = mid + 1;
            }
        }
        
        return ans;
    }
    
    private static boolean isValid(int[]arr, int d, int boatCap){
        int day = 1;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (sum > boatCap) {
                sum = j;
                day++;
            }
        }
        return day <= d;
    }
}
