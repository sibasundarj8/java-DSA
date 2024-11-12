package LinkedList;/*
 * https://www.geeksforgeeks.org/problems/quick-sort-on-linked-list/1
 *
 * # Quick Sort on Linked List
 *
 *      Q. You are given a Linked List. Sort the given Linked List using quicksort.
 *       Ex.
 *          Input: Linked list: 1->9->3->8
 *          Output: 1->3->8->9
 *          Explanation: After sorting the nodes, we have 1, 3, 8 and 9.
 */
import java.util.Scanner;

public class L13_Quick_Sort {
    /// Structure
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    /// Creating Linked List
    static Node elements(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Size:");
        int n = sc.nextInt();
        Node head = new Node(-1);
        Node temp = head;
        System.out.println("Elements:");
        for (int i = 0;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        return head.next;
    }

    /// Printing Elements
     static void printList(Node head){
        while (head != null && head.next != null){
            System.out.print(head.data + " → ");
            head = head.next;
        }
        if (head != null)
            System.out.println(head.data);
    }

    /// Main method
    public static void main(String[] args) {
        Node head = elements();
        head = sort(head);
        printList(head);
    }

    /// Quick sort Algorithm
    static Node sort(Node head){

        // Base Case
        if (head == null || head.next == null){
            return head;
        }

        // Partition
        Node[]left = {null};
        Node[]right = {null};
        partition(head, left, right);

        // Recursive Work
        left[0] = sort(left[0]);
        right[0] = sort(right[0]);

        // Self Work
        Node temp = left[0];
        while (temp != null && temp.next != null){
            temp = temp.next;
        }
        if (temp != null){
            temp.next = head;
        }
        else {
            left[0] = head;
        }
        head.next = right[0];

        return left[0];
    }
    static void partition(Node head, Node[]left, Node[]right){
        Node temp = head.next;
        while (temp != null){
            Node nxt = temp.next;
            if (temp.data <= head.data){
                temp.next = left[0];
                left[0] = temp;
            }
            else {
                temp.next = right[0];
                right[0] = temp;
            }
            temp = nxt;
        }
    }
}