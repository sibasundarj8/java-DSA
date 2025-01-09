package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
 *
 * # Count distinct elements in every window
 *
 *   Q. Given an integer array arr[] and a number k. Find the count of distinct elements in every
 *      window of size k in the array.
 *    Ex.
 *      Input : arr[] = [1, 2, 1, 3, 4, 2, 3]
 *              k = 4
 *      Output: [3, 4, 4, 3]
 *    Explanation:Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
 *              Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
 *              Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
 *              Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GFG_57_Count_distinct_elements_in_every_window {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("K: ");
        int k = sc.nextInt();
        System.out.println(countDistinct(arr, k));
    }

    /// Solution
    static ArrayList<Integer> countDistinct(int[]arr, int k) {
        // potd.code.hub
        int n = arr.length, i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>(k);
        ArrayList<Integer> ans = new ArrayList<>(n);

        while (j < n){
            if (j >= k){
                ans.add(map.size());
                if (map.get(arr[i]) <= 1) map.remove(arr[i]);
                else map.put(arr[i], map.get(arr[i])-1);
                i++;
            }
            map.put(arr[j], map.getOrDefault(arr[j++], 0)+1);
        }
        ans.add(map.size());

        return ans;
    }
}
