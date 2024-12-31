package LinkedList;

import java.util.Scanner;

public class L04_Reverse_Linked_List {
    static class Node {
        int data;
        Node next;
        Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size :");
        int n = sc.nextInt();

        System.out.println("Enter Elements :");
        Node head = new Node(sc.nextInt());
        Node temp = head;
        for (int i = 1;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }

        System.out.println("Reversed :");
        head = reverseList(head);
        printList(head);
        System.out.println("Reverse recursively :");
        head = revRecursion(head);
        printList(head);
    }
    static Node reverseList(Node head) {    // iterative method
        // potd.code.hub
        Node next,prev = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    static Node revRecursion(Node head){    // recursive Work
        // base Case
        if (head.next == null)return head;
        // recursive Work
        Node newNode = revRecursion(head.next);
        // self-work
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
