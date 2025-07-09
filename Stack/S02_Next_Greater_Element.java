package Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class S02_Next_Greater_Element {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size : ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] =sc.nextInt();

        System.out.println(nextLargerElement(arr, n));
    }

    /// Solution
    public static ArrayList<Integer> nextLargerElement(int[] arr, int n) {
        // potd.code.hub
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n-1;i >= 0;i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            ans.add(0, (stack.isEmpty() ? -1 : stack.peek()));
            stack.push(arr[i]);
        }

        return ans;
    }
}