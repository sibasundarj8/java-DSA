package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/0
 *
 * # Clone List with Next and Random
 *
 *   Q. You are given a special linked list with n nodes where each node has two pointers a next
 *      pointer that points to the next node of the singly linked list, and a random pointer that
 *      points to the random node of the linked list.
 *
 *      Construct a copy of this linked list. The copy should consist of the same number of new
 *      nodes, where each new node has the value corresponding to its original node. Both the next
 *      and random pointer of the new nodes should point to new nodes in the copied list, such that
 *      it also represent the same list state. None of the pointers in the new list should point to
 *      nodes in the original list.
 *
 *      Return the head of the copied linked list.
 *
 *      NOTE : Original linked list should remain unchanged.
 *    Ex.
 *      Input : head = [[1, 3], [3, 3], [5, NULL], [9, 3]]
 *      Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] '
 *      Explanation: Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
 *                   Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
 *                   Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
 *                   Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.
 */
public class GFG_70_Clone_List_with_Next_and_Random {

  /// Structure
    private static class Node{
        int data;
        Node next;
        Node random;
        Node (int data){
            this.data = data;
        }
    }
    private static void printList (Node head){
        Node temp = head;
        while (temp != null){
            System.out.print("[" + temp.data + ", ");
            if (temp.random != null) System.out.print(temp.random.data + "] ");
            else System.out.print("NULL] ");
            temp = temp.next;
        }
        System.out.println();
    }

  /// main Method
    public static void main(String[] args) {
        Node node = new Node(1);
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(9);
        node.next = a;
        a.next = b;
        b.next = c;
        node.random = a;
        a.random = a;
        c.random = a;

        printList(cloneLinkedList(node));
    }

  /// Solution
    static Node cloneLinkedList(Node head) {
        // potd.code.hub
        Node ans = new Node(-1);
        Node temp = head;
        
      // combining 2 lists
        while (temp != null){
            Node next = temp.next;
            temp.next = new Node(temp.data);
            temp.next.next = next;
            temp = next;
        }
        
      // setting random nodes
        temp = head;
        while (temp != null && temp.next != null){
            if (temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        
      // separating the lists
        Node clone = ans;
        for (temp = head;temp != null && temp.next != null;temp = temp.next){
            clone.next = temp.next;
            clone = clone.next;
            temp.next = clone.next;
        }

        return ans.next;
    }
}
