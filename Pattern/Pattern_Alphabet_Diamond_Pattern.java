package Pattern;

import java.util.Scanner;

public class Pattern_Alphabet_Diamond_Pattern {
    public Pattern_Alphabet_Diamond_Pattern() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int alpha = 65;
        int ans = 0;

        int x;
        int i;
        int j;
        for(i = 1; i <= r; ++i) {
            for(j = 1; j <= r - i; ++j) {
                System.out.print("   ");
            }

            for(j = 1; j <= 2 * i - 1; ++j) {
                x = ans++;
                if (ans == 26)ans = 0;
                System.out.print((char)(alpha + x) + "  ");
            }

            ans = 0;
            System.out.println();
        }

        for(i = 1; i <= r - 1; i++) {
            for(j = 1; j <= i; j++) {
                System.out.print("   ");
            }

            for(j = (r - i) * 2 - 1; j >= 1; j--) {
                x = ans++;
                if (ans == 26)ans = 0;
                System.out.print((char)(alpha + x) + "  ");
            }

            System.out.println();
            ans = 0;
        }

    }
}