package Recursion;

import java.util.Scanner;

public class Recursion_37_Print_Binary_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Enter Size :");
        int n = sc.nextInt();

        System.out.println("Binary No. from 0 to " + ((1<<n)-1) + " :");
        printStar(n,"");
    }
    static void printStar(int rem,String ans)
    {
        // Base Case
        if (rem <= 0){
            System.out.println(ans);
            return;
        }
        // Recursive Work
        printStar(rem-1,ans + "0");
        printStar(rem-1,ans + "1");
    }
}