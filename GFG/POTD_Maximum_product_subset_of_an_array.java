package GFG;/*
 *   Q. Given an array arr. The task is to find and return the maximum product possible
 *      with the subset of elements present in the array.
 *      Note:
 *          1) The maximum product can be a single element also.
 *          2) Since the product can be large, return it modulo 109 + 7.
 *      Example :
 *          Input: arr[] = [-1, 0, -2, 4, 3]
 *          Output: 24
 *          Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
 */
import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Maximum_product_subset_of_an_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        ArrayList<Integer>arr = new ArrayList<>();
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr.add(sc.nextInt());
        System.out.println("Max product :");
        System.out.println(findMaxProduct(arr));
    }
    static long findMaxProduct(ArrayList<Integer> arr) {
        // Code here
        int n = arr.size();
        long prod = 1;
        int mod = 1000000007;
        int zero = 0;
        int neg = 0;
        int min = Integer.MIN_VALUE;
        for (Integer i : arr) {
            if (i == 0) {
                zero++;
                continue;
            } else if (i < 0) {
                prod *= i;
                min = Math.max(min, i);
                neg++;
            } else prod *= i;
            prod %= mod;
        }
        if (arr.isEmpty())return 0;
        if (neg == 1 && neg+zero == n)return 0;
        if (prod < 0)prod/=min;
        return prod;
    }
}
