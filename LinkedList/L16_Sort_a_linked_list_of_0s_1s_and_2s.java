package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 *
 * # Sort a linked list of 0's, 1's and 2's
 *
 *   Q. Given the head of a linked list where nodes can contain values 0's, 1's, and 2's only.
 *      Your task is to rearrange the list so that all 0s appear at the beginning, followed by
 *      all 1s, and all 2s are placed at the end.
 *   Ex.
 *      Input : head = 2 → 2 → 0 → 1
 *      Output: ans = 0 → 1 → 2 → 2
 *      Explanation: After arranging all the 0's, 1's and 2's in the given format, the output
 *                   will be 0 → 1 → 2 → 2.
 */
public class L16_Sort_a_linked_list_of_0s_1s_and_2s {

    /// Structure
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {new Node(2),
                        new Node(2),
                        new Node(0),
                        new Node(1)};

        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];

        printList(segregate(nodes[0]));
    }
    // print a linked-list
    private static void printList(Node node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        Node temp = node;

        while (temp.next != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    /// Solution
    static Node segregate(Node head) {
        // potd.code.hub
        Node[] ans = {new Node(-1),
                      new Node(-1),
                      new Node(-1)};

        Node temp  = head;
        Node temp0 = ans[0];
        Node temp1 = ans[1];
        Node temp2 = ans[2];

        while (temp != null){
            int data = temp.data;
            switch (data){
                case 0 -> {
                    temp0.next = new Node(0);
                    temp0 = temp0.next;
                }
                case 1 -> {
                    temp1.next = new Node(1);
                    temp1 = temp1.next;
                }
                case 2 -> {
                    temp2.next = new Node(2);
                    temp2 = temp2.next;
                }
            }
            temp = temp.next;
        }
        
        temp0.next = (ans[1].next == null) ? ans[2].next : ans[1].next;
        temp1.next = ans[2].next;
        temp2.next =null;

        return ans[0].next;
    }
}
