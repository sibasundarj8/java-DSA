package Contest.biWeekly_180;/*
 *
 * https://leetcode.com/contest/biweekly-contest-180/problems/minimum-operations-to-transform-array-into-alternating-prime/
 *
 * # Q3. Minimum Operations to Transform Array into Alternating Prime
 *
 *   Q. You are given an integer array nums.
 *
 *      An array is considered alternating prime if:
 *        ◦ Elements at even indices (0-based) are prime numbers.
 *        ◦ Elements at odd indices are non-prime numbers.
 *
 *      In one operation, you may increment any element by 1.
 *
 *      Return the minimum number of operations required to transform nums into an alternating prime array.
 *
 *      A prime number is a natural number greater than 1 with only two factors, 1 and itself.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4]
 *      Output: 3
 *      Explanation:
 *             ◦ The element at index 0 must be prime. Increment nums[0] = 1 to 2, using 1 operation.
 *             ◦ The element at index 1 must be non-prime. Increment nums[1] = 2 to 4, using 2 operations.
 *             ◦ The element at index 2 is already prime.
 *             ◦ The element at index 3 is already non-prime.
 *             Total operations = 1 + 2 = 3.
 *
 *  Constraints:
 *          1 <= nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3_Minimum_Operations_to_Transform_Array_into_Alternating_Prime {

    /// Solution
    private final static int size = 100005;
    private final static boolean[] sieve = new boolean[size];
    private final static List<Integer> primes = new ArrayList<>();

    static {
        Arrays.fill(sieve, true);

        for (long i = 2; i < size; i++) {
            if (sieve[(int) i]) {
                for (long j = i * i; j < size; j += i) {
                    sieve[(int) j] = false;
                }
            }
        }

        sieve[0] = sieve[1] = false;

        for (int i = 0; i < size; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int next = nextPrime(nums[i]);

            if (i % 2 == 0) {
                res += (next - nums[i]);
            } else {
                if (next == nums[i]) {
                    if (nums[i] == 2) res += 2;
                    else res++;
                }
            }
        }

        return res;
    }

    private int nextPrime(int ele) {
        int i = 0;
        int j = primes.size() - 1;
        int res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (primes.get(mid) >= ele) {
                res = primes.get(mid);
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return res;
    }
}
