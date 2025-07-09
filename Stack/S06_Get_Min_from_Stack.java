package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
 *
 * # Get Min from Stack
 *
 *   Q. Given q queries, Your task is to implement the following four functions for a stack:
 *
 *      • push(x) – Insert an integer x onto the stack.
 *      • pop() – Remove the top element from the stack.
 *      • peek() - Return the top element from the stack. If the stack is empty, return -1.
 *      • getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
 *
 *      Each query can be one of the following:
 *
 *      switch(1/2/3/4)->
 *          1: x -> Push x onto the stack.
 *          2: Pop the top element from the stack.
 *          3: Return the top element from the stack. If the stack is empty, return -1.
 *          4: Return the minimum element from the stack.
 *    Ex.
 *      Input: q = 7, queries = [[1, 2],
 *                               [1, 3],
 *                               [3],
 *                               [2],
 *                               [4],
 *                               [1, 1],
 *                               [4]]
 *      Output: [3, 2, 1]
 *      Explanation:
 *              push(2): Stack is [2]
 *              push(3): Stack is [2, 3]
 *              peek(): Top element is 3
 *              pop(): Removes 3, stack is [2]
 *              getMin(): Minimum element is 2
 *              push(1): Stack is [2, 1]
 *              getMin(): Minimum element is 1
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S06_Get_Min_from_Stack {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();

        System.out.println("Number of queries: ");
        int n = sc.nextInt();

        System.out.println("""
                Enter 1/2/3/4 :\s
                1: push(x) x -> Push x onto the stack.
                2: pop() Pop the top element from the stack.
                3: peek() Return the top element from the stack. If the stack is empty, return -1.
                4: getMin() Return the minimum element from the stack.""");

        Solution s = new Solution();
        for (int i = 0;i < n;i++){
            int t = sc.nextInt();
            switch (t){
                case 1 -> s.push(sc.nextInt());
                case 2 -> s.pop();
                case 3 -> ans.add(s.peek());
                case 4 -> ans.add(s.getMin());
            }
        }

        System.out.println(ans);
    }

    /// Solution
    private static class Solution{
        private final Stack<Integer> stack;
        private int minVal;

        Solution(){
            stack = new Stack<>();
            minVal = -1;
        }

        // Add an element to the top of Stack
        void push ( int x){
            // potd.code.hub
            if (stack.isEmpty()) {
                minVal = x;
                stack.push(x);
            }
            else {
                if (x < minVal){
                    stack.push((x ^ minVal) * -1);
                    minVal = x;
                }
                else stack.push(x);
            }
        }

        // Remove the top element from the Stack
        void pop () {
            // potd.code.hub
            if (!stack.isEmpty()) {
                int temp = stack.pop();
                if (temp < 0) minVal = (temp^minVal) * -1;
            }
        }

        // Returns top element of the Stack
        int peek () {
            // potd.code.hub
            if (stack.isEmpty()) return -1;
            return stack.peek() < 0 ? minVal : stack.peek();
        }

        // Finds minimum element of Stack
        int getMin () {
            // potd.code.hub
            if (stack.isEmpty()) return -1;
            return minVal;
        }
    }
}