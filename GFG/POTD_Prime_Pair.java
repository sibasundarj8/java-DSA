package GFG;/*
 *   Q. Given a number n, find out if n can be expressed as a+b, where both a and b
 *      are prime numbers. If such a pair exists, return the values of a and b,
 *      otherwise return [-1,-1] as an array of size 2.
 *   Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d,
 *         and a < c then  [a, b] is considered as our answer.
 *
 *      Ex.      Input: n = 10
 *              Output: 3 7
 *         Explanation: There are two possibilities 3,7 & 5,5 are both prime & their sum is 10,
 *                      but we'll pick 3,7  as  3 < 5.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Prime_Pair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number :");
        int n = sc.nextInt();
        System.out.println(getPrimes(n));
    }
    static boolean isPrime(int n){
        if (n >= 2) {
            for (int i = 2; i*i <= n; i++) if (n % i == 0) return false;
            return true;
        }
        return false;
    }
    static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (isPrime(n-2)){
            ans.add(2);
            ans.add(n-2);
            return ans;
        }
        if (n%2 != 0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        for (int i = 3;i <= n/2;i+=2)
            if (isPrime(i) && isPrime(n-i)){
                ans.add(i);
                ans.add(n-i);
                return ans;
            }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
}