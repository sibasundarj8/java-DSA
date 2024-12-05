package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/fizz-buzz/0
 *
 * # FizzBuzz
 *
 *   Q. Fizz Buzz Problem involves that given an integer n, for every integer 0 < i <= n, the task
 *      is to output,
 *      "FizzBuzz" if 'i' is divisible by 3 and 5,
 *      "Fizz" if 'i' is divisible by 3,
 *      "Buzz" if 'i' is divisible by 5
 *      "i" as a string, if none of the conditions are true.
 *    Ex.
 *      Input: n = 20
 *      Output: [“1”, “2”, “Fizz”, “4”, “Buzz”, “Fizz”, “7”, “8”, “Fizz”, “Buzz”, “11”, “Fizz”, “13”, 
 *               “14”, “FizzBuzz”, “16”, “17”, “Fizz”, “19”, “Buzz”]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class String_01_Fizz_Buzz {

    // main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size: ");
        int n = sc.nextInt();

        System.out.println(fizzBuzz(n));
    }

    // Solution
    static ArrayList<String> fizzBuzz(int n) {
        // potd.code.hub
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1;i <= n;i++){
            if (i%3 == 0 && i%5 == 0){
                ans.add("FizzBuzz");
            }
            else if (i%3 == 0){
                ans.add("Fizz");
            }
            else if (i%5 == 0){
                ans.add("Buzz");
            }
            else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}
