package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1
 *
 * # Insert in Sorted Circular Linked List
 *
 *   Q. Given a sorted circular linked list, the task is to insert a new node in this circular linked list so
 *      that it remains a sorted circular linked list.
 *    Ex.
 *      Input : head = 1->2->4
 *              data = 2
 *      Output: 1->2->2->4
 *      Explanation: We can add 2 after the second node.
 */
public class L19_Insert_in_Sorted_Circular_Linked_List {
    /// Structure
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
        }

        private void printCircularList() {
            Node temp = this;

            while (temp != null && temp.next != this) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            if ((temp != null) && (temp.next == this)){
                System.out.print(temp.data);
            }
            System.out.println();
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(4)
        };

        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[0];

        int data = 2;

        Node ans = sortedInsert(nodes[0], data);

        ans.printCircularList();
    }

    /// Solution
    static Node sortedInsert(Node head, int data) {
        // potd.code.hub
        Node prev = null,temp = head;
        Node ans = new Node(data);

        do {
            if (temp.data >= data){
                if (prev != null){
                    prev.next = ans;
                    ans.next = temp;
                } else {
                    ans.next = head.next;
                    head.next = ans;

                    int t = head.data;
                    head.data = ans.data;
                    ans.data = t;
                }
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        while (temp != head);

        prev.next = ans;
        ans.next = head;
        return head;
    }
}
