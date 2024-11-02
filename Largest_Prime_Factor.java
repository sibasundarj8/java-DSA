/*
 *   Q. WAP to find the Largest Prime Factor ?
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Largest_Prime_Factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Largest Prime factor is :");
        System.out.println(largestPrimeFactor(n));
    }
    static long largestPrimeFactor(int n) {
        // code here
        ArrayList<Integer> factors = new ArrayList<>();
        factors(n,factors);
        Collections.sort(factors);
        int i = factors.size()-1;
        while(i >= 0){
            if (isPrime(factors.get(i)))
                return factors.get(i);
            i--;
        }
        return -1;
    }
    static void factors(int n, ArrayList<Integer>arr){
        for (int i = 1;i*i <= n;i++){
            if (n%i == 0){
                arr.add(i);
                arr.add(n/i);
            }
        }
    }
    static boolean isPrime(int n){
        for(int i = 2;i*i <= n;i++)
            if(n%i == 0)return false;
        return true;
    }
}