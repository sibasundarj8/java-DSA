package GFG;
/*
 *   Q. Given an unsorted array of integers arr[], and a target tar, determine the number of
 *      sub-arrays whose elements sum up to the target value.
 *  Examples:
 *          Input: arr[] = [10, 2, -2, -20, 10]
 *                 tar = -10
 *          Output: 3
 *          Explanation: Sub-arrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and
 *                       [-20, 10].
 */
import java.util.HashMap;
import java.util.Scanner;

public class POTD_SubArray_range_with_given_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int tar = sc.nextInt();

        System.out.println(subArraySum(arr, tar));
    }
    static int subArraySum(int[]arr, int tar) {
        // potd.code.hub
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> bag = new HashMap<>();

        for (int i : arr){
            sum += i;
            if (sum == tar) ans++;
            if (bag.get(sum-tar) != null) ans += bag.get(sum-tar);
            bag.put(sum, bag.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}