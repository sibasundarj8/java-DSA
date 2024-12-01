package GFG;/*
 *   Q. Given the head of a singly linked list, the task is to rotate the linked list
 *      clockwise by k nodes, i.e., left-shift the linked list by k nodes, where k is
 *      a given positive integer smaller than or equal to length of the linked list.
 *     Examples:
 *          Input: linkedList: 2->4->7->8->9
 *                 k = 3
 *          Output: 8->9->2->4->7
 *          Explanation :
 *                  Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
 *                  Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
 *                  Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
 */
import java.util.Scanner;

public class POTD_Rotate_a_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node head;
    static Node tail;
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
    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            if (temp.next != null)
                System.out.print(temp.data + " -> ");
            else System.out.println(temp.data);
            temp = temp.next;
        }
    }
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
        System.out.println("k : ");
        int k = sc.nextInt();
        printList(rotate(head,k));
    }
    static Node rotate(Node head, int k) {
        // @ potd.code.hub
        Node temp = head;
        Node temp2 = null;
        int n = 0;
        while (temp != null && temp.next != null){
            ++n;
            if (n == k)temp2 = temp;
            temp = temp.next;
        }
        if (k == n+1)return head;
        temp.next = head;
        head = temp2.next;
        temp2.next = null;
        return head;
    }
}