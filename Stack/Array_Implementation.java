package Stack;


import java.util.Scanner;

public class Array_Implementation {

    /// Array Implementation of Stack
    private static class ArrayStack<T> {
        private final int size;
        private final T[]arr;
        ArrayStack(int size) {
            this.size = size;
            arr = (T[]) new Object[size];
        }
        private int top = 0;

        /// Length of the Stack
        public int length() {
            return top;
        }

        /// Checks if Stack is Empty
        public boolean isEmpty() {
            return top == 0;
        }

        /// Checks if Stack is Full
        public boolean isFull() {
            return top == size;
        }

        /// Push element in the Stack
        public void push(T data){
            try {
                arr[top] = data;
                top++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Stack Overflow");
            }
        }

        /// Peek element from the Stack
        public T peek(){
            try{
                return arr[top-1];
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Stack is Empty");
                return null;
            }
        }

        /// Pop element from the Stack
        public T pop(){
            try {
                return arr[--top];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Stack Underflow");
                top++;
                return null;
            }
        }

        /// Print Stack
        public void print(){
            System.out.print("Display: ");
            for(int i = 0; i < top; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    /// Main Method
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size of Stack: ");
        ArrayStack<String> s = new ArrayStack<>(sc.nextInt());

        System.out.println("Elements: ");
        do {
            String input = sc.next();
            if (input.equalsIgnoreCase("stop")){
                break;
            }
            s.push(input);
        }
        while (sc.hasNext());

        s.print();
        System.out.println("Peek: " + s.peek());
        System.out.println("Full: " + s.isFull());

        System.out.println("Removed: " + s.pop());
        System.out.println("Peek: " + s.peek());

        System.out.println("Removed: " + s.pop());
        System.out.println("Peek: " + s.peek());

        System.out.println("Removed: " + s.pop());
        System.out.println("Peek: " + s.peek());

        System.out.println("Removed: " + s.pop());
        System.out.println("Peek: " + s.peek());

        System.out.println("Removed: " + s.pop());
        System.out.println("Removed: " + s.pop());
        System.out.println("Empty: " + s.isEmpty());
        System.out.println("Peek: " + s.peek());
        System.out.println("Length: " + s.length());
    }
}