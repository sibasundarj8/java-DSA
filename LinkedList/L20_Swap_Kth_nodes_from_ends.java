package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/swap-kth-node-from-beginning-and-kth-node-from-end-in-a-singly-linked-list/1
 *
 * # Swap Kth nodes from ends
 *
 *   Q. Given the head of a singly linked list and an integer k. Swap the kth node (1-based index) from the
 *      beginning and the kth node from the end of the linked list. Return the head of the final formed list
 *      and if it's not possible to swap the nodes return the original list.
 *   Ex.
 *      Input : k = 1
 *              1 -> 2 -> 3 -> 4 -> 5
 *      Output: 5 -> 2 -> 3 -> 4 -> 1
 *      Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will
 *                   be 5 -> 2 -> 3 -> 4 -> 1.
 *   Constraints:
 *          1 ≤ list size ≤ 104
 *          1 ≤ node->data ≤ 106
 *          1 ≤ k ≤ 104
 */

public class L20_Swap_Kth_nodes_from_ends {

    /// Structure
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder ans = new StringBuilder();
            Node temp = this.next;

            ans.append(this.data);

            while (temp != null) {
                ans.append(" -> ").append(temp.data);
                temp = temp.next;
            }

            return ans.toString();
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {new Node(1), new Node(2), new Node(3), new Node(4), new Node(5),};

        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];

        int k = 4;

        System.out.println("Before swap: " + nodes[0]);
        System.out.println("After swap : " + swapKth(nodes[0], k));
    }

    ///  Solution
    static Node swapKth(Node head, int k) {
        // potd.code.hub
        Node f, l, node;
        node = l = head;

        for (int i = 1; i < k; i++) {
            node = node.next;
            if (node == null) return head;
        }

        f = node;

        while (node.next != null) {
            l = l.next;
            node = node.next;
        }

        int temp = f.data;
        f.data = l.data;
        l.data = temp;

        return head;
    }
}
