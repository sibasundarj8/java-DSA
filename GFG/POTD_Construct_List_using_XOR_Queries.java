package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/construct-list-using-given-q-xor-queries/1
 *
 * # Construct List using XOR Queries
 *   Q. There is an array that initially contains only a single value, 0.
 *
 *      Given a list of queries[][] of size q, where each query is of one of the following types:
 *        ◦ 0 x: Insert x into the array.
 *        ◦ 1 x: Replace every element 'a' in the array with a ^ x, where ^ denotes the bitwise XOR operator.
 *
 *      Return the array in sorted order after performing all the queries.
 *
 *    Ex.
 *      Input : q = 5,
 *              queries[] = [[0, 6],
 *                           [0, 3],
 *                           [0, 2],
 *                           [1, 4],
 *                           [1, 5]]
 *      Output: [1, 2, 3, 7]
 *      Explanation:
 *              [0] (initial value)
 *              [0, 6] (add 6 to list)
 *              [0, 6, 3] (add 3 to list)
 *              [0, 6, 3, 2] (add 2 to list)
 *              [4, 2, 7, 6] (XOR each element by 4)
 *              [1, 7, 2, 3] (XOR each element by 5)
 *              The sorted list after performing all the queries is [1, 2, 3, 7].
 *
 *  Constraints:
 *      1 ≤ q ≤ 10⁵
 *      0 ≤ x ≤ 10⁹
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class POTD_Construct_List_using_XOR_Queries {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();
        int[][] queries = new int[q][2];

        System.out.print("""
                Enter queries:
                  ◦ 0  x : Insert x into the array.
                  ◦ 1  x : Replace every element a in the array with a ^ x, where ^ denotes the bitwise XOR operator.
                """);
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        System.out.println("The array in sorted order after performing all the queries: ");
        System.out.println(constructList(queries));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Difference-array--using-deque-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(q log q)
SC : O(q)
*/
    static ArrayList<Integer> approach_1(int[][] queries) {
        // potd.code.hub
        int q = queries.length;
        ArrayList<Integer> list = new ArrayList<>(q + 1);
        ArrayDeque<Integer> dq = new ArrayDeque<>(2 * q + 1);

        dq.add(0);

        for (int[] query : queries) {
            if (query[0] == 0) dq.addLast(query[1]);
            else {
                if (query[1] == 0) continue;
                dq.addFirst(-query[1]);
                dq.addLast(-query[1]);
            }
        }

        int xor = 0;
        while (!dq.isEmpty()) {
            int val = dq.pollFirst();

            if (val < 0) xor ^= (val * -1);
            else list.add(val ^ xor);
        }

        list.sort(null);
        return list;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--reverse-traversal-+-cumulative-sum--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(q log q)
SC : O(1) excluding answer list
*/
    static ArrayList<Integer> constructList(int[][] queries) {
        // potd.code.hub
        int q = queries.length;
        int xor = 0;
        ArrayList<Integer> list = new ArrayList<>(q + 1);

        for (int i = q - 1; i >= 0; i--) {
            int[] query = queries[i];
            if (query[0] == 0) list.add(query[1] ^ xor);
            else xor ^= query[1];
        }

        list.add(xor);

        list.sort(null);
        return list;
    }
}
