import java.util.Scanner;

public class Prime_Sum_1_to_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int l = sc.nextInt();
        System.out.println("All Prime sum from 1 to n :");
        System.out.println(prime_Sum(l));
    }
    static long prime_Sum(int n)
    {
        // code here
        long ans = 0;
        for (int i = 3;i <= n;i+=2)
            if (isPrime(i))
                ans += i;
        if (n >= 2)ans += 2;
        return ans;
    }
    static boolean isPrime(int n){
        int N = (int)Math.sqrt(n);
        for (int i = 2;i <= N;i++)
            if (n%i == 0)
                return false;
        return true;
    }
}