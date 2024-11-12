package LinkedList;/*
 * ## Remove all Occurrences of duplicates in a linked list
 *
 *    Q. Given a sorted linked list, delete all nodes that have duplicate numbers(all occurrences),
 *       leaving  only  numbers  that appear  once in the original list, and return the head of the
 *       modified linked list.
 *     Ex.
 *          Input       : Linked List = 23 —► 28 —► 28 —► 35 —► 49 —► 49 —► 53 —► 5
 *          Output      : 23 35
 *          Explanation : The duplicate numbers are 28, 49 and 53 that are removed from the list.
 */
import java.util.Scanner;

public class L11_Remove_all_Duplicates {

    /// Node Structure
    private static  class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /// Create Node
    private static Node head;
    private static Node tail;
    static void addNode(Node node){
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }
    }

    /// Display List
    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            if (temp.next != null)
                 System.out.print(temp.data + " —► ");
            else System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Linked List :");
        int n = sc.nextInt();
        System.out.println("Elements :");
        Node head = new Node(sc.nextInt());
        addNode(head);
        for (int i = 1;i < n;i++){
            Node a = new Node(sc.nextInt());
            addNode(a);
        }
        System.out.println("Before remove Duplicates :");
        printList(head);
        System.out.println("After Remove Duplicates :");
        head = removeDuplicates(head);
        printList(head);
    }

    /// Solution
    static Node removeDuplicates(Node head) {
        // code here
        Node prev = null;
        Node temp = head;
        while (temp != null){
            int count = 0;
            while (temp.next != null && temp.data == temp.next.data){
                temp = temp.next;
                count++;
            }
            if (count > 0){
                if (prev != null){
                    prev.next = temp.next;
                    temp = prev.next;
                }
                else {
                    head = temp.next;
                    temp = head;
                }
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}