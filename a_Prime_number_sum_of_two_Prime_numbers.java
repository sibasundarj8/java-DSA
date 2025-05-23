import java.util.Scanner;

public class a_Prime_number_sum_of_two_Prime_numbers {

    /// Solution
    public static boolean is_Prime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for(int i = 2; i * i <= n; ++i) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int n = sc.nextInt();

        if (is_Prime(n) && is_Prime(n - 2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
