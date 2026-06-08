package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
 *
 * # Delete Nodes with Greater on Right
 *
 *   Q. Given a singly linked list, remove all nodes that have a node with a greater value anywhere to their right in the
 *      list. Return the head of the modified linked list.
 *
 *    Ex.
 *      Input : LinkedList = 12 --> 15 --> 10 --> 11 --> 5 --> 6 --> 2 --> 3
 *      Output: 15 --> 11 --> 6 --> 3
 *      Explanation: Since, 12, 10, 5 and 2 are the elements which have greater elements on the following nodes. So, after
 *                   deleting them, the linked list would like be 15, 11, 6, 3.
 *
 *  Constraints:
 *          1 ≤ size of linked list ≤ 10⁶
 *          1 ≤ element of linked list ≤ 10⁶
 */

import java.util.Scanner;

public class L24_Delete_Nodes_with_Greater_on_Right {

    /// Structure
    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(-1);

        System.out.println("Size of the list: ");
        int size = sc.nextInt();

        System.out.println("Elements: ");
        Node temp = root;

        for (int i = 0; i < size; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }

        System.out.println("List after removing all the elements having greater on right: ");
        Node node = compute(root.next);

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /// Solution
    static Node compute(Node head) {
        // potd.code.hub
        if (head == null || head.next == null) return head;

        Node reversed = reverse(head);
        Node curr = reversed;
        Node next = curr.next;

        while (next != null) {
            if (next.data >= curr.data) {
                curr.next = next;
                curr = curr.next;
            }
            next = next.next;
        }

        curr.next = null;

        return reverse(reversed);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
