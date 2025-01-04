package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1
 *
 * # Max distance between same elements
 *
 *   Q. Given an array arr[], the task is to find the maximum distance between two occurrences of an
 *      element. If no element has two occurrences, then return 0.
 *    Ex.
 *      Input : arr[] = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
 *      Output: 10
 *      Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2, maximum
 *                   distance for 4 is 10-5 = 5, So max distance is 10.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Hashing_02_Max_distance_between_same_elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(maxDistance(arr));
    }

    /// Solution
    static int maxDistance(int[] arr) {
        // potd.code.hub
        int ans = 0, n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < n;i++){
            map.putIfAbsent(arr[i], i);
            ans = Math.max(ans, i - map.getOrDefault(arr[i], i));
        }

        return ans;
    }
}
