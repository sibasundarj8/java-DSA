package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/crazy-subsets--131708/1
 *
 * # Subsets with MEX in Range
 *
 *   Q. Given an array arr[] of integers and a range [l, r], count the number of subsets whose Minimum Excluded (MEX)
 *      value lies within the given range, inclusive.
 *        ◦ Minimum Excluded (or MEX) of a subset is the smallest non-negative integer that is not present in the subset.
 *        ◦ An empty subset has Minimum Excluded as zero.
 *
 *      Since the answer can be very large, return the answer modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input: arr[] = [2, 0, 1, 0], l = 1, r = 2
 *      Output: 9
 *      Explanation: The subsets whose MEX lies in the range [1, 2] are counted as follows:
 *                   MEX = 1: The subsets must contain at least one 0 and must not contain 1. These subsets are [0]
 *                            (2 ways), [2, 0] (2 ways), [0, 0] (1 way), and [2, 0, 0] (1 way). Total = 6.
 *
 *                   MEX = 2: The subsets must contain both 0 and 1 but must not contain 2. These subsets are [0, 1]
 *                            (2 ways) and [0, 1, 0] (1 way). Total = 3.
 *
 *                   The subsets [2, 0, 1] and [2, 0, 1, 0] have MEX = 3, which is outside the given range.
 *                   Therefore, the total number of valid subsets is 6 + 3 = 9.
 *
 *  Constraints:
 *     ◦ 2 ≤ arr.size() ≤ 10⁵
 *     ◦ 0 ≤ arr[i], r ≤ arr.size()
 *     ◦ 0 ≤ l ≤ r
 */

import java.util.Scanner;

public class Math_Subsets_with_MEX_in_Range {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("l : ");
        int l = sc.nextInt();

        System.out.print("r : ");
        int r = sc.nextInt();

        System.out.println("number of subsets whose MEX value lies within the range: ");
        System.out.println(cntSubsets(arr, l, r));
    }

    /// Solution
    private static final long MOD = (long) 1e9 + 7;
    private static final long[] POW = new long[100001];

    static {
        POW[0] = 1;

        for (int i = 1; i <= 100000; i++) {
            POW[i] = POW[i - 1] << 1;

            if (POW[i] > MOD) {
                POW[i] -= MOD;
            }
        }
    }

    static int cntSubsets(int[] arr, int l, int r) {
        // potd.code.hub
        int[] freq = new int[r + 1];

        for (int ele : arr) {
            if (ele <= r) {
                freq[ele]++;
            }
        }

        long count = 0;
        int rem = arr.length;
        long prvPoss = 1;

        /*
             0 to x-1 must exist at least once
             x must absent
             x+1 to end may or may not exist
        */
        for (int x = 0; x <= r; x++) {
            rem -= freq[x];

            if (x >= l) {
                count = (count + prvPoss * POW[rem]) % MOD;
            }

            if (freq[x] == 0) break;

            prvPoss = (prvPoss * (POW[freq[x]] - 1)) % MOD;
            prvPoss %= MOD;
        }

        return (int) count;
    }
}
