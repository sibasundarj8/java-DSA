package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-time-to-repair-cars/
 *
 * # 2594. Minimum Time to Repair Cars
 *
 *   Q. You are given an integer array ranks representing the ranks of some mechanics. Ranks is the
 *      rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
 *
 *      You are also given an integer cars representing the total number of cars waiting in the
 *      garage to be repaired.
 *
 *      Return the minimum time taken to repair all the cars.
 *
 *      Note: All the mechanics can repair the cars simultaneously.
 *   Ex.
 *      Input : ranks = [5,1,8]
 *              cars = 6
 *      Output: 16
 *      Explanation:
 *         - The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
 *         - The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
 *         - The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
 *         It can be proved that the cars cannot be repaired in less than 16 minutes.
 */
import java.util.Scanner;

public class LeetCode_2594_Minimum_Time_to_Repair_Cars {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of mechanics: ");
        int n = sc.nextInt();

        int[] ranks = new int[n];

        System.out.println("Enter ranks: ");
        for (int i = 0;i < n;i++)
            ranks[i] = sc.nextInt();

        System.out.println("Number of cars waiting in the garage to be repaired: ");
        int cars = sc.nextInt();

        System.out.println(repairCars(ranks, cars));
    }

    /// Solution
    static long repairCars(int[] ranks, int cars){
        int n = ranks.length;
        long i, j = ranks[0], ans;

        for (int x = 1;x < n;x++)
            j = Math.min(j, ranks[x]);

        i = 0;
        ans = j *= (long) cars *cars;

        while (i <= j){
            long mid = i + (j-i)/2;
            if (isPos(ranks, cars, mid)){
                ans = mid;
                j = mid-1;
            }
            else i = mid+1;
        }

        return ans;
    }
    private static boolean isPos(int[]ranks, long cars, long res){
        long count = 0;
        for (int x : ranks)
            count += (int)Math.sqrt((double)res/x);
        return count >= cars;
    }
}
