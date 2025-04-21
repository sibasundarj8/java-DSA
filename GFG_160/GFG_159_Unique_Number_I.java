package GFG_160;/*
 * 
 * https://www.geeksforgeeks.org/problems/find-unique-number/0
 * 
 * # Unique Number I
 * 
 *   Q. Given an unsorted array arr[] of positive integers having all the numbers occurring exactly 
 *      twice, except for one number which will occur only once. Find the number occurring only once.
 *   Ex.
 *      Input : arr[] = [2, 30, 2, 15, 20, 30, 15]
 *      Output: 20
 *      Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.
 */
import java.util.Scanner;

public class GFG_159_Unique_Number_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: (Every element occurs twice except one)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] arr = new int[n];
        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(findUnique(arr));
    }

    /// Solution
    static int findUnique(int[] arr) {
        // potd.code.hub
        int ans = 0;

        for (int i : arr)
            ans ^= i;

        return ans;
    }
}
