package Stack;

import java.util.Scanner;
import java.util.Stack;

public class S03_Next_Smaller_Element {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        nextSmaller(arr, n);

        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    /// Solution
    static void nextSmaller(int[]arr, int n){
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1;i >= 0;i--){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            int temp = arr[i];
            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(temp);
        }
    }
}