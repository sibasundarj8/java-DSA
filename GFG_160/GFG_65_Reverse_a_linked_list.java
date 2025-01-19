package GFG_160;/*
 * 
 * https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * 
 * # Reverse a linked list
 * 
 *   Q. Given the head of a linked list, the task is to reverse this list and return the reversed head.
 *    Ex.
 *      Input : head: 1 -> 2 -> 3 -> 4 -> NULL
 *      Output: head: 4 -> 3 -> 2 -> 1 -> NULL
 */
import java.util.Scanner;

public class GFG_65_Reverse_a_linked_list {
    private static final Scanner sc = new Scanner(System.in);

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

        printList(reverseList(head));
    }

    /// Solution
    static Node reverseList(Node head) {
        // code here
        Node prev = null, next;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
