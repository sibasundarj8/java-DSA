package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
 *
 * # Koko Eating Bananas
 *
 *   Q. Given an array arr[] of integers where each element represents a pile of bananas, and Koko has k hours
 *      to finish all the piles, find the minimum number of bananas (s) Koko must eat per hour to finish all
 *      the bananas within k hours. Each hour, Koko chooses a pile and eats s bananas from it. If the pile has
 *      fewer than s bananas, she consumes the entire pile for that hour and won't eat any other banana during
 *      that hour.
 *    Ex.
 *      Input : arr[] = [3, 6, 7, 11]
 *              k = 8
 *      Output: 4
 *      Explanation: Koko eats at least 4 bananas per hour to finish all piles within 8 hours, as she can
 *                   consume each pile in 1 + 2 + 2 + 3 = 8 hours.
 */
import java.util.Scanner;

public class Searching_05_Koko_Eating_Bananas {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Piles: ");
        int n = sc.nextInt();

        int[]piles = new int[n];

        System.out.println("Enter the number of bananas in i-th pile");
        for (int i = 0;i < n;i++){
            piles[i] = sc.nextInt();
        }

        System.out.println("Hours to finish all the piles: ");
        int k = sc.nextInt();

        System.out.println(kokoEat(piles, k));
    }

    /// Solution
    static int kokoEat(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int i = 1, j = Integer.MIN_VALUE;
        for (int t : arr) j = Math.max(j, t);

        while (i <= j){
            int mid = i + (j-i)/2;
            if (hours(arr, n, mid) > k) i = mid+1;
            else j = mid-1;
        }
        return i;
    }
    private static int hours(int[]arr, int n, int limit){
        int ans = 0;
        for (int i = 0;i < n;i++){
            if (arr[i] > limit)
                ans += arr[i] % limit == 0 ? arr[i]/limit : (arr[i]/limit) + 1;
            else ans++;
        }
        return ans;
    }
}
