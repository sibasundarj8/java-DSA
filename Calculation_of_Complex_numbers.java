import java.util.Scanner;

class Complex
{
    int real;
    int img;

    public Complex(int r, int i)
    {
        this.real = r;
        this.img = i;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.img + b.img);
    }

    public static Complex diff(Complex a, Complex b) {
        return new Complex(a.real - b.real, a.img - b.img);
    }

    public static Complex product(Complex a, Complex b) {
        return new Complex(a.real * b.real - a.img * b.img, a.real * b.img + a.img * b.real);
    }

    public void printComplex()
    {
        if (this.real == 0 && this.img != 0)
        {
            System.out.println(this.img + " i");
        } else if (this.real != 0 && this.img == 0)
        {
            System.out.println(this.real);
        } else {
            System.out.println(this.real + " + " + this.img + " i");
        }

    }
}
public class Calculation_of_Complex_numbers
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter real part of complex number 1 : ");
        int real1 = sc.nextInt();

        System.out.println("Enter complex part of complex number 1 without iota sign : ");
        int img1 = sc.nextInt();

        System.out.println("Enter real part of complex number 2 : ");
        int real2 = sc.nextInt();

        System.out.println("Enter complex part of complex number 2 without iota sign : ");
        int img2 = sc.nextInt();

        Complex c = new Complex(real1, img1);
        Complex d = new Complex(real2, img2);
        Complex e = Complex.add(c, d);
        Complex f = Complex.diff(c, d);
        Complex g = Complex.product(c, d);
        e.printComplex();
        f.printComplex();
        g.printComplex();
    }
}