package Contest.weekly_523;/*
 *
 * https://leetcode.com/contest/weekly-contest-523/problems/design-bus-seat-booking-system/
 *
 * # Q3. Design Bus Seat Booking System
 *
 *   Q. You are asked to design a seat booking system for a bus.
 *
 *      The bus has n rows. Each row has four seats labeled "A", "B", "C", and "D".
 *
 *      Seats "A" and "D" are window seats; seats "B" and "C" are middle seats. In each row, seat "A" is
 *      adjacent to seat "B", and seat "D" is adjacent to seat "C".
 *
 *      Booking rules:
 *        ◦ Booking a middle seat ("B" or "C") always takes 1 second.
 *        ◦ Booking a window seat ("A" or "D") takes 1 second if its adjacent middle seat is not booked,
 *          or 3 seconds (an extra delay of 2 seconds) if its adjacent middle seat is already booked.
 *
 *      A seat is identified by a string such as "A1" or "D20" (one letter from A to D followed by its
 *      row number).
 *
 *      Implement the BusBooking class:
 *        ◦ BusBooking(int n): Initializes the system with n empty rows.
 *
 *        ◦ void toggle(string seat): Books seat if it is free, or frees it if it is already booked.
 *
 *        ◦ int getTotalTime(): Returns the total time (in seconds) taken to book all currently booked seats,
 *          where the seats are booked in the order their toggle calls were made. If no seats are currently
 *          booked, return 0.
 *
 *        ◦ int getMinTime(): Returns the smallest possible total time (in seconds) to book all currently
 *          booked seats, over every possible order of booking them. If no seats are currently booked,
 *          return 0.
 *
 *      Note: The time cost of a seat is fixed at the moment it is booked, based on the seats booked at
 *            that time. Booking or freeing other seats afterward does not change the cost of a seat that
 *            is already booked.
 *
 *    Ex.
 *      Input : ["BusBooking", "toggle", "toggle", "getTotalTime", "toggle", "toggle", "toggle",
 *               "getTotalTime", "getMinTime"]
 *              [[10], ["C7"], ["D7"], [], ["D7"], ["C7"], ["D7"], [], []]
 *      Output: [null, null, null, 4, null, null, null, 1, 1]
 *      Explanation:
 *              BusBooking busBooking = new BusBooking(10); // start with 10 empty rows
 *
 *              busBooking.toggle("C7"); // book "C7", a middle seat, which costs 1 second. Total time is
 *              now 1.
 *
 *              busBooking.toggle("D7"); // book "D7", a window seat. Its adjacent middle "C7" is already
 *              booked, so it costs 3 seconds. Total time is now 1 + 3 = 4.
 *
 *              busBooking.getTotalTime(); // return 4, since in toggle order "C7" costs 1 and "D7" costs 3.
 *
 *              busBooking.toggle("D7"); // "D7" is already booked, so free it. This removes its cost of 3.
 *              Total time is now 4 - 3 = 1.
 *
 *              busBooking.toggle("C7"); // "C7" is already booked, so free it. This removes its cost of 1.
 *              Total time is now 1 - 1 = 0, and row 7 is empty.
 *
 *              busBooking.toggle("D7"); // book "D7" again, a window seat. Its adjacent middle "C7" is not
 *              booked this time, so it costs only 1 second. Total time is now 0 + 1 = 1.
 *
 *              busBooking.getTotalTime(); // return 1, since only "D7" is booked, and it cost 1 this time.
 *
 *              busBooking.getMinTime(); // return 1. With the best possible booking order, the 1 booked
 *              seat takes 1 * 1 = 1 second.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁵
 *        ◦ seat[0] is one of 'A', 'B', 'C', 'D'.
 *        ◦ The remaining characters of seat form an integer row with 1 <= row <= n.
 *        ◦ The total number of calls to toggle, getTotalTime, and getMinTime does not exceed 10⁵.
 */

public class Q3_Design_Bus_Seat_Booking_System {

    /// Solution
    static class BusBooking {
        private final int[][] BUS_SEATS;
        private int TOTAL_BOOKED_SEATS;
        private int TOTAL_TIME;

        public BusBooking(int n) {
            TOTAL_BOOKED_SEATS = 0;
            TOTAL_TIME = 0;
            BUS_SEATS = new int[n + 1][4];
        }

        public void toggle(String seat) {
            int seatNum = seat.charAt(0) - 'A';
            int row = Integer.parseInt(seat.substring(1));
            int[] seats = BUS_SEATS[row];

            if (seats[seatNum] != 0) {  // if already occupied
                TOTAL_BOOKED_SEATS--;
                TOTAL_TIME -= seats[seatNum];
                seats[seatNum] = 0;
            } else {                    // if the seat is vacant
                if (seatNum == 1 || seatNum == 2) {
                    seats[seatNum] = 1;
                    TOTAL_TIME++;
                }
                else if (seatNum == 0 && seats[1] != 0 || seatNum == 3 && seats[2] != 0) {
                    TOTAL_TIME += 3;
                    seats[seatNum] = 3;
                } else {
                    TOTAL_TIME++;
                    seats[seatNum] = 1;
                }

                TOTAL_BOOKED_SEATS++;
            }
        }

        public int getTotalTime() {
            return TOTAL_TIME;
        }

        public int getMinTime() {
            return TOTAL_BOOKED_SEATS;
        }
    }
}