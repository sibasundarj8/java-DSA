package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/rearrange-the-array-1639032648/1
 *
 * # Rearrange the Array
 *
 *   Q. I mathematically construct sequential digits by length, using a sliding window technique. Starting with the base
 *      sequence for each size, I systematically drop the leading digit using modulo and append the next consecutive
 *      digit with multiplication, validating and collecting all valid numbers within the range.
 *
 *    Ex.
 *      Input : b[] = [2, 3, 1, 5, 4]
 *      Output: 6
 *      Explanation: The sequence of arrays obtained after each operation is:
 *
 *                   Initially : [1, 2, 3, 4, 5]
 *                    ◦ 1 : [3, 1, 2, 5, 4]
 *                    ◦ 2 : [2, 3, 1, 4, 5]
 *                    ◦ 3 : [1, 2, 3, 5, 4]
 *                    ◦ 4 : [3, 1, 2, 4, 5]
 *                    ◦ 5 : [2, 3, 1, 5, 4]
 *                    ◦ 6 : [1, 2, 3, 4, 5]
 *
 *                   After 6 operations, all elements return to their original positions simultaneously.
 *                   Therefore, the answer is 6.
 *
 *  Constraints:
 *       ◦ 1 ≤ n ≤ 10⁴
 *       ◦ a.size() = b.size() = n
 *       ◦ b[] is a permutation of integers from 1 to n.
 */

import java.util.*;

public class Graph_Rearrange_the_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter b[]: elements must be <= size && > 0");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(s[i]);

            if (b[i] <= 0 || b[i] > n) {
                throw new IllegalArgumentException("Invalid input");
            }
        }

        System.out.println("Minimum number of operation: ");
        System.out.println(minOperations(b));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

    static int minOperations(int[] b) {
        // potd.code.hub
        int n = b.length;
        boolean[] visited = new boolean[n];
        Map<Long, Integer> primeFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long cycleLength = getCycleLength(i, b, visited);
                updatePrimeFactor(cycleLength, primeFreq);
            }
        }

        // getting LCM using prime factors
        long lcm = 1;

        for (long prime : primeFreq.keySet()) {
            int freq = primeFreq.get(prime);
            lcm = (lcm * modPow(prime, freq)) % MOD;
        }

        return (int) lcm;
    }

    private static long getCycleLength(int u, int[] b, boolean[] visited) {
        int length = 0;

        while (!visited[u]) {
            visited[u] = true;
            length++;
            u = b[u] - 1;
        }

        return length;
    }

    private static void updatePrimeFactor(long num, Map<Long, Integer> primeFreq) {
        long prime = 2;

        while (prime * prime <= num) {
            int count = 0;

            while (num % prime == 0) {
                count++;
                num /= prime;
            }

            primeFreq.put(prime, Math.max(count, primeFreq.getOrDefault(prime, 0)));
            prime++;
        }

        if (num > 1) {
            primeFreq.put(num, Math.max(1, primeFreq.getOrDefault(num, 0)));
        }
    }

    private static long modPow(long a, long b) {
        // base case
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;

            b = b >> 1;
        }

        return res;
    }
}
