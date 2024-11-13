package LinkedList;/*
 * https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
 *
 * # Intersection Point in Y Shaped Linked Lists
 *
 *   Q. Given two singly linked lists, return the point where two linked lists intersect.
 *      Note: If the linked lists do not merge at any point, return -1.
 *    Ex.
 *      Input : Linked list 1: 4->1->8->4->5                                     (5)
 *              Linked List 2: 5->6->1->8->4->5                                 ↙
 *      Output: 8                                          (4)               (6)
 *                                                            ↘            ↙
 *                                                             (1)      (1)
 *                                                                ↘    ↙
 *                                                                  (8)
 *                                                                   ↓
 *                                                                  (4)
 *                                                                   ↓
 *                                                                  (5)
 * 
 *      Explanation: From the above image, it is clearly seen that the common part is 8->4->5
 *                   whose starting point is 8.
 */
public class L14_Intersection_Point_in_Y_Shaped_Linked_Lists {

    /// Linked-list Structure
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    /// main Method
    public static void main(String[] args) {
        Node a = new Node(1);   //  (a)
        Node b = new Node(2);   //     ↘
        Node c = new Node(3);   //       (b)
        Node d = new Node(4);   //          ↘
        Node e = new Node(5);   //           (c)
        Node f = new Node(6);   //              ↘
        Node g = new Node(7);   //                (d)
        Node h = new Node(8);   //                   ↘
        Node i = new Node(9);   //                    (e) → (f) → (g) → (h)
        Node j = new Node(10);  //                   ↗
                                //                (j)
        a.next = b;             //               ↗
        b.next = c;             //            (i)
        c.next = d;             //
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        i.next = j;
        j.next = e;

        System.out.println("InterSection Point");
        System.out.println(intersectPoint(a, i));
    }

    /// Solution
    static int intersectPoint(Node h1, Node h2) {
        // potd.code.hub
        int size1 = 0;
        int size2 = 0;
        Node t1 = h1;
        Node t2 = h2;
        while(t1 != null || t2 != null){
            if(t1 != null){
                size1++;
                t1 = t1.next;
            }
            if(t2 != null){
                size2++;
                t2 = t2.next;
            }
        }
        int d = Math.abs(size1 - size2);

        if(size1 > size2){
            t1 = h1;
            t2 = h2;
        }
        else{
            t1 = h2;
            t2 = h1;
        }

        while (t1 != null){
            if(t1 == t2) return t1.data;
            if(d <= 0){
                t2 = t2.next;
            }
            t1 = t1.next;
            d--;
        }

        return -1;
    }
}
