package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
 *
 * # Overlapping Intervals
 *
 *   Q. Given an array of Intervals arr[][], where arr[i] = [start(i), end(i)]. The task is to merge
 *      all the overlapping Intervals.
 *    Ex.
 *      Input : arr[][] = [[1,3],[2,4],[6,8],[9,10]]
 *      Output: [[1,4], [6,8], [9,10]]
 *      Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and 
 *                   [2,4] which on merging will become [1,4]. Therefore, we will return [[1,4], [6,8], 
 *                   [9,10]].
 */
import java.util.*;

public class GFG_24_Overlapping_Intervals {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Intervals: ");
        int n = sc.nextInt();

        int[][]arr = new int[n][2];

        System.out.println("Enter starting time and then ending time of a task: ");
        for (int i = 0;i < n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int[] i : mergeOverlap(arr)){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /// Solution
    static List<int[]> mergeOverlap(int[][] arr) {
        // potd.code.hub
        int n = arr.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = 0;
        int end = arr[0][1];
        while (j < n){
            if (arr[j][0] > end){
                ans.add(new int[]{arr[i][0], end});
                i = j;
            }
            end = Math.max(end, arr[j][1]);
            j++;
        }

        ans.add(new int[]{arr[i][0], end});

        return ans;
    }
}
