package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/construct-an-array-from-its-pair-sum-array/1
 *
 * # Construct an array from its pair-sum array
 *
 *   Q. Given a pair-sum array arr[] construct the original array. A pair-sum array for an array is the array that contains
 *      sum of all pairs in ordered form, i.e., arr[0] is sum of res[0] and res[1], arr[1] is sum of res[0] and res[2] and
 *      so on.
 *
 *      Note: If the size of original array res[] is n, then the size of pair-sum array arr[] would be n * (n -1) /2. We may
 *            assume that the pair-sum array arr[] is appropriate in size.
 *
 *      Note that, if the original array is correct then the driver code will print true, else false;
 *   Ex.
 *      Input : arr[] = [4, 5, 3]
 *      Output: true
 *      Explanation: A valid original array is [3, 1, 2], pairwise sums are (3 + 1), (3 + 2) and (1 + 2).
 *
 *  Constraints:
 *          1 ≤ n ≤ 10³
 *          1 ≤ arr[i] ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Math_Construct_an_array_from_its_pair_sum_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pair sum array: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Original array of this pair sum array: ");
        System.out.println(constructArr(arr));
    }
    
    /// Solution
    static ArrayList<Integer> constructArr(int[] arr) {
        // potd.code.hub
        ArrayList<Integer> res = new ArrayList<>();
        
        int k = arr.length;
        if (k == 1) {
            res.add(1);
            res.add(arr[0] - 1);
        } else {
            int n = (int) (Math.sqrt(1 + 8 * k) + 1) / 2;   // step - 1
            res.add((arr[0] + arr[1] - arr[n - 1]) / 2);    // step - 2
            for (int i = 1; i < n; i++) {                   // step - 3
                res.add(arr[i - 1] - res.get(0));
            }
        }

        return res;
    }
}
