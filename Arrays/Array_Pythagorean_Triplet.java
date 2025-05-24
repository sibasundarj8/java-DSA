package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/pythagorean-triplet3018/1
 *
 * # Pythagorean Triplet
 *
 *   Q. Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are
 *      on different indexes) that satisfies a2 + b2 = c2, otherwise return false.
 *    Ex.
 *      Input : arr[] = [3, 2, 4, 6, 5]
 *      Output: true
 *      Explanation: a=3, b=4, and c=5 forms a pythagorean triplet.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Array_Pythagorean_Triplet {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Pythagorean Triplet possible: " + pythagoreanTriplet(arr));
    }

    /// Solution

/**************************************************<---Brute-Force--->**************************************************/
// TC: O(n³)
// SC: O(1)
    private static boolean bf (int[] arr){
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int a = arr[i] * arr[i];
                    int b = arr[j] * arr[j];
                    int c = arr[k] * arr[k];

                    if (a + b == c) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

/**************************************************<---Two-pointer--->**************************************************/
// TC: O(n²)
// SC: O(1)
    private static boolean tp (int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = n-1; i >= 2; i--) {
            int l = 0, r = i-1;

            while (l < r) {
                int a = arr[l] * arr[l];
                int b = arr[r] * arr[r];
                int c = arr[i] * arr[i];

                if (a+b == c) return true;
                else if (a+b < c) l++;
                else r--;
            }
        }

        return false;
    }

/***************************************************<---Optimized--->***************************************************/
// TC: O(maxEle²)
// SC: O(maxEle+1) ~1001
    static boolean pythagoreanTriplet (int[] arr) {
        // code here
        int maxEle = 1000;
        boolean[] freq = new boolean [maxEle+1];

        for (int i : arr){
            freq[i] = true;
        }

        for (int i = 0; i <= maxEle-2; i++) {
            if (!freq[i]) continue;

            for (int j = i+1; j < maxEle-1; j++) {
                if (!freq[j]) continue;

                int a = i*i;    //  a²
                int b = j*j;    //  b²
                int c = a + b;  // ~c²

                int required = (int) Math.sqrt(a + b);

                if (freq[required] && required*required == a+b) {
                    return true;
                }
            }
        }

        return false;
    }
}
