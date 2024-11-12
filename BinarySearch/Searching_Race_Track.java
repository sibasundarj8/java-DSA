package Binary_Search;/*
 *   Q. A new racing track for kids is being built in New York with 'n' starting spots.
 *      The spots are located along a straight line at positions xl, x2... xn(xi For
 *      each 'i', xi+l > xi. At a time only 'm' children are allowed to enter the race.
 *      Since the race track is for kids, they may run into each other while running.
 *      To prevent this, we want to choose the starting spots such that the minimum distance
 *      between any two of them is as large as possible. What is the largest minimum distance?
 *
 *       ● The first line of input will contain the value of n, the number of starting spots.
 *       ● The second line of input will contain the n numbers denoting the location of each
 *         spot.
 *       ● The third line will contain the value of m, number of children.
 *
 *      Ex-
 *          Input :  n = 5
 *                   arr[] = {1, 2, 4, 8, 9}
 *                   kids = 3
 *          Output :
 *                   3
 */
import java.util.Scanner;

public class Searching_Race_Track {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of starting spots :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter position of spots :");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();
        System.out.println("Number of kids :");
        int k = sc.nextInt();
        System.out.println("Output : \n" + maximizeDistance(arr,k));
    }
    static int maximizeDistance(int[]arr,int kids){
        int n = arr.length;
        if (kids > n) return -1;
        int l = 0,r = (int)10e9;
        int ans = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if(isPossible(arr,kids,mid)){
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }
    static boolean isPossible(int[]arr,int kids,int min){
        int kidPlaced = 1;
        int lastKid = arr[0];
        for (int i = 1;i < arr.length;i++){
            if (arr[i]-lastKid >= min) {
                kidPlaced++;
                lastKid = arr[i];
            }
        }
        return kidPlaced >= kids;
    }
}