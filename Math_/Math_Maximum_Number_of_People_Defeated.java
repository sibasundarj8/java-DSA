package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/killing-spree3020/1
 *
 * # Maximum Number of People Defeated
 *
 *   Q. There are infinitely many people standing in a row, indexed from 1. The strength of the person at index i is i².
 *      Given a strength p, determine the maximum number of people that can be defeated. A person with strength x can be
 *      defeated only if p ≥ x, after which the strength p decreases by x.
 *
 *    Ex.
 *      Input : p = 14
 *      Output: 3
 *      Explanation: The strengths of the first few people are 1, 4, 9, 16, .... Defeating the first three people consumes
 *                   1 + 4 + 9 = 14 strength, leaving 0. Therefore, the maximum number of people that can be defeated is 3.
 *
 *  Constraints:
 *        1 ≤ p ≤ 3 * 10⁸
 */

import java.util.Scanner;

public class Math_Maximum_Number_of_People_Defeated {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("P : ");
        int p = sc.nextInt();

        System.out.println("Maximum number of people can be defeated: ");
        System.out.println(maxPeopleDefeated(p));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Greedy-Iterative-approach-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(³√p)
SC : O(1)
*/
    static int approach_1(int p) {
        // code here
        int i = 1;

        while (p >= (i * i)) {
            p -= (i * i);
            i++;
        }

        return i - 1;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Math-Binary-Search-approach-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(log p)
SC : O(1)
*/
    static int maxPeopleDefeated(int p) {
        // code here
        int i = 1;
        int j = (int) Math.sqrt(p);

        while (i <= j) {
            int mid = i + (j - i) / 2;
            long val = (mid * (mid + 1L) * (2L * mid + 1)) / 6;

            if (val <= p) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }
}
