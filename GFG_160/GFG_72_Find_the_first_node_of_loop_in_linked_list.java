package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
 *
 * # Find the first node of loop in linked list
 *
 *   Q. Given a head of the singly linked list. If a loop is present in the list then return the first
 *      node of the loop else return NULL.
 *
 *      Custom Input format:
 *        A head of a singly linked list and a pos (1-based index) which denotes the position of the
 *        node to which the last node points to. If pos = 0, it means the last node points to null,
 *        indicating there is no loop.
 *    Ex.
 *      Input : 1 3 2 4 5 → ↓
 *                ↑ ← ← ← ← ←
 *      Output: 3
 *      Explanation: We can see that there exists a loop in the given linked list and the first node
 *                   of the loop is 3.
 */

import java.util.Scanner;

public class GFG_72_Find_the_first_node_of_loop_in_linked_list {
    static Scanner sc = new Scanner(System.in);

    /// Structure
    private static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    private static Node createList (int size, int pos){
        System.out.println("Elements: ");
        Node head = new Node(-1);
        int count  = 0;
        Node temp = head, temp1 = null;
        for (int i = 0;i < size;i++){
            count++;
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
            if (count == pos) temp1 = temp;
        }
        temp.next = temp1;
        return head.next;
    }
    private static void printList (Node head){
        Node slow = head, fast = head, tail = null;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                for (slow = head; slow != fast; slow = slow.next){
                    tail = fast;
                    fast = fast.next;
                }
                if (slow == head){
                    tail = slow;
                    while (tail.next != slow) tail = tail.next;
                }
                break;
            }
        }
        slow = head;
        System.out.print("List is: ");
        while (slow != tail){
            System.out.print(slow.data + " ");
            slow = slow.next;
        }
        if (tail != null) System.out.println(tail.data + " -> " + tail.next.data);
        else System.out.println("-> NULL");
    }

    /// main Method
    public static void main(String[] args) {

        System.out.println("Size: ");
        int n = sc.nextInt();

        System.out.println("Last address at position: ");
        int pos = sc.nextInt();

        Node head = createList(n, pos);

        printList(head);
        Node ans = findFirstNode(head);
        System.out.println((ans != null) ? ans.data : "Null");
    }

    /// Solution
    static Node findFirstNode(Node head) {
        // potd.code.hub
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                for (slow = head; slow != fast; slow = slow.next)
                    fast = fast.next;
                return fast;
            }
        }

        return null;
    }
}
