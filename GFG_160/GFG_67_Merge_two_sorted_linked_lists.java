package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 *
 * # Merge two sorted linked lists
 *
 *   Q. Given the head of two sorted linked lists consisting of nodes respectively. The task is to
 *      merge both lists and return the head of the sorted merged list.
 *   Ex.
 *      Input : head1 = 5 -> 10 -> 15 -> 40
 *              head2 = 2 -> 3 -> 20
 *      Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
 */
import java.util.Scanner;

public class GFG_67_Merge_two_sorted_linked_lists {
    static Scanner sc = new Scanner(System.in);

    /// Structure
    private static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    private static Node createList (int size){
        System.out.println("Elements: ");
        Node head = new Node(-1);
        Node temp = head;
        for (int i = 0;i < size;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        return head.next;
    }
    private static void printList (Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /// main Method
    public static void main(String[] args) {
        System.out.println("Size: ");
        Node head1 = createList(sc.nextInt());

        System.out.println("Size: ");
        Node head2 = createList(sc.nextInt());

        printList(sortedMerge(head1, head2));
    }

    /// Solution
    static Node sortedMerge(Node head1, Node head2) {
        // potd.code.hub
        Node ans = new Node(-1);

        Node curr = ans;
        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                curr.next = head1;
                curr = head1;
                head1 = head1.next;
            }
            else {
                curr.next = head2;
                curr = head2;
                head2 = head2.next;
            }
        }
        curr.next = (head1 == null) ? head2 : head1;

        return ans.next;
    }
}
