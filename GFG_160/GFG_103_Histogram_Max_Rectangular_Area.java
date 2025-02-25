package GFG_160;
/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
 *
 * # Histogram Max Rectangular Area
 *
 *   Q. You are given a histogram represented by an array arr, where each element of the array denotes the height
 *      of the bars in the histogram. All bars have the same width of 1 unit.
 *
 *      Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can
 *      be formed using a number of contiguous bars.
 *    Ex.
 *      Input : arr[] = [60, 20, 50, 40, 10, 50, 60]
 *
 *                       60 | ⨉                 ⨉ 
 *                       50 | ⨉    ⨉         ⁜ ⁜
 *                       40 | ⨉    ⨉  ⨉     ⁜ ⁜    
 *                       30 | ⨉    ⨉  ⨉     ⁜ ⁜    
 *                       20 | ⨉ ⨉ ⨉  ⨉     ⁜ ⁜
 *                       10 | ⨉ ⨉ ⨉  ⨉ ⨉  ⁜ ⁜
 *                  --------------------------------
 *                          |60 20 50 40 10 50 60
 *                          |
 *      Output: 100
 *      Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is
 *                   computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 */
import java.util.Scanner;
import java.util.Stack;

public class GFG_103_Histogram_Max_Rectangular_Area {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(getMaxArea(arr));
    }

    /// Solution
    static int getMaxArea(int[] arr) {
        // potd.code.hub
        int n = arr.length, ans = 0;
        int[] nse = nextSmaller(arr);
        int[] pse = prevSmaller(arr);

        for (int i = 0;i < n;i++){
            int height = arr[i];
            int width = nse[i] - pse[i] - 1;
            ans = Math.max(ans, height * width);
        }

        return ans;
    }
    private static int[] nextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        for (int i = n-1;i >= 0;i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    private static int[] prevSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for (int i = 0;i < n;i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
