package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
 *
 * # Gas Station
 *
 *   Q. There are some gas stations along a circular route. You are given two integer arrays gas[] denoted
 *      as the amount of gas present at each station and cost[] denoted as the cost of travelling to the
 *      next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank
 *      from one of the gas stations. Return the index of the starting gas station if it's possible to travel
 *      around the circuit without running out of gas at any station in a clockwise direction. If there is no
 *      such starting station exists, return -1.
 *
 *      Note: If a solution exists, it is guaranteed to be unique.
 *    Ex.
 *      Input: gas[] = [1, 2, 3, 4, 5], cost[] = [3, 4, 5, 1, 2]
 *      Output: 3
 *      Explanation: It is possible to travel around the circuit from station at index 3. The Amount of gas at
 *                   station 3 is (0 + 4) = 4.
 *              Travel to station 4. Available gas = 4 – 1 + 5 = 8.
 *              Travel to station 0. Available gas = 8 – 2 + 1 = 7.
 *              Travel to station 1. Available gas= 7 – 3 + 2 = 6.
 *              Travel to station 2. Available gas = 6 – 4 + 3 = 5.
 *              Travel to station 3. The cost is 5. The gas is just enough to travel back to station 3.
 */
import java.util.Scanner;

public class GFG_136_Gas_Station {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gas station: ");
        String[]g = sc.nextLine().split(" ");

        System.out.println("Cost: ");
        String[]c = sc.nextLine().split(" ");

        int n = g.length;
        if (n != c.length) return;

        int[]gas = new int[n];
        int[]cost = new int[n];
        for (int i = 0;i < n;i++){
            gas[i] = Integer.parseInt(g[i]);
            cost[i] = Integer.parseInt(c[i]);
        }

        System.out.println(startStation(gas, cost));
    }

    /// Solution
    static int startStation(int[] gas, int[] cost) {
        // potd.code.hub
        int n = gas.length, totalG = 0, totalC = 0, station = 0, total = 0;
        for (int i = 0;i < n;i++){
            totalG += gas[i];
            totalC += cost[i];
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                station = i+1;
            }
        }

        return (totalG >= totalC) ? station : -1;
    }
}
