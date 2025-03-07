package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/find-prime-numbers-in-a-range4718/1
 *
 * # Find Prime numbers in a range
 *
 *   Q. Given two integers M and N, generate all primes between M and N including M and N.
 *
 *    Ex.
 *      Input : m = 1, n = 10
 *      Output: 2 3 5 7
 *      Explanation: The prime numbers between 1 and 10 are 2,3,5 and 7.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Find_Prime_numbers_in_a_range {

    /// main Method
    public static void main(String[] args) {
        int[][]arr = {{1, 21}, {30, 60}, {70, 100}, {150, 190}};
        for (int[]i : arr){
            int n = i[0];
            int m = i[1];
            Solution ob = new Solution();
            System.out.println(ob.primeRange(n, m));
        }
    }
}
class Solution {
    private static final int[] arr = new int[(int)(Math.pow(10,6)+1)];
    Solution(){
        int n = arr.length;
        if (arr[0] == 0){
            Arrays.fill(arr, 1);
            for (int i = 2;i < n;i++) {
                if (arr[i] == 1) {
                    for (long j = (long) i * i; j < n; j += i) {
                        arr[(int) j] = 0;
                    }
                }
            }
        }
    }
    ArrayList<Integer> primeRange(int m, int n) {
        // potd.code.hub
        ArrayList<Integer> list = new ArrayList<>();
        for (;m <= n;m++) {
            if (m < 2) continue;
            if (arr[m] == 1)
                list.add(m);
        }

        return list;
    }
}
