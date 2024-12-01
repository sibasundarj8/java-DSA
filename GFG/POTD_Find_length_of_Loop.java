/*
 *   Q. Given the head of a linked list, determine whether the list contains a loop. If a loop is present,
 *      return the number of nodes in the loop, otherwise return 0.
 *
 *      Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist.
 *            If c is 0, then there is no loop.
 *      Example :
 *              Input: LinkedList: 25 → 14 → 19 → 33 → 10 → 21 → 39 → 90 → 58 → 45, c = 4
 *              Output: 7
 *          Explanation: The loop is from 33 to 45. So the length of the loop is 33→10→21→39→ 90→58→45 = 7.
 *                      The number 33 is connected to the last node of the linkedlist to form the loop because,
 *                      according to the input, the 4th node from the beginning(1 based indexing) will be
 *                      connected to the last node for the loop.
 */
package GFG;


public class POTD_Find_length_of_Loop {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {

    }
    static int countNodesinLoop(Node head) {
        // potd.code.hub.
        Node r = head;
        Node t = head;
        int ans = 1;
        while(t != null && t.next != null && r.next != null && r.next.next != null){
            t = t.next;
            r = r.next.next;
            if (r == t)break;
        }
        if (r == null || r != t)return 0;
        if (t.next != null)t = t.next;
        while (t != r){
            t = t.next;
            ans++;
        }
        return ans;
    }
}