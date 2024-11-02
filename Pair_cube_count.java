/*
 *    Q. Given N, count all ‘a’(>=1) and ‘b’(>=0) that satisfy the condition a3 + b3 = N.
 *
 *      Input:N = 9
 *      Output: 2
 *      Explanation:
 *         There are two solutions: (a=1, b=2) and (a=2, b=1).
 */
import java.util.Scanner;

public class Pair_cube_count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n = sc.nextInt();
        System.out.println(pairCubeCount(n));
    }
    static int pairCubeCount(int n) {
        // code here
        int count = 0;
        for (int i = 1;i*i*i <= n;i++)
            for (int j = 0;j*j*j < n;j++)
                if (i*i*i + j*j*j == n){
                    count++;
                    System.out.println(i +","+ j);
                    break;
                }
        return count;
    }
}
