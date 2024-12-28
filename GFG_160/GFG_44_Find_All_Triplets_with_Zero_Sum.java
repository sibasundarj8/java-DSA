package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-all-triplets-with-zero-sum/0
 *
 * # Find All Triplets with Zero Sum
 *
 *   Q. Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals
 *      to zero.
 *      Returned triplet should also be internally sorted i.e. i<j<k.
 *    Ex.
 *      Input : arr[] = [0, -1, 2, -3, 1]
 *      Output: [[0, 1, 4],
 *               [2, 3, 4]]
 *      Explanation: Triplets with sum 0 are:
 *                  arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
 *                  arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
 */
import java.util.*;

public class GFG_44_Find_All_Triplets_with_Zero_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findTriplets(arr));
    }

    /// Solution
    static List<List<Integer>> findTriplets(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0;i < n;i++){
            for (int j = i+1;j < n;j++){
                int sum = arr[i] + arr[j];
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(temp);
            }
        }

        for (int i = 0;i < n;i++){
            int rem = -arr[i];
            if (map.containsKey(rem)){
                for (List<Integer> l : map.get(rem)){
                    if (l.get(0) == i || l.get(1) == i) continue;
                    List<Integer> temp = Arrays.asList(l.get(0), l.get(1), i);
                    Collections.sort(temp);
                    ans.add(temp);
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
