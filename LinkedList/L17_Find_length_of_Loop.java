package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/find-length-of-loop/1
 *
 * # Find length of Loop
 *
 *       Q. Given the head of a linked list, determine whether the list contains a loop. If a loop is
 *          present, return the number of nodes in the loop, otherwise return 0.
 *
 *          Note: 'c' is the position of the node which is the next pointer of the last node of the
 *                linked-list. If c is 0, then there is no loop.
 *      Ex. Input : head: 1 → 2 → 3 → 4 → 5
 *                  c = 2
 *                                      1 -> 2 -> 3
 *                                           ↑    ↓
 *                                           5 <- 4
 *          Output: 4
 *          Explanation: There exists a loop in the linked list and the length of the loop is 4.
 *
 */

public class L17_Find_length_of_Loop {

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
        Node[] nodes = {new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)};
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        nodes[4].next = nodes[1];

        System.out.println("Number of cycle nodes: " + lengthOfLoop(nodes[0]));
    }

    /// Solution
    static int lengthOfLoop(Node head) {
        // potd.code.hub
        int count = 0;

        Node slow = head;
        Node fast = head;

        // finding the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                count = 1;

                // ccounting the length of loop
                while (slow.next != fast) {
                    count++;
                    slow = slow.next;
                }

                break;
            }
        }

        return count;
    }
}
