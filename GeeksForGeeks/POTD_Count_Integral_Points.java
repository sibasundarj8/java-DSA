package GFG;

import java.util.Scanner;

public class POTD_Count_Integral_Points {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("A :");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.println("B :");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.println(countIntegralPoints(x1,y1,x2,y2));
    }
    static int countIntegralPoints(int x1, int y1, int x2, int y2) {
        // code here
        int v1 = Math.abs(x1-x2);
        int v2 = Math.abs(y1-y2);

        if (x1==x2 && y1== y2)return 0;
        return gcd(v1,v2) - 1;
    }
    static int gcd (int a,int b){
        // Base case
        if(b == 0)return a;

        // Recursive Work
        return gcd(b,a%b);
    }
}