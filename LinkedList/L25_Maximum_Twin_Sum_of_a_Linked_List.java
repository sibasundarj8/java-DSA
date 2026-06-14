package LinkedList;/*
 *
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 *
 * # LC. 2130. Maximum Twin Sum of a Linked List
 *
 *   Q. In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of
 *      the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 *        ⎯ For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the
 *           only nodes with twins for n = 4.
 *
 *      The twin sum is defined as the sum of a node and its twin.
 *
 *      Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 *    Ex.
 *      Input : head = [5, 4, 2, 1]
 *      Output: 6
 *      Explanation:
 *              Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 *              There are no other nodes with twins in the linked list.
 *              Thus, the maximum twin sum of the linked list is 6.
 *
 *  Constraints:
 *          The number of nodes in the list is an even integer in the range [2, 10⁵].
 *          1 <= Node.val <= 10⁵
 */

import java.util.Scanner;

public class L25_Maximum_Twin_Sum_of_a_Linked_List {

    /// Structure
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(-1);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.println("Maximum twin sum of the linked list is : ");
        System.out.println(pairSum(head.next));
    }

    /// Solution
    static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxSum = Integer.MIN_VALUE;
        ListNode first = head;
        ListNode last = reverse(slow);

        while (last != null) {
            maxSum = Math.max(maxSum, first.val + last.val);
            first = first.next;
            last = last.next;
        }

        return maxSum;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
