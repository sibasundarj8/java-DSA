/*
 *  Q.  You are given four numbers num1, den1, num2, and den2.
 *      You need to find (num1/den1)+(num2/den2) and output the result in the form of
 *      (numx/denx).
 *  Output Format:
 *      For each test case, in a new line, output will be the fraction in the form a/b
 *      where the fraction denotes the sum of the two given fractions in reduced form.
 *
 *      Input:  12 40
 *              14 40
 *      Output: 13/20
 *      Explanation : (12/40)+(14/40) = 13/20
 */
import java.util.Scanner;

public class Add_two_fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st fraction (numerator denominator) :  ");
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        System.out.println("Enter 2nd fraction :");
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        addFraction(n,n1,n2,n3);
    }
    static void addFraction(int num1, int den1, int num2, int den2)
    {
        // Your code here
        int lcm = (den1*den2)/gcd(den1,den2);
        int num = num1*(lcm/den1) + num2*(lcm/den2);
        int cf = gcd(num,lcm);
        lcm /= cf;
        num /= cf;
        System.out.println(num +"/"+ lcm);
    }
    static int gcd (int x,int y){
        if (y == 0)return x;
        return gcd(y,x%y);
    }
}