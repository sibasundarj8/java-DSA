package LinkedList;/*
 *
 * https://www.geeksforgeeks.org/problems/prime-list--170646/1
 *
 * # Prime List
 *
 *   Q. You are given the head of a linked list. You have to replace all the values of the nodes
 *      with the nearest prime number. If more than one prime number exists at an equal distance,
 *      choose the smallest one. Return the head of the modified linked list.
 *    Ex.
 *      Input: head = 1 → 15 → 20
 *      Output: ans = 2 → 13 → 19
 *      Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13
 *                   is smaller so, 13 will be chosen. The nearest prime of 20 is 19.
 */

import java.util.Arrays;
import java.util.Scanner;

public class L18_Prime_List {

    /// Structure
    private static class Node{
        int val;
        Node next;
        Node (int val){
            this.val = val;
        }
    }

    private static Node createList(String ele) {
        String[] s = ele.split(" ");
        Node node = new Node(-1);
        Node temp = node;
        for (String i : s) {
            temp.next = new Node(Integer.parseInt(i));
            temp = temp.next;
        }
        return node.next;
    }

    private static void printList(Node head) {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter node values: ");
        String s = sc.nextLine();

        Node head = createList(s);

        System.out.println("Before Conversion: ");
        printList(head);

        Node ans = primeList(head);

        System.out.println("After Conversion: ");
        printList(ans);
    }

    /// Solution

/****************************************************************************Brute-force-Approach****************************************************************************/
// TC : O(n * k * sqrt(m))
// SC : O(1)
    static Node primeList1(Node head) {
        // potd.code.hub
        Node temp = head;

        while (temp != null) {
            int val = temp.val;
            if (!isPrime(val)) {
                boolean prev = false;
                boolean next = false;
                int i = 1;
                while (!prev && !next) {
                    prev = isPrime(val - i);
                    next = isPrime(val + i);
                    if (prev) {
                        temp.val = val - i;
                    } else if (next) {
                        temp.val = val + i;
                    }
                    i++;
                }
            }
            if (val == 1) temp.val = 2;
            temp = temp.next;
        }

        return head;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; (i * i) <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

/********************************************************************************Precomputation******************************************************************************/
// TC : O(n)     O(k) steps to find the closest prime, Negligible because k is very small
// SC : O(1)    (46349 ≈ constant) → ~180KB of memory
    private static final int maxCap = 46349;
    private static final int[] primes = new int[maxCap];
    static {
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i < maxCap;i++){
            if (primes[i] == 0){
                continue;
            }
            for (int j = (i * i);j < maxCap;j += i){
                primes[j] = 0;
            }
        }
    }
    static Node primeList(Node head) {
        // potd.code.hub
        Node temp = head;

        while (temp != null) {
            int val = temp.val;

            boolean prev, next;
            prev = next = primes[val] == 1;
            int i = 1;
            while (!prev && !next) {
                prev = primes[val - i] == 1;
                next = primes[val + i] == 1;
                if (prev) {
                    temp.val = val - i;
                } else if (next) {
                    temp.val = val + i;
                }
                i++;
            }

            if (val == 1) temp.val = 2;
            temp = temp.next;
        }

        return head;
    }
}
