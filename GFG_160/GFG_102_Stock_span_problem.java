package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
 *
 * # Stock span problem
 *
 *   Q. The stock span problem is a financial problem where we have a series of daily price quotes for a
 *      stock, and we need to calculate the span of stock price for all days. The span arr[i] of the stocks
 *      price on a given day i is defined as the maximum number of consecutive days just before the given
 *      day, for which the price of the stock on the given day is less than or equal to its price on the
 *      current day.
 *    Ex.
 *      Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
 *      Output: [1, 1, 1, 2, 1, 4, 6]
 *      Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no
 *                   more elements behind it so the span is 1, 80 is greater than equal to 80 and smaller
 *                   than 100 so the span is 1, 60 is greater than equal to 60 and smaller than 80 so the
 *                   span is 1, 70 is greater than equal to 60,70 and smaller than 80 so the span is 2 and
 *                   so on. Hence, the output will be 1 1 1 2 1 4 6.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GFG_102_Stock_span_problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(calculateSpan(arr));
    }

    /// Solution
    static ArrayList<Integer> calculateSpan(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i < n;i++){
            int sum = 1;
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                sum += ans.get(stack.pop());
            ans.add(sum);
            stack.add(i);
        }

        return ans;
    }
}
