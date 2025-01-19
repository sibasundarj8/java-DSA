package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
 *
 * # Rotate a Linked List
 *
 *   Q. Given the head of a singly linked list, your task is to left rotate the linked list k times.
 *    Ex.
 *      Input : head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
 *      Output: 50 -> 10 -> 20 -> 30 -> 40
 *      Explanation:
 *              Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
 *              Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
 *              Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
 *              Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
 */
import java.util.Scanner;

public class GFG_66_Rotate_a_Linked_List {
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
        int n = sc.nextInt();

        Node head = createList(n);

        System.out.println("k: ");
        int k = sc.nextInt();

        printList(rotate(head, k));
    }

    /// Solution
    static Node rotate(Node head, int k) {
        // potd.code.hub
        int size = 1;
        Node temp = head;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        k %= size;
        if (k == 0) return head;
        temp.next = head;
        temp = head;
        for (int i = 1;i < k;i++) temp = temp.next;
        head = temp.next;
        temp.next = null;

        return head;
    }
}
