package LinkedList;/*
 *
 * https://leetcode.com/problems/rotate-list/
 *
 * # 61. Rotate List
 *
 *   Q. Given the head of a linked list, rotate the list to the right by k places.
 *    Ex.
 *      Input : head = [1, 2, 3, 4, 5], k = 2
 *      Output: [4, 5, 1, 2, 3]
 *      Explanation:
 *                  Original: 1 -> 2 -> 3 -> 4 -> 5
 *                  Rotate 1: 5 -> 1 -> 2 -> 3 -> 4
 *                  Rotate 2: 4 -> 5 -> 1 -> 2 -> 3
 *
 *  Constraints:
 *      The number of nodes in the list is in the range [0, 500].
 *      -100 <= Node.val <= 100
 *      0 <= k <= 2 * 10⁹
 */

import java.util.Scanner;

public class L23_Rotate_List {

    /// Structure
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the list elements: ");
        String[] s = sc.nextLine().split(" ");

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        for (String string : s) {
            temp.next = new ListNode(Integer.parseInt(string));
            temp = temp.next;
        }

        System.out.print("k : ");
        int k = sc.nextInt();

        head = rotateRight(head.next, k);
        temp = head;
        int n = s.length;

        System.out.println("Rotated list is: ");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
            if (n-- <= 0) break;
        }
    }

    /// Solution
    static ListNode rotateRight(ListNode head, int k) {
        // potd.code.hub
        if (head == null || head.next == null) return head;

        int len = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = head;

        while (end.next != null) {
            len++;
            end = end.next;
        }

        k %= len;
        if (k == 0) return head;

        k = len - k;
        ListNode newTail = dummy;

        while (k-- > 0) {
            newTail = newTail.next;
        }

        end.next = dummy.next;
        dummy.next = newTail.next;
        newTail.next = null;

        return dummy.next;
    }
}
