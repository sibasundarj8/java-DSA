package GFG;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class POTD_Minimum_Cost_Path {
    static class Pair{
        int x,y,cost;
        Pair(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of n*n squire Matrix :");
        int n = sc.nextInt();
        int[][]arr = new int[n][n];
        System.out.println("Elements :");
        for (int i = 0;i< n;i++)
            for (int j = 0;j< n;j++)
                arr[i][j] = sc.nextInt();
        System.out.println("Output :");
        System.out.println(minimumCostPath(arr));
    }
    static int minimumCostPath(int[][] grid){
        // potd.code.hub
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        int[][]dist = new int[n][n];
        for (int i = 0;i < n;i++)
            for (int j = 0;j < n;j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = grid[0][0];
        pq.add(new Pair(0,0,grid[0][0]));
        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            for (int i = 0;i < 4;i++){
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if (isValid(newX,newY,n)){
                    if (curr.cost + grid[newX][newY] < dist[newX][newY]){
                        dist[newX][newY] = curr.cost + grid[newX][newY];
                        pq.add(new Pair(newX,newY,dist[newX][newY]));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
    static boolean isValid(int newX,int newY,int n){
        return newX<n && newY<n && newX>=0 && newY>=0;
    }
}
