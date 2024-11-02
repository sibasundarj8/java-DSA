import java.util.Scanner;

public class Swap_without_Temporary_Variable
{
    static void swap(int a, int b)
    {
        a += b;
        b = a - b;
        a -= b;
        System.out.println("Values after Swap");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Value Before Swap :");
        System.out.print("a : ");
        int a = sc.nextInt();

        System.out.print("b : ");
        int b = sc.nextInt();

        swap(a, b);
    }
}