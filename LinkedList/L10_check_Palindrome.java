package LinkedList;

import java.util.Scanner;

public class L10_check_Palindrome {
    static class Node {
        int data;
        Node next;
        Node (int data){this.data = data;}
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
        System.out.println("Output :");
        System.out.println(check(head));
    }
    static boolean check(Node head){
        Node mid = middleList(head);
        mid.next = reverseList(mid.next);
        mid = mid.next;
        while(mid != null){
            if (head.data != mid.data)return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
    static Node middleList(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            if (fast.next.next == null)break;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node reverseList(Node head){
        Node next,prev = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}