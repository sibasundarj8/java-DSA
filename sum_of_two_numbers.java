import java.util.Scanner;

public class sum_of_two_numbers{
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);

        System.out.println("enter a : ");
        int a = sc.nextInt();

        System.out.println("enter b : ");
        int b = sc.nextInt();

        int sum = a + b;

        System.out.println("a + b = " + sum);
    }
} 