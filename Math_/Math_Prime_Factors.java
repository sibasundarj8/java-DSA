package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/prime-factors5052/1
 *
 * # Prime Factors
 *
 *   Q. Given a number n. Find its unique prime factors in increasing order.
 *   Ex.
 *      Input : n = 60
 *      Output: [2, 3, 5]
 *      Explanation: Prime factors of 60 are 2, 2, 3, 5. Unique prime factors are 2, 3 and 5.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Math_Prime_Factors {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Prime factors: " + primeFac(n));
    }

    /// Solution (1 ≤ n ≤ 10⁶)
/*---------------------------------------------PreComputation_&_BinarySearch---------------------------------------------
    private final static int[] prime = new int[1000];

    static {
        for (int i = 2; i * i < 1000; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j < 1000; j += i) {
                    prime[j] = 1;
                }
            }
        }
        prime[2] = 1;
        for (int i = 3; i < 1000; i++) {
            prime[i] = (prime[i] == 0) ? 1 : 0;
            prime[i] += prime[i - 1];
        }
    }

    static ArrayList<Integer> primeFac(int n) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();
        int curPrime = 2;

        while (n > 1) {
            if (isPrime(n)) {
                if (list.isEmpty() || list.get(list.size() - 1) != n) list.add(n);
                break;
            }
            while (n % curPrime != 0) curPrime = nextPrime(curPrime);
            if (list.isEmpty() || list.get(list.size() - 1) != curPrime) list.add(curPrime);
            n /= curPrime;
        }

        return list;
    }

    private static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i = nextPrime(i)) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private static int lowerBound(int target) {
        int i = 2, j = 999, ans = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (prime[mid] >= target) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

    private static int nextPrime(int n) {
        return lowerBound(prime[n] + 1);
    }
*/
/*--------------------------------------------------Trial-and-Division--------------------------------------------------*/
    public static ArrayList<Integer> primeFac1(int n) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();

        // for 2
        if (n % 2 == 0) {
            list.add(2);
            while (n % 2 == 0) n /= 2;
        }

        // for every odd number
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                list.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) list.add(n);

        return list;
    }
/*-------------------------------------------PreComputation--&--TrialDivision-------------------------------------------*/
    private final static ArrayList<Integer> primes = new ArrayList<>();

    static {
        boolean[] flag = new boolean[1000];

        for (int i = 2; i * i < 1000; i++) {
            if (!flag[i]) {
                for (int j = i * i; j < 1000; j += i) {
                    flag[j] = true;
                }
            }
        }
        for (int i = 2; i < 1000; i++) {
            if (!flag[i]) primes.add(i);
        }
    }

    public static ArrayList<Integer> primeFac(int n) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();

        for (int prime : primes) {
            if (prime * prime > n) break;
            if (n % prime == 0) {
                list.add(prime);
                while (n % prime == 0) n /= prime;
            }
        }
        if (n > 1) list.add(n);

        return list;
    }
}
