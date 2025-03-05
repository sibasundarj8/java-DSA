package LeetCode;/*
 *
 * https://leetcode.com/problems/count-total-number-of-colored-cells/
 *
 * #2579. Count Total Number of Colored Cells
 *
 *   Q. There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a
 *      positive integer n, indicating that you must do the following routine for n minutes:
 *
 *        ⁜ At the first minute, color any arbitrary unit cell blue.
 *        ⁜ Every minute thereafter, color blue every uncolored cell that touches a blue cell.
 *
 *      Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
 * ▩▦▥▨▧▤
 *      for min 1:             ▦
 *
 *                             ▥
 *      for min 2:           ▤ ▦ ▤
 *                             ▥
 *
 *                             ▤
 *                           ▥ ▥ ▥
 *      for min 3:         ▤ ▥ ▦ ▥ ▤
 *                           ▥ ▥ ▥
 *                             ▤
 *      Return the number of colored cells at the end of n minutes.
 */
import java.util.Scanner;

public class LeetCode_2579_Count_Total_Number_of_Colored_Cells {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(coloredCells(n));
    }

    /// Solution
    static long coloredCells(int n) {
        /*
        # My thought process...
          suppose for 5th minute:
                   ans = 1 + 4 + 8 + 12 + 16 = 41
                       = 1 + 4 * (1 + 2 + 3 + 4)
          similarly for nth minute:
                    ans = 1 + 4 + 8 + 12 + 16 + ... + 4(n-1)   = X
                        = 1 + 4 * (1 + 2 + 3 + 4 + ... + (n-1))= X
                        = 1 + 4 * (sum of all natural numbers up to n-1) {∵ formula is n(n+1) / 2}
                        = 1 + 4 * ((n-1)*(n) / 2)
                        = 1 + 2 * ((n-1)*(n))
        */
        return 1 + 2 * ((long) n * (n-1));
    }

/// After understanding the progression, I conclude that
/// it grows every time 4 * i times except first time.
///  Time Complexity: O(n)
/// Space Complexity: O(1)
    /*static long coloredCells(int n) {
        int ans = 1;
        for (int i = 0;i < n;i++)
            ans += 4 * i;

        return ans;
    }*/
}
