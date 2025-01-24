package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 *
 * # Detect Loop in linked list
 *
 *   Q. You are given the head of a singly linked list. Your task is to determine if the linked list contains
 *      a loop. A loop exists in a linked list if the next pointer of the last node points to any other node
 *      in the list (including itself), rather than being null.
 *
 *      Custom Input format:
 *      A head of a singly linked list and a pos (1-based index) which denotes the position of the node to
 *      which the last node points to. If pos = 0, it means the last node points to null, indicating there
 *      is no loop.
 *    Ex.
 *      Input : head: 1 -> 3 -> 4, pos = 2
 *      Output: true
 *      Explanation: There exists a loop as last node is connected back to the second node.
 */
import java.util.Scanner;

public class GFG_71_Detect_Loop_in_linked_list {
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

        System.out.println("Join last at: ");
        int pos = sc.nextInt();

        Node head = createList(n, pos);
        printList(head);

        System.out.println(detectLoop(head));
    }

    /// Solution
    static boolean detectLoop(Node head) {
        // potd.code.hub
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
