package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/find-h-index--165609/1
 *
 * # Find H-Index
 *
 *   Q. Given an integer array citations[], where citations[i] is the number of citations a researcher
 *      received for the ith paper. The task is to find the H-index.
 *             H-Index is the largest value such that the researcher has
 *             at least H papers that have been cited at least H times.
 *    Ex.
 *      Input: citations[] = [5, 1, 2, 4, 1]
 *      Output: 2
 *      Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. 
 *                   However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
 *
 */

import java.util.Scanner;

public class GFG_22_Find_H_Index {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("number of citations a researcher received for the 'i'th paper: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(hIndex(arr));
    }

    /// Solution
/*
---------------------------------------------------------Sorting---------------------------------------------------------
TC : O(n log n)
SC : O(1)
*/
    static int sorting(int[] citations) {
        // potd.code.hub
        int n = citations.length;

        Arrays.sort(citations);
        reverse(citations, n);

        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= i + 1) return i + 1;
        }

        return 0;
    }

    private static void reverse(int[] arr, int n) {
        int i = 0, j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    /*
    ------------------------------------------------------Binary-Search------------------------------------------------------
    TC : O(n log n)
    SC : O(1)
    */
    static int binarySearch(int[] citations) {
        // potd.code.hub
        int ans = 0;

        int i = 0, j = citations.length;

        //Binary search
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (check(mid, citations)) {
                ans = Math.max(ans, mid);
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int ele, int[] arr) {
        int count = 0;

        for (int i : arr) {
            if (i >= ele) count++;
        }

        return count >= ele;
    }

    /*
    ----------------------------------------------------Difference-Array-----------------------------------------------------
    TC : O(n)
    SC : O(n)
    */
    static int diffArray(int[] citations) {
        // potd.code.hub
        // potd.code.hub
        int n = citations.length;
        int[] dif = new int[n + 1];

        dif[0] = n;

        for (int i : citations) if (i < n) dif[i + 1] -= 1;
        for (int i = 1; i <= n; i++) dif[i] += dif[i - 1];
        for (int i = n; i > 0; i--) if (dif[i] >= i) return i;

        return 0;
    }

    /*
    ----------------------------------------------------Bucket-Count-algo----------------------------------------------------
    TC : O(n)
    SC : O(n)
    */
    static int hIndex(int[] citations) {
        // potd.code.hub
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int x : citations) {
            if (x >= n) count[n]++;
            else count[x]++;
        }

        for (int i = n; i > 0; i--) {
            if (count[i] >= i) return i;
            count[i - 1] += count[i];
        }

        return 0;
    }
}
    
