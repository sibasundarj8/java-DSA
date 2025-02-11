package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
 *
 * # Merge K sorted linked lists
 *
 *   Q. Given an array arr[] of n sorted linked lists of different sizes. The task is to merge
 *      them in such a way that after merging they will be a single sorted linked list, then
 *      return the head of the merged linked list.
 *    Ex.
 *      Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
 *      Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
 *      Explanation:
 *             The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
 *             1st list: 1 -> 2-> 3
 *             2nd list: 4 -> 5
 *             3rd list: 5 -> 6
 *             4th list: 7 -> 8
 *             The merged list will be: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
 */
import java.util.*;

public class LinkedList_03_Merge_K_sorted_linked_lists {
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
    private static void printList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /// main Method
    public static void main(String[] args) {
        System.out.println("k: ");
        int n = sc.nextInt();

        List<Node> arr = new ArrayList<>(n);
        for (int i = 0;i < n;i++){
            System.out.println("Size of list: ");
            arr.add(createList(sc.nextInt()));
        }

        printList(mergeKLists(arr));
    }

    /// Solution
    static Node mergeKLists(List<Node> list) {
        // potd.code.hub
        Node ans = new Node(-1);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(h -> h.data));
        q.addAll(list);

        Node t = ans;
        while (!q.isEmpty()){
            t.next = q.poll();
            t = t.next;
            if (t.next != null) q.add(t.next);
        }

        return ans.next;
    }
}
