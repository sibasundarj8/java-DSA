package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 *
 * # LC. 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 *
 *   Q. A critical point in a linked list is defined as either a local maxima or a local minima.
 *
 *      A node is a local maxima if the current node has a value strictly greater than the previous node and the
 *      next node.
 *
 *      A node is a local minima if the current node has a value strictly smaller than the previous node and the
 *      next node.
 *
 *      Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
 *
 *      Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance
 *      is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between
 *      any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
 *
 *    Ex.
 *      Input : head = [5, 3, 1, 2, 5, 1, 2]
 *      Output: [1, 3]
 *      Explanation: There are three critical points:
 *                      - [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
 *                      - [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
 *                      - [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
 *                   The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
 *                   The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
 *
 *  Constraints:
 *        ◦ The number of nodes in the list is in the range [2, 10⁵].
 *        ◦ 1 <= Node.val <= 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points {

    /// Structure
    private static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements of linked list: ");
        String[] s = sc.nextLine().split(" ");

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        for (String ele : s) {
            temp.next = new ListNode(Integer.parseInt(ele));
            temp = temp.next;
        }

        head = head.next;

        System.out.println("Minimum and maximum distance between two critical points: ");
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }

    /// Solution
    static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int idx = 1;
        int prvCriticalPoint = -1;
        int firstCriticalPoint = -1;
        int[] res = {Integer.MAX_VALUE, -1};
        ListNode prv = head;
        ListNode cur = head.next;

        while (cur.next != null) {
            int curVal = cur.val;
            int prvVal = prv.val;
            int nxtVal = cur.next.val;

            if ((prvVal > curVal && curVal < nxtVal) || (prvVal < curVal && curVal > nxtVal)) {
                if (firstCriticalPoint == -1) firstCriticalPoint = idx;
                if (prvCriticalPoint != -1) res[0] = Math.min(res[0], idx - prvCriticalPoint);
                prvCriticalPoint = idx;
            }

            idx++;
            prv = cur;
            cur = cur.next;
        }

        if (res[0] == Integer.MAX_VALUE) res[0] = -1;
        if (firstCriticalPoint != prvCriticalPoint) res[1] = prvCriticalPoint - firstCriticalPoint;

        return res;
    }
}
