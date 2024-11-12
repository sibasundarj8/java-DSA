package Recursion;/*
*   Q. Given an array of integers, print a sum triangle from it such that the first level(the bottom
*      level in triangular fashion) has all array elements. From then, at each level, the number of
*      elements is one less than the previous level and elements at the level is the sum of consecutive
*      two elements in the previous level.
*
*      Input : n = 5
*              arr = {1, 2, 3, 4, 5}
*
*     Output : [48]
*              [20, 28]
*              [8, 12, 16]
*              [3, 5, 7, 9]
*              [1, 2, 3, 4, 5]
*/
import java.util.Arrays;
import java.util.Scanner;

public class Recursion_24_Array_Sum_Triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Array Elements : ");
        for (int i = 0;i < arr.length;i++) arr[i] = sc.nextInt();

        sumTriangle(arr);
    }
    static void sumTriangle(int[]arr)
    {
        // Base Case
        if (arr.length < 1)return;

        // Self Work
        int[]temp = new int[arr.length-1];

        for (int i = 0;i < arr.length-1;i++)
            temp[i] = arr[i] + arr[i+1];

        // Recursive Work
        sumTriangle(temp);

        // Self Work
        System.out.println(Arrays.toString(arr));
    }
}
