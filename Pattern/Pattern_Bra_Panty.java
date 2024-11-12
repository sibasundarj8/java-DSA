package Pattern;

import java.util.Scanner;

public class Pattern_Bra_Panty {
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
        for (i = 0;i < r*0.6;i++) System.out.println();
        for (i = 0;i < r;i++) {
            if (i == r - 1) System.out.println(" *\n");
            else System.out.print("  ");
        }
        for (i = r;i >= 0;i--){
            for (j = 0;j < r-i;j++)
                System.out.print("  ");
            for (j = 0;j < 2*i-1;j++)
                System.out.print(" *");
            System.out.println();
        }
    }
}