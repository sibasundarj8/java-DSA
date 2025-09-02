package Doubly_Linked_List;/*
 *
 * https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
 *
 * # Reverse a Doubly Linked List
 *
 *   Q. You are given the head of a doubly linked list. You have to reverse the doubly linked list and return
 *      its head.
 *    Ex.
 *      Input : 3 <-> 4 <-> 5
 *      Output: 5 <-> 4 <-> 3
 *      Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
 *
 *   Constraints:
 *      1 ≤ number of nodes ≤ 106
 *      0 ≤ node->data ≤ 104
 */

public class DL3_Reverse_a_Doubly_Linked_List {

    /// Structure
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            Node prev = this;
            StringBuilder ans = new StringBuilder();
            Node temp = this.next;

            ans.append("Front: ").append(this.data);

            while (temp != null) {
                ans.append(" <-> ").append(temp.data);
                prev = temp;
                temp = temp.next;
            }

            ans.append("\n");
            ans.append("Back : ").append(prev.data);
            prev = prev.prev;

            while (prev != null) {
                ans.append(" <-> ").append(prev.data);
                prev = prev.prev;
            }

            ans.append("\n");

            return ans.toString();
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
        };

        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];

        nodes[4].prev = nodes[3];
        nodes[3].prev = nodes[2];
        nodes[2].prev = nodes[1];
        nodes[1].prev = nodes[0];

        System.out.println("Before reverse: \n" + nodes[0]);
        System.out.println("After reverse: \n" + reverse(nodes[0]));
    }

    /// Solution
    static Node reverse(Node head) {
        // potd.code.hub

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (true) {
            // swapping address
            curr.prev = next;
            curr.next = prev;
            if (next == null) break;
            // moving
            prev = curr;
            curr = next;
            next = next.next;
        }

        return curr;
    }
}
