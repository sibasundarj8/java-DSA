package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 *
 * # Add Number Linked Lists
 *
 *   Q. Given the head of two singly linked lists num1 and num2 representing two non-negative integers.
 *      The task is to return the head of the linked list representing the sum of these two numbers.
 *
 *      For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by
 *      the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.
 *
 *      Note: There can be leading zeros in the input lists, but there should not be any leading zeros
 *            in the output list.
 *    Ex.
 *      Input : num1 = 4 - > 5
 *              num2 = 3 -> 4 -> 5
 *      Output: 3 -> 9 -> 0
 *      Explanation: Given numbers are 45 and 345. There sum is 390.
 */
import java.util.Scanner;

public class GFG_69_Add_Number_Linked_Lists {
    static Scanner sc = new Scanner(System.in);

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
    private static void printList (Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /// main Method
    public static void main(String[] args) {

        System.out.println("Size: ");
        Node node1 = createList(sc.nextInt());

        System.out.println("Size: ");
        Node node2 = createList(sc.nextInt());

        printList(addTwoLists(node1, node2));
    }

    /// Solution
    static Node addTwoLists(Node num1, Node num2) {
        // potd.code.hub
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        Node ans = new Node(-1);
        Node res = ans;

        int carry = 0;
        while (num1 != null || num2 != null){
            int n1 = (num1 != null) ? num1.data : 0;
            int n2 = (num2 != null) ? num2.data : 0;
            carry += n1 + n2;
            ans.next = new Node(carry%10);
            ans = ans.next;
            carry /= 10;
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        ans.next = new Node(carry);

        res = reverseList(res.next);
        while (res != null && res.next != null && res.data == 0)
            res = res.next;

        return res;
    }
    private static Node reverseList(Node head) {
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
