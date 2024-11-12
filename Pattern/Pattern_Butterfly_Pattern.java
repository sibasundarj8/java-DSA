package Pattern;

import java.util.Scanner;

public class Pattern_Butterfly_Pattern {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size : ");
        int r = sc.nextInt();
        int i, j;
        for(i = 1; i <= r; ++i) {
            for(j = 1; j <= i; ++j)
                System.out.print("* ");
            for(j = 1; j <= 2 * (r - i); ++j)
                System.out.print("  ");
            for(j = 1; j <= i; ++j)
                System.out.print("* ");

            System.out.println();
        }
        for(i = r; i >= 1; --i) {
            for(j = 1; j <= i; ++j)
                System.out.print("* ");
            for(j = 1; j <= 2 * (r - i); ++j)
                System.out.print("  ");
            for(j = 1; j <= i; ++j)
                System.out.print("* ");

            System.out.println();
        }
    }
}