package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/all-numbers-with-specific-difference3558/1
 *
 * # All numbers with specific difference
 *
 *   Q. Given a positive number n and a number d. Find the count of positive numbers smaller or equal to n such that the
 *      difference between the number and sum of its digits is greater than or equal to given specific value d.
 *    Ex.
 *      Input : n = 13, d = 2
 *      Output: 4
 *      Explanation: There are 4 numbers satisfying the\
 *                   Conditions. These are 10, 11, 12 and 13.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁹
 *          1 ≤ d ≤ 10⁹
 */

import java.util.Scanner;

public class Math_All_numbers_with_specific_difference {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.print("d : ");
        int d = sc.nextInt();


        System.out.println("Count of numbers which satisfies that particular condition: ");
        System.out.println(getCount(n, d));
    }

    /// Solution
/*
✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘-Brute-Force-✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘
TC : O(n)
SC : O(1)
*/
    static int bruteForce(int n, int d) {
        for (int i = 1; i <= n; i++) {
            // return when you got the first element which satisfying the condition
            if (difference_bf(i) >= d) return n - i + 1;
        }

        return 0;
    }

    // returns n(value) - sum(digits)
    private static int difference_bf(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) sum += i % 10;
        return num - sum;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-using--Binary-Search-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(log n)
SC : O(1)
*/
    static int binarySearch(int n, int d) {
        int ans = 0;
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // assuming mid is the first number which satisfying the condition.
            if (difference_bs(mid) >= d) {
                ans = n - mid + 1;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    // returns n(value) - sum(digits)
    private static int difference_bs(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) sum += i % 10;
        return num - sum;
    }

/*
✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔-Using--Mathematics-✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔
TC : O(1)
SC : O(1)
*/
    static int getCount(int n, int d) {
        d = ((d + 8) / 9) * 9;
        int firstPossible = ((d + 10) / 10) * 10;

        // add 9 blocks because constraint is up-to 10⁹
        // That means the maximum jump error is also bounded by 81 --> (9 * 9).
        for (int i = 0; i < 9 && difference(firstPossible) < d; i++) {
            firstPossible += 10;
        }

        return Math.max(n - firstPossible + 1, 0);
    }

    // returns n(value) - sum(digits)
    private static int difference(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) sum += i % 10;
        return num - sum;
    }
}
