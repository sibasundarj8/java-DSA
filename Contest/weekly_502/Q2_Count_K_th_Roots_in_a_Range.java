package Contest.weekly_502;/*
 *
 * https://leetcode.com/contest/weekly-contest-502/problems/count-k-th-roots-in-a-range/
 *
 * # Q2. Count K-th Roots in a Range
 *
 *   Q. You are given three integers l, r, and k.
 *
 *      An integer y is said to be a perfect kth power if there exists an integer x such that y = xᵏ.
 *
 *      Return the number of integers y in the range [l, r] (inclusive) that are perfect kth powers.
 *
 *    Ex.
 *      Input : l = 8, r = 30, k = 2
 *      Output: 3
 *      Explanation:
 *              The perfect squares in the range [8, 30] are:
 *                9 = 32
 *                16 = 42
 *                25 = 52
 *              Hence, the answer is 3.
 *
 *  Constraints:
 *          0 <= l <= r <= 10⁹
 *          1 <= k <= 30
 */

public class Q2_Count_K_th_Roots_in_a_Range {

    /// Solution
    public int countKthRoots(int l, int r, int k) {
        // potd.code.hub
        int start = (int) Math.pow(l, 1.0 / k);
        int end = (int) Math.pow(r, 1.0 / k);

        while (pow(start, k) < l) {
            start++;
        }
        while (pow(end, k) <= r) {
            end++;
        }

        return end - start;
    }

/*
    Extra pow method to avoid double-precision issue in Math.pow().

    In Math class there is no direct method to get K'th root, So I am trying for l ^ ¹⁄ₖ. But there is an issue Math.pow()
    internally calculates double values not integer and if ¹⁄ₖ == ¹⁄₃, ¹⁄₃ = 0.333333333... so 3rd root becomes less precise.
    This pow() method calculates only integer values in logarithmic time and eliminates the risk of precision.
*/
  
    private long pow(long a, int k) {
        // base case
        if (k == 0) return 1;

        // recursive work
        long subPart = pow(a, k / 2);

        // self work
        long res = subPart * subPart;
        return ((k & 1) == 1) ? res * a : res;
    }
}
