package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1
 *
 * # Maximum of the minimum for every window size
 *
 *   Q. Given an array of integer's arr[], the task is to find the maximum of the minimum values for
 *      every possible window size in the array, where the window size ranges from 1 to arr.size().
 *
 *      More formally, for each window size k, determine the smallest element in all windows of size k,
 *      and then find the largest value among these minimums where 1<=k<=arr.size().
 *    Ex.
 *      Input : arr[] = [10, 20, 30, 50, 10, 70, 30]
 *      Output: [70, 30, 20, 10, 10, 10, 10]
 *      Explanation:
 *            1. The First element in output indicates the maximum of minimums of all windows of size 1.
 *               Minimums of windows of size 1 are [10], [20], [30], [50], [10], [70] and [30].
 *               The Maximum of these minimums is 70.
 *
 *            2. The Second element in output indicates the maximum of minimums of all windows of size 2.
 *               Minimums of windows of size 2 are [10], [20], [30], [10], [10], and [30].
 *               The Maximum of these minimums is 30.
 *
 *            3. The Third element in output indicates the maximum of minimums of all windows of size 3.
 *               Minimums of windows of size 3 are [10], [20], [10], [10] and [10].
 *               The Maximum of these minimums is 20.
 *
 *            Similarly, other elements of output are computed.
 */
import java.util.*;

public class GFG_104_Maximum_of_minimum_for_every_window_size {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(maxOfMins(arr));
    }

    /// Solution
    static ArrayList<Integer> maxOfMins(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < n;i++) list.add(0);
        
        int[] nse = new int[n];
        int[] pse = new int[n];
        nextPrevSmaller(arr, nse, pse);

        for (int i = 0;i < n;i++){
            int cap = nse[i] - pse[i] - 1;
            list.set(cap-1, Math.max(list.get(cap-1), arr[i]));
        }

        for (int i = n-2;i >= 0;i--)
            list.set(i, Math.max(list.get(i), list.get(i+1)));

        return list;
    }
    private static void nextPrevSmaller (int[]arr, int[]nse, int[]pse){
        int n = arr.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0;i < n;i++){
            
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            while (!stack1.isEmpty() && arr[stack1.peek()] >= arr[n-1-i])
                stack1.pop();
            
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            nse[n-1-i] = stack1.isEmpty() ? n : stack1.peek();
            
            stack.push(i);
            stack1.push(n-1-i);
        }
    }
}
