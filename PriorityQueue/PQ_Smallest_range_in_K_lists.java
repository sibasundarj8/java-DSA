package Priority_Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1
 *
 * # Smallest range in K lists
 *
 *   Q. Given a 2d integer array arr[][] of size k*n, where each row is sorted in ascending order. Your task is
 *      to find the smallest range [l, r] that includes at least one element from each of the k lists. If more
 *      than one such ranges are found, return the first one.
 *    Ex.
 *      Input : n = 5
 *              k = 3
 *              arr[][] = [[4,  7,  9, 12, 15],
 *                         [0,  8, 10, 14, 20],
 *                         [6, 12, 16, 30, 50]]
 *      Output: [6, 8]
 *      Explanation: Smallest range is formed by  number 7 from the first list, 8 from second list and 6 from
 *                   the third list.
 */


import java.util.*;

public class PQ_Smallest_range_in_K_lists {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("n: ");
        int n = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        int[][] arr = new int[k][n];

        System.out.println("Enter " + k + " rows containing " + n + " elements:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextByte();
            }
        }

        System.out.println("Smallest range in k list: " + findSmallestRange(arr));
    }

    /// Solution
    static ArrayList<Integer> findSmallestRange(int[][] arr) {
        // potd.code.hub
        int k = arr.length;
        int n = arr[0].length;
        int max = arr[0][0];
        int min = arr[0][0];
        ArrayList<Integer> ans;

        // enter k arrays {row, col, value}, compare the values
        PriorityQueue<int[]> q = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[2]));

        // inserting first k elements
        for (int i = 0; i < k; i++) {
            int[] temp = {i, 0, arr[i][0]};
            q.offer(temp);
            max = Math.max(max, arr[i][0]);
            min = Math.min(min, arr[i][0]);
        }

        // first answer range (min, max)
        ans = new ArrayList<>(List.of(min, max));

        // getting range, its k-pointer approach (eg. two-pointer)
        while (!q.isEmpty() && q.peek()[1] < n-1){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int[] temp = {r, c+1, arr[r][c+1]};
            q.poll();
            q.offer(temp);
            min = q.peek()[2];
            max = Math.max(max, arr[r][c+1]);
            if (max-min < ans.get(1)-ans.get(0)){
                ans.set(0, min);
                ans.set(1, max);
            }
        }

        return ans;
    }
}
