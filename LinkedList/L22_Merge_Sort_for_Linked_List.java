package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-a-linked-list/1
 *
 * # Merge Sort for Linked List
 *
 *   Q. You are given the head of a linked list. You have to sort the given linked list using Merge Sort.
 *    Ex.
 *      Input : 40 -> 20 -> 60 -> 10 -> 50 -> 30
 *      Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60
 *      Explanation: After sorting the given linked list, the resultant list will be:
 *
 *   Constraints:
 *      1 ≤ number of nodes ≤ 105
 *      0 ≤ node->data ≤ 106
 */

import java.util.Scanner;

public class L22_Merge_Sort_for_Linked_List {

    /// Structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        // create a list of input size.
        private static Node createList (int size){
            Scanner sc = new Scanner(System.in);

            System.out.println("Elements: ");
            Node head = new Node(-1);
            Node temp = head;

            for (int i = 0;i < size;i++){
                temp.next = new Node(sc.nextInt());
                temp = temp.next;
            }

            sc.close();
            return head.next;
        }

        // print the current list
        private void printList() {
            Node temp = this;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int n = sc.nextInt();

        Node head = Node.createList(n);

        System.out.print("List before sorting: ");
        head.printList();
        System.out.println();

        Node sort = mergeSort(head);

        System.out.print("List after sorting : ");
        sort.printList();
        System.out.println();
    }

    /// Solution
    static Node mergeSort(Node head) {
        // potd.code.hub
        if (head == null || head.next == null) return head;

        // it returns the middle node and split them as well 
        Node mid = midNode(head);

        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }

    // merge two sorted linked list
    private static Node merge(Node head1, Node head2) {
        Node t1 = head1, t2 = head2;
        Node ans = new Node(-1);
        Node x = ans;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                x.next = t1;
                t1 = t1.next;
            } else {
                x.next = t2;
                t2 = t2.next;
            }
            x = x.next;
        }

        x.next = (t1 == null) ? t2 : t1;

        return ans.next;
    }

    // finding mid node
    private static Node midNode(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;
        Node prev = head;

        // traditional slow-fast pointer approach
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // making prev null to separate two lists then only we can call merge sort on each list
        prev.next = null;

        return slow;
    }
}
