/*
 *   Q. Given the head of a linked list and the number k, Your task is to find the kth node from the end.
 *      If k is more than the number of nodes, then the output should be -1.
 *    Ex.
 *      Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
 *      Output: 8
 *      Explanation: The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from the end is 8.
 */
package LinkedList;


import java.util.Scanner;

public class L3_Kth_from_End_of_Linked_List {
    static  class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node head;
    static Node tail;
    static void addNode(Node node){
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Linked List :");
        int n = sc.nextInt();
        System.out.println("Elements :");
        Node head = new Node(sc.nextInt());
        addNode(head);
        for (int i = 1;i < n;i++){
            Node a = new Node(sc.nextInt());
            addNode(a);
        }
        System.out.println("Enter k :");
        int k = sc.nextInt();
        System.out.println("Output :");
        System.out.println(getKthFromLast(head,k));
    }
    static int getKthFromLast(Node head, int k) {
        // potd.code.hub
        if(k == 0)return -1;
        Node temp = head;
        Node ans = head;
        while (temp != null && k  != 0) {
            temp = temp.next;
            k--;
        }
        if (temp == null && k != 0) return -1;
        while (temp != null){
            temp = temp.next;
            ans = ans.next;
        }
        return ans.data;
    }
}
