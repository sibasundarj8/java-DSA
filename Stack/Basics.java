package Stack;

import java.util.Stack;

public class Basics {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0;i <= 10;i++){
            s.push(i);
        }
        printStack(s);
        System.out.println();
        System.out.println(s);
    }
    static void printStack(Stack<Integer> s){
        if (s.isEmpty()) return;
        int x = s.pop();
        printStack(s);
        System.out.print(x + " ");
        s.push(x);
    }
}