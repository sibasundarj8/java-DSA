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
    static int hIndex(int[]citations) {
        // potd.code.hub
        int n = citations.length;
        int[]map = new int[n];

        for (int i : citations){
            if (i >= n) map[n-1]++;
            else if (i > 0) map[i-1]++;
        }

        int count = 0;
        for (int i = n-1;i >= 0;i--){
            count += map[i];
            if (count > i) return i+1;
        }

        return 0;
    }
}
