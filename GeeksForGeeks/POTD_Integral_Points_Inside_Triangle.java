package GFG;/*
 *    Q. Given three non-collinear points whose co-ordinates are p(p1, p2), q(q1, q2)
 *       and r(r1, r2) in the X-Y plane. Return the number of integral / lattice points
 *       strictly inside the triangle formed by these points.
 *
 *    Note: - A point in the X-Y plane is said to be an integral / lattice point
 *            if both its co-ordinates are integral.
 *     Ex-
 *          Input: p = (0,0),
 *                 q = (0,5),
 *                 r = (5,0)
 *         Output: 6
 *    Explanation:
 *           As shown in figure, points (1,1) (1,2) (1,3) (2,1) (2,2) and (3,1) are the
 *           integral points inside the triangle. So total 6 are there.
 */
import java.util.Scanner;

public class POTD_Integral_Points_Inside_Triangle
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Coordinates :\nPoint A :");
        long[]p = new long[2];
        p[0] = sc.nextLong();
        p[1] = sc.nextLong();

        System.out.println("Point B :");
        long[]q = new long[2];
        q[0] = sc.nextLong();
        q[1] = sc.nextLong();

        System.out.println("Point C :");
        long[]r = new long[2];
        r[0] = sc.nextLong();
        r[1] = sc.nextLong();

        System.out.println("Internal Points inside the Triangle formed :");
        System.out.println(InternalCount(p,q,r));
    }
    static long InternalCount(long[]p, long[]q, long[]r){

        // Area * 2
        long a2 = Math.abs(p[0]*(q[1]-r[1]) +
                q[0]*(r[1]-p[1]) +
                r[0]*(p[1]-q[1]));

        // Integral Boundary points
        long b = boundaryPoints(p[0],p[1],q[0],q[1]) +
                boundaryPoints(p[0],p[1],r[0],r[1]) +
                boundaryPoints(q[0],q[1],r[0],r[1]) + 3;

        // Interior Points -> (2A - B + 2) / 2
        return (a2-b+2)/2;
    }
    static long boundaryPoints(long x1,long y1,long x2,long y2){
        // Parallel to x-axis
        if (x1==x2){
            return Math.abs(y1-y2)-1;
        }
        // Parallel to y-axis
        else if (y1==y2){
            return Math.abs(x1-x2)-1;
        }
        else {
            long v1 = Math.abs(x1-x2);
            long v2 = Math.abs(y1-y2);
            return gcd(v1,v2) - 1;
        }
    }
    static long gcd(long a,long b){
        // Base case
        if(b == 0)return a;

        // Recursive Work
        return gcd(b,a%b);
    }
}