package Priority_Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/tywins-war-strategy0527/1
 *
 * # Tywin's War Strategy
 *
 *   Q. You are given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop.
 *      You are also given an integer k. A troop is considered "lucky" if its number of soldiers is a multiple
 *      of k. Find the minimum total number of soldiers to add across all troops so that at least ⌈n / 2⌉ troops
 *      become lucky.
 *   Ex.
 *      Input : arr = [5, 6, 3, 2, 1]
 *              k = 2
 *      Output: 1
 *      Explanation: By adding 1 soldier for the troop with 1 soldier, we get [5, 6, 3, 2, 2]. Now 3 out of 5
 *                   troops (6, 2, and 2) are multiples of 2 that satisfy the requirement.
 *      Constraints:
 *          1 ≤ arr.size() ≤ 105
 *          1 ≤ k ≤ 105
 *          1 ≤ arr[i] ≤ 105
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ_Tywins_War_Strategy {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements (number of solders in ith troop): ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Minimum solder to make lucky: ");
        System.out.println(minSoldiers(arr, k));
    }

    /// Solution
    static int minSoldiers(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : arr) {
            int required = k - (i % k);
            if (required != k) q.add(required);
        }

        int requiredLuckyTroop = (n + 1) / 2;
        int alreadyLuckyTroops = n - q.size();
        int weNeed = requiredLuckyTroop - alreadyLuckyTroops;

        while (!q.isEmpty() && weNeed > 0) {
            ans += q.poll();
            weNeed--;
        }

        return ans;
    }
}
