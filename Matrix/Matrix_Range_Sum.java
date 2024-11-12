package Matrix;

import java.util.Scanner;

public class Matrix_Range_Sum
{
    public static void main(String[] args)
    {
        Scanner sca = new Scanner(System.in);

        System.out.println("Enter Dimensions of 2D Array :");
        int r = sca.nextInt();
        int c = sca.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter Elements of 2D Array :");
        for(int i = 0; i < r; ++i)
        {
            for(int j = 0;j < c; j++)
            {
                arr[i][j] = sca.nextInt();
            }
        }

        System.out.println("Enter the Coordinates :");

        // First element's Coordinate
        int sr = sca.nextInt();
        int sc = sca.nextInt();

        // Second element's coordinate
        int er = sca.nextInt();
        int ec = sca.nextInt();

        int sum = 0;
        for(int i = sr; i <= er; ++i)
        {
            for(int j = sc; j <= ec; ++j)
            {
                sum += arr[i][j];
            }
        }
        System.out.println("Sum is : " + sum);
    }
}