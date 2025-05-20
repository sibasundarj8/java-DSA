import java.util.Scanner;

public class Sum_of_the_Digits{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 3; ++i){
            int n = sc.nextInt();
            int a = n;

            int count;
            for(count = 0; n > 0; n /= 10){
                count += n % 10;
            }

            System.out.println("Sum of the Digits of " + a + " is : " + count);
        }
    }
}
