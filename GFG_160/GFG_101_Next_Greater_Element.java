package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 *
 * # Next Greater Element
 *
 *   Q. Given an array arr[ ] of integers, the task is to find the next greater element for each element
 *      of the array in order of their appearance in the array. Next greater element of an element in
 *      the array is the nearest element on the right which is greater than the current element.
 *
 *      If there does not exist next greater of current element, then next greater element for current
 *      element is -1. For example, next greater of the last element is always -1.
 *    Ex.
 *      Input : arr[] = [6, 8, 0, 1, 3]
 *      Output: [8, -1, 1, 3, -1]
 *      Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it
 *                   is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element
 *                   on right and hence -1.
 */
import java.util.*;

public class GFG_101_Next_Greater_Element {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(nextLargerElement(arr));
    }

    /// Solution
    static ArrayList<Integer> nextLargerElement(int...arr) {
        // potd.code.hub
        int n = arr.length;
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1;i >= 0;i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            int temp = (stack.isEmpty()) ? -1 : stack.peek();
            list.add(0, temp);
            stack.push(arr[i]);
        }

        return new ArrayList<>(list);
    }
}
