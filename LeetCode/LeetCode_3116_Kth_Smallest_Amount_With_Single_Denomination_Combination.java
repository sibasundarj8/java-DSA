package LeetCode;/*
 *
 * https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/
 *
 * # LC. 3116. Kth Smallest Amount With Single Denomination Combination
 *
 *   Q. You are given an integer array coins representing coins of different denominations and an integer k.
 *
 *      You have an infinite number of coins of each denomination. However, you are not allowed to combine coins of
 *      different denominations.
 *
 *      Return the kth smallest amount that can be made using these coins.
 *
 *    Ex.
 *      Input : coins = [5,2], k = 7
 *      Output: 12
 *      Explanation: The given coins can make the following amounts:
 *                      ◦ Coin 5 produces multiples of 5: 5, 10, 15, 20, etc.
 *                      ◦ Coin 2 produces multiples of 2: 2, 4, 6, 8, 10, 12, etc.
 *                   All the coins combined produce: 2, 4, 5, 6, 8, 10, 12, 14, 15, etc.
 *
 *  Constraints:
 *        ◦ 1 <= coins.length <= 15
 *        ◦ 1 <= coins[i] <= 25
 *        ◦ 1 <= k <= 2 * 10⁹
 *        ◦ coins contains pairwise distinct integers.
 */

import java.util.Scanner;

public class LeetCode_3116_Kth_Smallest_Amount_With_Single_Denomination_Combination {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("coins[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        if (n > 15) {
            throw new IllegalArgumentException("array size must be smaller than equals 15");
        }

        int[] coins = new int[n];
        boolean[] flag = new boolean[26];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(s[i]);

            if (coins[i] > 25)
                throw new IllegalArgumentException("coin value must be smaller than 25");

            if (flag[coins[i]])
                throw new IllegalArgumentException("coin value must be unique");

            flag[coins[i]] = true;
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("k'th smallest amount that can be made using these coins: ");
        System.out.println(findKthSmallest(coins, k));
    }

    /// Solution
    public static long findKthSmallest(int[] coins, int k) {

        int n = coins.length;
        boolean flag;
        int smallest = Integer.MAX_VALUE;
        int count = 0;
        boolean[] take = new boolean[n];

        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && coins[i] % coins[j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
                smallest = Math.min(smallest, coins[i]);
                take[i] = true;
            }
        }

        int[] newCoins = new int[count];
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (take[i]){
                newCoins[x++] = coins[i];
            }
        }

        long i = 1;
        long j = smallest * (long) k;

        while (i <= j) {
            long mid = i + ((j - i) >> 1);
            if (getIndex(newCoins, mid) >= k) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }

    private static long getIndex(int[] coins, long value) {
        int n = coins.length;
        int limit = (1 << n) - 1;
        long lcm;
        long add;
        boolean plus;
        long count = 0;

        for (int mask = 1; mask <= limit; mask++) {
            lcm = 1;
            plus = false;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    lcm = getLcm(lcm, coins[i]);
                    plus ^= true;
                }
            }

            if (lcm <= value) {
                add = value / lcm;
                count += (plus ? add : -add);
            }
        }

        return count;
    }

    private static long getLcm(long a, long b) {
        return (a / getGcd(a, b)) * b;
    }

    private static long getGcd(long a, long b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}

/*

[3, 6, 9]
k = 3

ex-2
-----
[2, 3, 5, 7, 11, 13, 17, 19, 23]
k = 50

[ans] --> {

    smallest element = 2 and k = 50
    then, 2 * 50 = 100 can be a possible answer;
    getPos(100) --> what is the actual index of 100 in sequence.

    I think, should I calculate the lower bound of 50th index ??
    => coins[i] * x = y
    => I mean if getPos(y) returns x and x < k --> x = mid + 1 other wise mid - 1.

    then if I don't get the exact answer then start checking for coins[i+1] and so on.

}

getIndex(int target) --> {

    if coins = {3, 6, 9}
    => here both 6 and 9 are divisible by 3 then we actually dn't need 6 and 9. only 3 is enough
    => according to this logic I need to remove the multiples first.
    => after that the remaining are eithers prime numbers or such numbers which prime factors are not present here.

    idx --> target/cioins[i] + target/coins[i+1] + target/coins[i+2] + ... + target/coins[n-1]
            -target/coins[lcm(i, j)] - target/coins[lcm(i, j+1)] - target/coins[lcm(i, j+2)] - ... all the combinations of two
            +target/coins[lcm(i,j,k)] + target/coins[lcm(i, j, k+1)] + target/coins[lcm(i, j, k+2)] + ... all the combination of three
            .
            .
            .
            - combination of even numbers lcm
            + combination of odd numbers lcm

}

*/
