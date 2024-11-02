import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(lcm(n, m));
    }
    public static int lcm(int m, int n) {
        int i;
        i = 1;
        while (i % n != 0 || i % m != 0) i++;

        return i;
    }
}