package GFG;/*
 * # Sort a k sorted doubly linked list
 *
 *   Q. Given a doubly linked list, each node is at most k-indices away from its target position.
 *      The problem is to sort the given doubly linked list. The distance can be assumed in either
 *      of the directions (left and right).
 *    Ex.
 *      Input : Doubly Linked List : 3 ←→ 2 ←→ 1 ←→ 5 ←→ 6 ←→ 4
 *              k = 2
 *      Output: 1 ←→ 2 ←→ 3 ←→ 4 ←→ 5 ←→ 6
 *              6 ←→ 5 ←→ 4 ←→ 3 ←→ 2 ←→ 1
 */
import java.util.*;

public class POTD_Sort_a_k_sorted_doubly_linked_list {
    static class DLLNode{
        int data;
        DLLNode next;
        DLLNode prev;
        DLLNode(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        DLLNode head = enterDLL(sc.nextInt());
        System.out.println("K: ");
        int k = sc.nextInt();
        printDLL(sortAKSortedDLL(head,k));
    }
    static DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // potd.code.hub
        if (head == null || head.next == null) return head;
        Queue<DLLNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        int i = 0;
        while (head != null && i <= k){
            q.add(head);
            head = head.next;
            i++;
        }
        DLLNode ans = null;
        DLLNode curr = null;
        while (!q.isEmpty()){
            if (ans == null){
                ans = q.remove();
                ans.prev = null;
                curr = ans;
            }
            else {
                curr.next = q.remove();
                curr.next.prev = curr;
                curr = curr.next;
            }
            if (head != null){
                q.add(head);
                head = head.next;
            }
        }
        assert curr != null;
        curr.next = null;
        return ans;
    }
    static DLLNode enterDLL(int size){
        Scanner sc = new Scanner(System.in);
        DLLNode ans = new DLLNode(-1);
        DLLNode temp = ans;
        System.out.println("Elements: ");
        for (int i = 0;i < size;i++){
            temp.next = new DLLNode(sc.nextInt());
            temp.next.prev = temp;
            temp = temp.next;
        }
        ans = ans.next;
        ans.prev = null;
        return ans;
    }
    static void printDLL(DLLNode head){
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
}