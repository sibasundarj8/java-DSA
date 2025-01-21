package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 *
 * # Linked List Group Reverse
 *
 *   Q. Given the head a linked list, the task is to reverse every k node in the linked list.
 *      If the number of nodes is not a multiple of k then the left-out nodes in the end, should be
 *      considered as a group and must be reversed.
 *    Ex.
 *      Input : head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8
 *              k = 4
 *      Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
 *      Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and
 *                   then the next 4 elements 5, 6, 7, 8. Hence,
 *                   the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
 */
import java.util.Scanner;

public class GFG_68_Linked_List_Group_Reverse {
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
        System.out.println("Enter Size: ");
        Node head = createList(sc.nextInt());

        System.out.println("k:");
        int k = sc.nextInt();
        sc.close();

        printList(reverseKGroup(head, k));
    }

    /// Solution
    static Node reverseKGroup(Node head, int k) {
        // potd.code.hub
        Node[] ans = reverseList(head, k);
        Node temp = ans[1];
        int count = 1;
        while (temp != null){
            if (count % k == 0){
                Node[]x = reverseList(temp.next, k);
                temp.next = x[0];
                temp = x[1];
            }
            count++;
        }

        return ans[0];
    }
    private static Node[] reverseList(Node head, int k) {
        Node temp = head, prev = null, next;
        while (temp != null && k > 0){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            k--;
        }
        if (head != null) head.next = temp;
        return new Node[]{prev, head};
    }
}
