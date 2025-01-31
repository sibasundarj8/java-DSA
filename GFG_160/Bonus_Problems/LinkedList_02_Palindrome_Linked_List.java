package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 *
 * # Palindrome Linked List
 *
 *   Q. Given a head singly linked list of positive integers. The task is to check if the
 *      given linked list is palindrome or not.
 *    Ex.
 *      Input : head: 1 -> 2 -> 1 -> 1 -> 2 -> 1
 *      Output: true
 *      Explanation: The given linked list is 1 -> 2 -> 1 -> 1 -> 2 -> 1 , which is a
 *                   palindrome and Hence, the output is true.
 */

import java.util.Scanner;

public class LinkedList_02_Palindrome_Linked_List {
    private static final Scanner sc = new Scanner(System.in);

    /// Structure
    private static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }
    private static Node createList (int size){
        System.out.println("Elements: ");
        Node head = new Node(-1);
        Node temp = head;
        for (int i = 0;i < size;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        return head.next;
    }

    /// main Method
    public static void main(String[] args) {

        System.out.println("Size: ");
        Node head = createList(sc.nextInt());

        System.out.println(isPalindrome(head));
    }

    /// Solution
    static boolean isPalindrome(Node head) {
        // potd.code.hub
        Node mid = midNode(head);
        mid = reverseList(mid.next);
        while (mid != null){
            if (head.data != mid.data) return false;
            head = head.next;
            mid = mid.next;
        }

        return true;
    }
    private static Node midNode(Node head){
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node reverseList(Node head){
        Node prev = null, next;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
