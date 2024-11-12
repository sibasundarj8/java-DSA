package Stack;


import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList_Implementation {

    /// Implementation of Stack using Linked List
    private static class LLStack<T> {

        /// Node of Stack
        private static class Node<T> {
            T data;
            Node<T> next;
            Node(T data) {
                this.data = data;
            }
        }

        Node<T> head;
        private int size = 0;

        /// Push Stack
        void push(T data) {
            Node<T> node = new Node<>(data);
            node.next = head;
            head = node;
            size++;
        }

        /// Pop Stack
        T pop(){
            if (head == null){
                System.out.println("Stack Underflow");
                return null;
            }
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        /// Peek Stack
        T peek(){
            if (head == null){
                System.out.println("Stack is Empty");
                return null;
            }
            return head.data;
        }

        /// Length of the Stack
        int length(){
            return size;
        }

        /// Checks if Stack is Empty
        boolean isEmpty(){
            return head == null;
        }

        /// Print Stack
        private void display(Node<T> head){
            if (head == null)return;
            display(head.next);
            System.out.print(head.data + " ");
        }
        void printStack(){
            this.display(this.head);
            System.out.println();
        }
    }

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LLStack<String> ls = new LLStack<>();

        // Take input until "Stop" keyword
        System.out.println("Enter elements: ");
        do {
            String input = sc.next();
            if (input.equalsIgnoreCase("stop")){
                break;
            }
            ls.push(input);
        }
        while (sc.hasNext());

        System.out.print("Elements: ");
        ls.printStack();

        System.out.println("Length: " + ls.length());

        System.out.println("isEmpty: " + ls.isEmpty());

        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());

        System.out.println("Peek element: " + ls.peek());

        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());
        System.out.println("Removed: " + ls.pop());

        System.out.println("isEmpty: " + ls.isEmpty());
    }
}