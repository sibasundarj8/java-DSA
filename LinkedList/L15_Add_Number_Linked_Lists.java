package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 *
 * # Add Number Linked Lists
 *
 *   Q. Given two numbers, num1, and num2, represented by linked lists. The task is to return the head of the
 *      linked list representing the sum of these two numbers.
 *
 *      For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by
 *      2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null.
 *      You are required to return the head of the linked list 2->1->5->null.
 *
 *      Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the
 *            output list.
 *    Ex.
 *      Input : num1 = 45 (4->5->null)
 *              num2 = 345 (3->4->5->null)
 *      Output: 3 -> 9 -> 0 -> null
 * Explanation: For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant
 *              linked list will be (3 9 0).
 *                       4 -> 5 -> null
 *                  3 -> 4 -> 5 -> null
 *            sum : 3 -> 9 -> 0 -> null
 */
import java.util.Scanner;

public class L15_Add_Number_Linked_Lists {
    /// Structure
    private static class Node{
        int data;
        Node next;
        public Node (int data){
            this.data = data;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of num1: ");
        int n = sc.nextInt();

        Node num1 = new Node(0);

        System.out.println("Elements of num1: ");
        Node temp = num1;
        for (int i = 0;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        num1 = num1.next;

        System.out.println("Size of num2: ");
        n = sc.nextInt();

        Node num2 = new Node(0);

        System.out.println("Elements of num2: ");
        temp = num2;
        for (int i = 0;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        num2 = num2.next;

        printList(addTwoLists(num1, num2));
    }
    // print List
    private static void printList(Node node){
        for (Node temp = node;temp != null;temp = temp.next){
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    /// Solution
    static Node addTwoLists(Node num1, Node num2) {
        // potd.code.hub
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = new Node(0);
        Node temp = sum;
        int carry = 0;
        while (num1 != null || num2 != null){
            int n = num1 != null ? num1.data : 0;
            int m = num2 != null ? num2.data : 0;
            int add = n + m + carry;
            temp.next = new Node(add % 10);
            temp = temp.next;
            carry = add / 10;
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        if (carry != 0) temp.next = new Node(carry);
        sum = reverse(sum.next);

        while (sum != null && sum.data == 0) sum = sum.next;

        return sum;
    }
    // reverse List
    private static Node reverse(Node head){
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
