package LinkedList;

import java.util.Scanner;

public class L05_delete_Middle_Element {
    static class Node{
        int data;
        Node next;
        Node(int data){this.data = data;}
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
        System.out.println("Size :");
        int n = sc.nextInt();
        System.out.println("Elements :");
        Node head = new Node(sc.nextInt());
        Node temp = head;
        for (int i = 1;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        System.out.println("Output :");
        printList(deleteMiddle(head));
    }
    static Node deleteMiddle(Node head) {
        Node slow = head,fast = head,prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
