import java.util.Scanner;

class Triangle {
    int a;
    int b;
    int c;

    Triangle() {
    }

    public double getArea() {
        double s = (double)(this.a + this.b + this.c) / 2.0;
        return Math.pow(s * (s - (double)this.a) * (s - (double)this.b) * (s - (double)this.c), 0.5);
    }

    public double getParameter() {
        return (double)(this.a + this.b + this.c);
    }
}
public class Area_and_Perimeter_of_a_Triangle {
    public Area_and_Perimeter_of_a_Triangle() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Triangle t = new Triangle();
        t.a = sc.nextInt();
        t.b = sc.nextInt();
        t.c = sc.nextInt();
        System.out.println("Area is: " + t.getArea());
        System.out.println("Perimeter is: " + t.getParameter());
    }
}