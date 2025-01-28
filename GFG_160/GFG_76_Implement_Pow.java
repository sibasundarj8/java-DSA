package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/powx-n/0
 *
 * # Implement Pow
 *
 *   Q. Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).
 *    Ex.
 *      Input : b = -0.67000, e = -7
 *      Output: -16.49971
 */
import java.util.Scanner;

public class GFG_76_Implement_Pow {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number: ");
        double n = sc.nextDouble();

        System.out.println("Power: ");
        int p = sc.nextInt();

        System.out.printf("%.5f",power(n, p));
    }

    /// Solution
    static double power(double b, int e) {
        // potd.code.hub
        double ans = pow(b, Math.abs(e));

        return (e < 0) ? 1/ans : ans;
    }
    private static double pow(double b, int e) {
        // potd.code.hub
        if (e == 0) return 1;
        double temp = pow(b, e/2);
        if (e%2 == 0) return temp*temp;
        return temp*temp*b;
    }
}
