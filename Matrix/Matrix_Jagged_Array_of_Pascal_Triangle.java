package Matrix;

import java.util.Scanner;

public class Matrix_Jagged_Array_of_Pascal_Triangle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Row :");
        int n = sc.nextInt();

        printPattern(n);
    }
    static void printPattern(int n){
        int[][]arr = new int[n][];

        for (int i = 0;i < n;i++){

            arr[i] = new int[i+1];
            // calculating the value
            for (int j = 0;j < i;j++)
                if (j == 0 || j == i-1)arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            // printing Space
            for (int j = 0;j < n-i;j++)
                System.out.print(" ");
            // printing value
            for (int j = 0;j < i;j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }
    }
}