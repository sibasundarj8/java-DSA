package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
 *
 * # Ways to Reach the Nth Stair
 *
 *   Q. There are n stairs, a person standing at the bottom wants to reach the top. The person can
 *      climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the
 *      person can reach the top (order does matter).
 *    Ex.
 *      Input : n = 4
 *      Output: 5
 *      Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1},
 *                                                           {1, 1, 2},
 *                                                           {2, 1, 1},
 *                                                           {1, 2, 1},
 *                                                           {2, 2}.
 */
import java.util.Scanner;

public class GFG_117_Ways_to_Reach_the_Nth_Stair {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number test cases: ");
        int t = sc.nextInt();

        while (t --> 0){
            Solution ob = new Solution();
            System.out.println("Input: ");
            int ans = ob.countWays(sc.nextInt());
            System.out.println("Output: " + ans + "\n");
        }
    }
}
class Solution{
    /// Solution
    private static final long[] freq = new long[45];
    Solution(){
        if (freq[0] == 0){
            freq[0] = 1;
            countWays(44);
        }
    }
    int countWays(int n){
        // potd.code.hub
        if (n == 1 || n == 2) return n;
        if (freq[n] != 0) return (int) freq[n];
        
        // self-work
        freq[n] = countWays(n-1) + countWays(n-2);
        return (int) freq[n];
    }
}
