package LinkedList;


public class L12_Copy_List_with_Random_Pointer {
    static class Node {
        int data;
        Node next;
        Node random;

        public Node(int val) {
            this.data = val;
            this.next = null;
            this.random = null;
        }
    }
    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Random :");
        temp =head;
        while (temp != null){
            if (temp.random != null)
                System.out.print(temp.random.data + " ");
            else System.out.print("Null ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;
        System.out.println("Clone :");
        printList(copyList(a));
        System.out.println("Original :");
        printList(a);
    }
    static Node copyList(Node head) {
        // potd.code.hub
        Node clone = new Node(0);
        Node temp = head;
        Node var = clone;
        // coping data and next
        while (temp != null){
            var.next = new Node(temp.data);
            temp = temp.next;
            var = var.next;
        }
        // merging 2 lists
        var = head;
        Node c1 = head;
        Node c2 = clone.next;
        while (var != null){
            c1 = c1.next;
            var.next = c2;
            var = var.next;
            c2 = c2.next;
            var.next = c1;
            var = var.next;
        }
        // updating random positions
        temp = head;
        while (temp != null && temp.next != null){
            if (temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        // extracting 2 lists
        temp = head;
        var = head.next;
        Node ans = var;
        while (var != null && var.next != null){
            temp.next = temp.next.next;
            var.next = var.next.next;
            temp = temp.next;
            var = var.next;
        }
        temp.next = null;
        return ans;
    }
}