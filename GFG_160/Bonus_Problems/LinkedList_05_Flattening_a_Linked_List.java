package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 *
 * # Flattening a Linked List
 *
 *   Q. Given a linked list containing n head nodes where every node in the linked list contains
 *      two pointers:
 *          (i) next points to the next node in the list.
 *          (ii) bottom pointer to a sub-linked list where the current node is the head.
 *
 *      Each of the sub-linked lists nodes and the head nodes are sorted in ascending order
 *      based on their data.
 *
 *      Your task is to flatten the linked list such that all the nodes appear in a single level
 *      while maintaining the sorted order.
 *
 *      Note:
 *          1. ↓ represents the bottom pointer and -> represents the next pointer.
 *          2. The flattened list will be printed using the bottom pointer instead of the next
 *             pointer.
 *    Ex.
 *      Input:
 *              5 → 10 → 19 → 28
 *              ↓    ↓    ↓    ↓
 *              7   20   22   35
 *              ↓         ↓    ↓
 *              8        50   40
 *              ↓              ↓
 *              30            45
 *
 *      Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
 *      Explanation:
 *              Bottom pointer of 5 is pointing to 7.
 *              Bottom pointer of 7 is pointing to 8.
 *              Bottom pointer of 8 is pointing to 10 and so on.
 */
public class LinkedList_05_Flattening_a_Linked_List {

    /// Structure
    private static class Node{
        int data;
        Node next, bottom;
        Node(int data){
            this.data = data;
        }

        static Node createList (Pair...arr){
            Node head = new Node(-1);
            Node temp = head;
            for (Pair j : arr) {
                temp.next = new Node(j.val);
                temp = temp.next;
                temp = createBottom(temp, j.bottom);
            }
            return head.next;
        }
        static Node createBottom (Node head, int...arr){
            Node temp = head;
            for (int j : arr) {
                temp.bottom = new Node(j);
                temp = temp.bottom;
            }
            return head;
        }

    }
    private static class Pair {
        int val;
        int[]bottom;
        Pair(int val, int...arr){
            this.val = val;
            this.bottom = arr;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Pair[] pair = {new Pair(5, 7, 8, 30),
                       new Pair(10, 20),
                       new Pair(19, 22, 50),
                       new Pair(28, 35, 40, 45)};
        Node root = Node.createList(pair);
        Node ans = flatten(root);

        // printing
        for (Node temp = ans; temp != null; temp = temp.bottom){
            System.out.print(temp.data + " ");
        }
    }

    /// Solution
    static Node flatten(Node root) {
        // potd.code.hub
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        
        return merge(root, root.next);
    }
    private static Node merge (Node x, Node y){
        Node ans = new Node(-1);
        Node t1 = x, t2 = y, temp = ans;
        while (t1 != null && t2 != null){
            if (t1.data < t2.data){
                temp.bottom = t1;
                t1 = t1.bottom;
            }
            else {
                temp.bottom = t2;
                t2 = t2.bottom;
            }
            temp.next = null;
            temp = temp.bottom;
        }
        temp.bottom = t1 == null ? t2 : t1;
        return ans.bottom;
    }
}
