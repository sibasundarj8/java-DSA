package LinkedList;
/*
 * #Split Linked List Alternatively
 *
 * Q. Given a singly linked list's head. Your task is to complete the function alternatingSplitList()
 *    that splits the given linked list into two smaller lists. The subLists should be made from
 *    alternating elements from the original list.
 *
 *    Note:
 *          The sublist should be in the order with respect to the original list.
 *          Your have to return an array containing the both sub-linked lists.
 *   Example.
 *      Input : LinkedList = 2 —► 5 —► 8 —► 9 —► 6
 *      Output: 2 —► 8 —► 6
 *              5 —► 9
 *      Explanation: After forming two subLists of the given list as required, we have two lists
 *                   as: 2 —► 8 —► 6 and 5 —► 9.
 */
import java.util.Scanner;

public class L9_Split_Linked_List_Alternatively {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        Node head = new Node(-1);

        System.out.println("Elements: ");
        Node temp = head;
        for (int i = 0;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        head = head.next;

        for (Node h : alternatingSplitList(head)){
            printList(h);
        }
    }
    static Node[] alternatingSplitList(Node head) {
        // potd.code.hub
        Node temp = head;
        Node temp2 = new Node(-1);
        Node head2 = temp2;

        while (temp != null && temp.next != null){
            temp2.next = temp.next;
            temp.next = temp.next.next;
            temp2 = temp2.next;
            temp = temp.next;
        }

        temp2.next = null;
        head2 = head2.next;

        return new Node[]{head, head2};
    }
    static void printList(Node head){
        if (head == null)return;
        // Display
        while (head.next != null){
            System.out.print(head.data + " —► ");
            head = head.next;
        }
        System.out.println(head.data);
    }
}