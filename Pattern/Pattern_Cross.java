package Pattern;

import java.util.Scanner;

public class Pattern_Cross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String s = sc.next();
        int n = s.length();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n ;j++){
                if (i == j || i+j==n-1)
                    System.out.print(s.charAt(j) + " ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}