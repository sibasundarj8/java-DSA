package Math_;/*
 *
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 *
 * # 1344. Angle Between Hands of a Clock
 *
 *   Q. Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute
 *      hand.
 *
 *    Ex.           _.-="""=-._
 *               .'  11  12  1   `.
 *             / 10        /    2  \
 *            |           /         |
 *            | 9       12:30     3 |
 *            |           |         |
 *             \  8       |      4 /
 *               `.   7   6   5  .'
 *                  `-._____.- '
 *      Input : hour = 12, minutes = 30
 *      Output: 165.0
 *
 *  Constraints:
 *      1 <= hour <= 12
 *      0 <= minutes <= 59
 */

import java.util.Scanner;

public class Math_Angle_Between_Hands_of_a_Clock {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the time: hour minute");
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        System.out.println("Angle : " + angleClock(hour, minute) + "⁰");
    }

    /// Solution
    static double angleClock(int hour, int minutes) {
        // potd.code.hub
        double total_minutes = hour * 60 + minutes;

        double hour_hand_angle = total_minutes * 0.5D;
        double minute_hand_angle = minutes * 6D;
        double net_angle = Math.abs(hour_hand_angle - minute_hand_angle);

        return Math.min(net_angle, 360D - net_angle);
    }
}
