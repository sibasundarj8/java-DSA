package LinkedList;


class Linkedlist{
    private Node head;
    Node tail;
    private static int size = 0;
    void insertLast(int val){
        Node temp = new Node(val);
        if (head == null)
            this.head = temp;
        else this.tail.next = temp;
        this.tail = temp;
        size++;
    }
    void insertBegin(int val){
        Node temp = new Node(val);
        if (this.head == null)
            this.tail = temp;
        else temp.next = this.head;
        this.head = temp;
        size++;
    }
    void insertAt(int val, int idx){
        if (idx == 0){
            insertBegin(val);
            return;
        }
        int k = 1;
        Node temp = head;
        Node key = new Node(val);
        while(temp.next != null && k < idx-1){
            k++;
            temp = temp.next;
        }
        key.next = temp.next;
        temp.next = key;
        size++;
    }
    void deleteAt(int idx){
        if (idx == 1){
            head = head.next;
            return;
        }
        int k = 1;
        Node temp = head;
        if (idx <= 0 || idx > size()) return;
        while(k != idx-1 && temp.next != null) {
            temp = temp.next;
            k++;
        }
        temp.next = temp.next.next;
        if (idx == size())tail = temp;
        size--;
    }
    void printList(){
        Node temp = this.head;
        while (temp != null){
            if (temp.next == null)
                System.out.println(temp.data);
            else System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    int size(){
        return size;
    }
}
public class L02_Implementation {

    public static void main(String[] args) {
        Linkedlist head = new Linkedlist();
        head.insertLast(5);
        head.insertLast(10);
        head.insertLast(15);
        head.printList(); // 5 -> 10 -> 15
        head.insertBegin(69);
        head.printList(); // 69 -> 5 -> 10 -> 15
        head.insertAt(100,2);
        head.printList(); // 69 -> 5 -> 100 -> 10 -> 15
        System.out.println("Size : " + head.size());
        head.deleteAt(5);
        head.printList();
        System.out.println(head.size());
        System.out.println(head.tail.data);
    }
}
