package LinkedList;

import java.util.Scanner;

public class L8_Separate_Odd_Even_position {
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
        printList(oddEvenList(head));
    }
    static Node oddEvenList(Node head) {
        Node temp = head;
        Node odd = new Node(1);
        Node even  = new Node(0);
        Node t1 = odd,t2 = even;
        int pos = 1;
        while (temp != null){
            Node t = temp.next;
            if (pos%2 == 1){
                t1.next = temp;
                t1 = t1.next;
            }
            else {
                t2.next = temp;
                t2 = t2.next;
            }
            pos++;
            temp = t;
        }
        t1.next = even.next;
        t2.next = null;
        return odd.next;
    }
}