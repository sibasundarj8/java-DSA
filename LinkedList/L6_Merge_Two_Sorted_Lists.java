package LinkedList;

import java.util.Scanner;

public class L6_Merge_Two_Sorted_Lists {
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
        System.out.println("Size 1 :");
        int n = sc.nextInt();
        System.out.println("Elements 1 :");
        Node head1 = new Node(sc.nextInt());
        Node temp = head1;
        for (int i = 1;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        System.out.println("Size 2 :");
        n = sc.nextInt();
        System.out.println("Elements 2 :");
        Node head2 = new Node(sc.nextInt());
        temp = head2;
        for (int i = 1;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        System.out.println("Output :");
        printList(mergeTwoLists(head1,head2));
    }
    static Node mergeTwoLists(Node head1, Node head2){
        Node t1 = head1,t2 = head2;
        Node temp = new Node(0);
        Node ans = temp;
        while (t1 != null && t2 != null){
            if (t1.data < t2.data){
                temp.next = t1;
                t1 = t1.next;
            }
            else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if (t1 != null) temp.next = t1;
        if (t2 != null) temp.next = t2;
        return ans.next;
    }
}