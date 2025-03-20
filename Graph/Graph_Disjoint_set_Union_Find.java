package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/disjoint-set-union-find/0
 *
 * # Disjoint set (Union-Find)
 *
 *   Q. Given an array par[] that stores all numbers from 1 to n (both inclusive and sorted) and k
 *      queries.
 *
 *      The task is to do the following operations on array elements :
 *
 *        1. UNION x z: Perform union of x and z i.e. parent of z will become the parent of x.
 *        2. FIND x: Find the ultimate parent of x and print it.
 *
 *      Note: Initially all are the parent of themselves.The ultimate parent is the topmost node
 *            such that par[node]=node.
 *   Ex.
 *      Input : n = 5
 *              k = 4
 *              queries[] = {{find 4},
 *                           {find 1},
 *                           {unionSet 3 1},
 *                           {find 3}}
 *      Output: 4 1 1
 *      Explanation:
 *            1. The parent of 4 is 4. Hence, the output is 4.
 *            2. The parent of 1 is 1. Hence, the output is 1.
 *            3. After performing unionSet 3 1, parent of 3 becomes 1, since parent of 1 is
 *               currently 1 itself.
 *            4. The parent of 3 is now 1. Hence, the output is 1.
 */
import java.util.Scanner;

public class Graph_Disjoint_set_Union_Find {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]par = new int[n+1];

        for (int i = 0;i <= n;i++)
            par[i] = i;

        System.out.println("Number of quires: ");
        n = sc.nextInt();

        System.out.println("""
                           Enter 'f' -> find
                                 'u' -> union
                           """);

        for (int i = 0;i < n;i++){
            char ch = sc.next().charAt(0);
            if (ch < 91) ch += 32;
            switch (ch){
                case 'f' -> {
                    System.out.println("Enter target: ");
                    System.out.println(find(par, sc.nextInt()));
                }
                case 'u' -> {
                    System.out.println("Enter 'x' and 'y': ");
                    unionSet(par, sc.nextInt(), sc.nextInt());
                }
                default -> System.out.println("Enter either 'f' or 'u'");
            }
        }
    }

    /// Solution
    static int find(int[] par, int x) {
        if (par[x] == x) return x;
        return par[x] = find(par, par[x]);
    }

    static void unionSet(int[] par, int x, int z) {
        if (par[x] == par[z]) return;
        int pz = find(par, z);
        int px = find(par, x);
        par[px] = pz;
    }
}
