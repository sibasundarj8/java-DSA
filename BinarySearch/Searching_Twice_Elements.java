package Binary_Search; /*
 *   Q. You are given a sorted array consisting of only integers where every element appears
 *      exactly twice, except for one element which appears exactly once.
 *      Return the single element that appears only once
 *    Ex.
 *       Input : n = 9
 *               arr[] = {1, 1, 2, 2, 4, 4, 5, 8, 8}
 *       Output : 5
 */
import java.util.Scanner;

public class Searching_Twice_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

    }
}