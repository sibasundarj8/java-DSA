package Doubly_Linked_List;/*
 * https://www.geeksforgeeks.org/problems/insert-in-sorted-way-in-a-sorted-dll/1
 *
 * # Insert in Sorted way in a Sorted DLL
 *
 *       Q. Given a sorted doubly linked list and an element x, you need to insert the element x into the correct
 *          position in the sorted Doubly linked list(DLL).
 *         Note: The DLL is sorted in ascending order
 *      Ex.
 *         Input : DLL: 3 ←→ 5 ←→ 8 ←→ 10 ←→ 12
 *                 x = 9
 *         Output: 3 ←→ 5 ←→ 8 ←→ 9 ←→ 10 ←→ 12
 *         Explanation: Here node 9 is inserted in the Doubly Linked-List.
 */
import java.util.Scanner;

public class DL2_Insert_in_Sorted_way_in_a_Sorted_DLL {

    /// Structure
    static class Node{
        int data;
        Node next;
        Node prev;
        Node (int data){
            this.data = data;
        }
    }

    /// Enter Elements
    static Node enterDLL(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        int n = sc.nextInt();
        Node ans = new Node(-1);
        Node temp = ans;
        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            temp.next = new Node(sc.nextInt());
            temp.next.prev = temp;
            temp = temp.next;
        }
        ans = ans.next;
        ans.prev = null;
        return ans;
    }

    /// Print List
    static void printDLL(Node head){
        while (head.next != null){
            System.out.print(head.data + " ←→ ");
            head = head.next;
        }
        System.out.println(head.data);
        while (head.prev != null){
            System.out.print(head.data + " ←→ ");
            head = head.prev;
        }
        System.out.println(head.data);
    }

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = enterDLL();
        System.out.println("X : ");
        int x = sc.nextInt();
        printDLL(sortedInsert (head, x));
    }

    /// Insert at correct Position
    static Node sortedInsert(Node head, int x) {
        // potd.code.hub
        Node t = new Node(x);
        if (head == null) return  t;
        Node temp = head;
        Node pre = null;
        while (temp != null){
            if (temp.prev == null && x <= temp.data){
                t.next = temp;
                temp.prev = t;
                return t;
            }
            else if (x <= temp.data){
                temp.prev.next = t;
                t.next = temp;
                t.prev = temp.prev;
                temp.prev = t;
                return head;
            }
            pre = temp;
            temp = temp.next;
        }
        pre.next = t;
        t.prev = pre;

        return head;
    }
}