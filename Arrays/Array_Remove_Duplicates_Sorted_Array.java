package Array;/*
 * https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1
 *
 * # Remove Duplicates Sorted Array
 *
 *   Q. Given a sorted array arr. Return the size of the modified array which contains only distinct
 *      elements.
 *
 *      Note:
 *           1. Don't use set or HashMap to solve the problem.
 *           2. You must return the modified array size only where distinct elements are present and
 *              modify the original array such that all the distinct elements come at the beginning
 *              of the original array.
 *      Ex.
 *          Input : arr[] = {1, 2, 2, 3, 4, 4}
 *          Output: [1, 2, 3, 4]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_Remove_Duplicates_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.println("Size: ");
        int n = sc.nextInt();

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            list.add(sc.nextInt());
        }

        int size = remove_duplicate(list);

        for (int i = 0;i < size;i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    /// Solution
    static int remove_duplicate(List<Integer> arr) {
        // potd.code.hub
        int n = arr.size();
        int size = 1;
        int idx = 1;
        for(int i = 1;i < n;i++){
            if (! arr.get(i).equals(arr.get(i-1))){
                arr.set(idx, arr.get(i));
                idx++;
                size++;
            }
        }
        return size;
    }
}
