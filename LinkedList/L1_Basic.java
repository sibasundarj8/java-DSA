package LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class L1_Basic {
    public static void main(String[] args) {

        // LinkedList Initialization
        // Node Creating
        Node a = new Node(5);
        Node b = new Node(6);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(1);
        Node g = new Node(8);
        //  5  6  2  3  4  1  8

        // Connecting the Nodes
        a.next = b;     // 5 -> 6
        b.next = c;     // 6 -> 2
        c.next = d;     // 2 -> 3
        d.next = e;     // 3 -> 4
        e.next = f;     // 4 -> 1
        f.next = g;     // 1 -> 8
        // 5 -> 6 -> 2 -> 3 -> 4 -> 1 -> 8

        // Printing the Nodes using loop
        System.out.println("Using loop");
        printList(a);

        // Printing the Nodes using Recursion
        System.out.println("Using Recursion");
        printListRec(a);

        // Getting Size
        System.out.print("\nSize : ");
        System.out.println(size(a));
    }
    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    static void printListRec(Node head){
        // base case
        if (head == null)return;
        // self-work
        System.out.print(head.data + " ");
        // recursive work
        printListRec(head.next);
    }
    static int size(Node head){
        int ans = 0;
        Node temp = head;
        while (temp != null){
            ans++;
            temp = temp.next;
        }
        return ans;
    }
}