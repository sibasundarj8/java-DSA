package Matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem_2dArray_5_Merge_Overlapping {
    static int mergeOverlapping(int[][] arr, int r) {
        Arrays.sort(arr, Comparator.comparingInt((a) -> a[0]));
        int count = 0;

        for(int i = 0; i < r; count++) {
            while(i < r - 1 && arr[i + 1][0] <= arr[i][1]) {
                arr[i + 1][0] = arr[i][0];
                arr[i + 1][1] = Math.max(arr[i][1], arr[i + 1][1]);
                i++;
            }
            i++;
        }

        System.out.println("Number of the Non-Overlapping intervals :");
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Rows :");
        int r = sc.nextInt();

        System.out.println("Column Number :\n2");
        int[][] arr = new int[r][2];

        System.out.println("Matrix Elements :");
        for(int i = 0; i < r; ++i)
            for(int j = 0; j < 2; ++j)
                arr[i][j] = sc.nextInt();

        System.out.println(mergeOverlapping(arr, r));
    }
}