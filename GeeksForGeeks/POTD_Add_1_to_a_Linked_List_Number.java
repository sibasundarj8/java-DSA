package GFG;

import java.util.Scanner;
public class POTD_Add_1_to_a_Linked_List_Number {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node addOne(Node head) {
        // potd.code.hub
        head = reverse(head);
        Node temp = head,tail = null;
        boolean flag = true;
        while(flag && temp != null) {
            if (temp.data == 9)
                temp.data = 0;
            else {
                temp.data += 1;
                flag = false;
            }
            tail = temp;
            temp = temp.next;
        }
        if (flag)tail.next = new Node(1);

        return reverse(head);
    }
    static Node reverse(Node head){
        Node prev = null,next;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of LinkedList :");
        int n = sc.nextInt();
        System.out.println("Elements :");
        Node arr = new Node(sc.nextInt());
        Node temp = arr;
        for (int i = 1;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        displayList(addOne(arr));
    }
    static void displayList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}