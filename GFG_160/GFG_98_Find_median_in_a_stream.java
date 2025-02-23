package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
 *
 * # Find median in a stream
 *
 *   Q. Given a data stream arr[] where integers are read sequentially, the task is to determine the
 *      median of the elements encountered so far after each new integer is read.
 *
 *      There are two cases for median on the basis of data set size.
 *
 *          1. If the data set has an odd number, then the middle one will be considered as median.
 *
 *          2. If the data set has an even number, then there is no distinct middle value and the
 *             median will be the arithmetic mean of the two middle values.
 *    Ex.
 *      Input:  arr[] = [5, 15, 1, 3, 2, 8]
 *      Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
 *      Explanation:
 *              After reading 1st element of stream – 5 -> median = 5.0
 *              After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0
 *              After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
 *              After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
 *              After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
 *              After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
 */
import java.util.*;

public class GFG_98_Find_median_in_a_stream {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(getMedian(arr));
    }

    /// Solution
    private static final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private static final PriorityQueue<Integer> right = new PriorityQueue<>();
    static ArrayList<Double> getMedian(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Double> ans = new ArrayList<>(n+1);
        for (int j : arr) ans.add(get(j));

        return ans;
    }
    private static double get(int ele){
        if (left.isEmpty() || left.peek() >= ele)left.offer(ele);
        else right.offer(ele);
        if (left.size() < right.size()) left.offer(right.poll());
        else if (left.size() > right.size()+1) right.offer(left.poll());
        return (left.size() == right.size()) ? ((double) (left.peek() + right.peek()) / 2) : left.peek();
    }
}
