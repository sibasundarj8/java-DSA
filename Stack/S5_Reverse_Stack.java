package Stack;/*
 * https://www.geeksforgeeks.org/problems/reverse-a-stack/1?page=2&category=Stack&sortBy=submissions
 *
 * # Reverse a Stack
 *
 *   Q. You are given a stack St. You have to reverse the stack using recursion.
 *    Ex.
 *      Input :     stack = { 3, 2, 1, 7, 6 }
 *      Output:     stack = { 6, 7, 1, 2, 3 }
 *      Explanation: Input stack after reversing will look like the stack in the output.
 */
import java.util.Scanner;
import java.util.Stack;

public class S5_Reverse_Stack {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter '-1' to stop pushing.");
        System.out.println("Enter elements: ");
        do {
            int temp = sc.nextInt();
            if (temp == -1) break;
            stack.push(temp);
        }
        while (sc.hasNextInt());

        System.out.println("Before reverse");
        printStack(stack);
        System.out.println();
        reverse(stack);
        System.out.println("After reverse");
        printStack(stack);
    }

    /// Reverse
    static void reverse(Stack<Integer> s){
        // potd.code.hub
        if (s.isEmpty())return;
        int temp = s.pop();
        reverse(s);
        insert(s,temp);
    }

    /// insert at bottom
    static void insert(Stack<Integer> s, int target){
        if (s.isEmpty()){
            s.push(target);
            return;
        }
        int temp = s.pop();
        insert(s, target);
        s.push(temp);
    }

    /// Print Stack
    static void printStack(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int temp = stack.pop();
        printStack(stack);
        System.out.print(temp + " ");
        stack.push(temp);
    }
}