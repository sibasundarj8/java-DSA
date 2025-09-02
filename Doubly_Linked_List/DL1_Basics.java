package Doubly_Linked_List;

public class DL1_Basics {
    static class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){this.data = data;}
    }
    // Display List
    static void printList(Node head){
        Node temp = head;

        // Going to the first Node
        while (temp.prev != null)temp = temp.prev;

        // Display
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Display in reverse manner
    static void printRev(Node tail){
        Node temp = tail;

        // Going to the last Node
        while (temp.next != null)temp = temp.next;

        // Display
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        a. prev = null;
        a. next = b;
        b. prev = a;
        b. next = c;
        c. prev = b;
        c. next = d;
        d. prev = c;
        d. next = e;
        e. prev = d;
        e. next = null;

        printList(c);
        printRev(c);
    }
}