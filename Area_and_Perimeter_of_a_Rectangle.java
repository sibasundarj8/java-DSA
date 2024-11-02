import java.util.Scanner;

class Area {
    int a;
    int b;

    public Area(int l, int m) {
        this.a = l;
        this.b = m;
    }

    public int getArea() {
        return this.a * this.b;
    }

    public int getPerimeter() {
        return 2 * (this.a + this.b);
    }
}
public class Area_and_Perimeter_of_a_Rectangle {
    public Area_and_Perimeter_of_a_Rectangle() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length: ");
        int l = sc.nextInt();
        System.out.println("Enter Breadth: ");
        int m = sc.nextInt();
        Area a = new Area(l, m);
        System.out.println("Area is: " + a.getArea());
        System.out.println("Perimeter is: " + a.getPerimeter());
    }
}