package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 *
 * # Allocate Minimum Pages
 *
 *   Q. You are given an array arr[] of integers, where each element arr[i] represents the number of pages
 *      in the ith book. You also have an integer k representing the number of students. The task is to
 *      allocate books to each student such that:
 *
 *        ● Each student receives at least one book.
 *        ● Each student is assigned a contiguous sequence of books.
 *        ● No book is assigned to more than one student.
 *
 *      The objective is to minimize the maximum number of pages assigned to any student. In other words,
 *      out of all possible allocations, find the arrangement where the student who receives the most pages
 *      still has the smallest possible maximum.
 *
 *      Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order
 *            (see the explanation for better understanding).
 *    Ex.
 *      Input : arr[] = [12, 34, 67, 90]
 *              k = 2
 *      Output: 113
 *      Explanation: Allocation can be done in following ways:
 *                      [12] and [34, 67, 90] Maximum Pages = 191
 *                      [12, 34] and [67, 90] Maximum Pages = 157
 *                      [12, 34, 67] and [90] Maximum Pages = 113.
 *                   Therefore, the minimum of these cases is 113, which is selected as the output.
 */

import java.util.Scanner;

public class GFG_34_Allocate_Minimum_Pages {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Number of books : ");
        int n = sc.nextInt();

        int[]books = new int[n];

        System.out.println("Enter the number of pages respectively: ");
        for (int i = 0;i < n;i++){
            books[i] = sc.nextInt();
        }

        System.out.println("Number of Students we gonna Distribute:");
        int k = sc.nextInt();

        System.out.println(findPages(books, k));
    }

    /// Solution
    static int findPages(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        if (n < k) return -1;

        int i = 0, j = 0;
        for (int t : arr){                            // O(N)
            i = Math.max(i, t);
            j += t;
        }
        // Search space : max Pages -> total sum
        while (i <= j){                               // O(log N)
            int mid = i + (j-i)/2;
            if (noStudentRequired(arr, n, mid) > k) i = mid+1;
            else j = mid-1;
        }

        return i;
    }
    private static int noStudentRequired(int[]arr, int n, int pages){
        int students = 1;
        int sum = 0;
        for (int i = 0;i < n;i++){                    // O(N)
            if (sum+arr[i] <= pages) sum += arr[i];
            else {
                sum = arr[i];
                students++;
            }
        }
        return students;
    }
}
