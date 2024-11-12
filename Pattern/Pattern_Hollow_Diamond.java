package Pattern;

import java.util.Scanner;

public class Pattern_Hollow_Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size :");
        int n = sc.nextInt();

        for (int i = 0;i < n;i++){
            for (int j = 0;j < n-i;j++)
                System.out.print("  ");
            for (int j = 0;j < 2*i-1;j++){
                if(j == 0 || j == 2*i-2)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = n-2;i >= 0;i--){
            for (int j = 0;j < n-i;j++)
                System.out.print("  ");
            for (int j = 0;j < 2*i-1;j++){
                if(j == 0 || j == 2*i-2)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}