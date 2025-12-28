package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-time-to-fulfil-all-orders/1
 *
 * # Minimum time to fulfil all orders
 *
 *   Q. Geek is organizing a party at his house. For the party, he needs exactly n donuts for the guests. Geek decides to
 *      order the donuts from a nearby restaurant, which has m chefs and each chef has a rank r.
 *
 *      A chef with rank r can make 1 donut in the first r minutes, 1 more donut in the next 2r minutes, 1 more donut in
 *      the next 3r minutes, and so on.
 *
 *      For example, a chef with rank 2, can make one donut in 2 minutes, one more donut in the next 4 minutes, and one
 *      more in the next 6 minutes. So, it takes 2 + 4 + 6 = 12 minutes to make 3 donuts. A chef can move on to making the
 *      next donut only after completing the previous one. All the chefs can work simultaneously.
 *
 *      Since, it's time for the party, Geek wants to know the minimum time required in completing n donuts. Return an
 *      integer denoting the minimum time.
 *
 *    Ex.
 *      Input : n = 10, rank[] = [1, 2, 3, 4]
 *      Output: 12
 *      Explanation:
 *              Chef with rank 1, can make 4 donuts in time 1 + 2 + 3 + 4 = 10 mins
 *              Chef with rank 2, can make 3 donuts in time 2 + 4 + 6 = 12 mins
 *              Chef with rank 3, can make 2 donuts in time 3 + 6 = 9 mins
 *              Chef with rank 4, can make 1 donut in time = 4 minutes
 *              Total donuts = 4 + 3 + 2 + 1 = 10 and total time = 12 minutes.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10³
 *          1 ≤ m ≤ 10⁴
 *          1 ≤ rank[i] ≤ 100
 */

import java.util.Scanner;

public class Searching_Minimum_time_to_fulfil_all_orders {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Required Donuts: ");
        int n = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter the rank of chefs: ");
        String[]  s = sc.nextLine().split(" ");

        int m = s.length;
        int[] ranks = new int[m];
        for (int i = 0; i < m; i++) ranks[i] = Integer.parseInt(s[i]);

        System.out.println("Minimum time to prepare: " + minTime(ranks, n));
    }

    /// Solution
    static int minTime(int[] ranks, int n) {
        int i = 0;
        int j = ranks[0] * (n * (n+1)) / 2;
        int ans = 0;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(countDonuts(ranks, mid) >= n) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

    private static int countDonuts(int[] ranks, int time) {
        int ans = 0;

        for(int rank : ranks) {
            ans += count(rank, time);
        }

        return ans;
    }

    private static int count(int rank, int time) {
        int c = time / rank * 2;
        return (int) ((-1 + Math.sqrt(1 + 4 * c)) / 2);
    }
}
