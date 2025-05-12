package Priority_Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/meeting-rooms-iii/1
 *
 * # Meeting Rooms III
 *
 *   Q. You are given an integer n representing the number of rooms numbered from 0 to n - 1. Additionally, you
 *      are given a 2D integer array meetings[][] where meetings[i] = [starti, endi] indicates that a meeting is
 *      scheduled during the half-closed time interval [starti, endi]. All starti values are unique.
 *
 *      Meeting Allocation Rules:
 *
 *     —‣ When a meeting starts, assign it to the available room with the smallest number.
 *     —‣ If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting
 *        retains its original duration.
 *     —‣ When a room becomes free, assign it to the delayed meeting with the earliest original start time.
 *     —‣ Determine the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.
 *
 *   Ex.
 *      Input : n = 2
 *              meetings[][] = [[0, 6],
 *                              [2, 3],
 *                              [3, 7],
 *                              [4, 8],
 *                              [6, 8]]
 *              Output: 1
 *              Explanation: Time 0: Both rooms available. [0,6] starts in room 0.
 *                           Time 2: Room 0 busy until 6. Room 1 available. [2,3] starts in room 1.
 *                           Time 3: Room 1 frees up. [3,7] starts in room 1.
 *                           Time 4: Both rooms busy. [4,8] is delayed.
 *                           Time 6: Room 0 frees up. Delayed [4,8] starts in room 0 [6,10).
 *                           Time 6: [6,8] arrives but both rooms busy. It’s delayed.
 *                           Time 7: Room 1 frees up. Delayed [6,8] starts in room 1 [7,9).
 *                           Meeting counts: [2, 3]
 */

import java.util.*;

public class PQ_Meeting_Rooms_III {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of rooms: ");
        int n = sc.nextByte();

        System.out.println("Number of meetings: ");
        int m = sc.nextByte();

        int[][] meetings = new int[m][2];

        System.out.println("Start_i  ---  End_i");
        for (int i = 0; i < m; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        System.out.println("Most booked room no. : " + mostBooked(n, meetings));
    }

    /// Solution
    private static class Room implements Comparable<Room> {
        int no;
        long end;

        Room(int no) {
            this.no = no;
            this.end = 0;
        }

        void update(long start, long duration) {
            this.end = start + duration;
        }

        @Override
        public int compareTo(Room other) {
            if (other.end != this.end) {
                return Long.compare(this.end, other.end);
            } else {
                return Integer.compare(this.no, other.no);
            }
        }
    }

    static int mostBooked(int n, int[][] meetings) {
        // potd.code.hub
        int ans = 0;
        int max = 0;
        int[] frequency = new int[n];

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Room> occupied = new PriorityQueue<>(n);
        PriorityQueue<Room> available = new PriorityQueue<>(n, Comparator.comparingInt(a -> a.no));

        for (int i = 0; i < n; i++) {
            available.offer(new Room(i));
        }

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long duration = meeting[1] - start;

            while (!occupied.isEmpty() && occupied.peek().end <= start) {
                Room room = occupied.poll();
                available.offer(room);
            }

            int roomNo;
            Room current;
            if (available.isEmpty()) {
                current = occupied.poll();
                start = (int) current.end;
            } else {
                current = available.poll();
            }

            current.update(start, duration);
            roomNo = current.no;
            occupied.offer(current);
            frequency[roomNo]++;

            if (frequency[roomNo] > max || (frequency[roomNo] == max && roomNo < ans)) {
                ans = roomNo;
                max = frequency[roomNo];
            }
        }

        return ans;
    }
}
