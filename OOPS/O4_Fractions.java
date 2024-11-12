package OOPS;


import java.util.Scanner;

public class O4_Fractions {
    static class Fraction{
        int numerator;
        int denominator;
        Fraction(int n, int d){
            this.numerator = n;
            this.denominator = d;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Fraction 1 : ");
        Fraction f1 = new Fraction(sc.nextInt(), sc.nextInt());

        System.out.println("Fraction 2 : ");
        Fraction f2 = new Fraction(sc.nextInt(), sc.nextInt());

        getFraction(f1);
        System.out.print(" = ");
        getFraction(simplify(f1));

        System.out.println();

        getFraction(f2);
        System.out.print(" = ");
        getFraction(simplify(f2));

        System.out.println("\n Addition : ");
        getFraction(add(f1, f2));

        System.out.println("\nMultiplication : ");
        getFraction(mul(f1, f2));
    }
    static Fraction add (Fraction f1, Fraction f2){
        f1 = simplify(f1);
        f2 = simplify(f2);
        int n = f1.numerator*f2.denominator + f1.denominator*f2.numerator;
        int d = f1.denominator * f2.denominator;
        return simplify(new Fraction(n, d));
    }
    static Fraction mul (Fraction f1, Fraction f2){
        f1 = simplify(f1);
        f2 = simplify(f2);
        int n = f1.numerator*f2.numerator;
        int d = f1.denominator*f2.denominator;
        return simplify(new Fraction(n, d));
    }
    static void getFraction(Fraction f){
        System.out.print(f.numerator+" / "+f.denominator);
    }
    static Fraction simplify(Fraction f){
        int hcf = gcd(f.numerator, f.denominator);
        f.numerator /= hcf;
        f.denominator /= hcf;
        return f;
    }
    static int gcd(int x, int y){
        // Base Case
        if (y == 0) return x;
        // Recursive Work
        return gcd(y,x%y);
    }
}