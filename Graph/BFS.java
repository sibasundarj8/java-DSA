package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Breadth First Search
public class BFS {
    static class Edge{
        int s;
        int d;
        public Edge(int s, int d){
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) {
        //  potd.code.hub
        int v = 7;
        /*
                1---3
               /    |\
              0     | 5---6
               \    |/
                2---4
        */
        ArrayList<Edge>[]graph = new ArrayList[v];
        createGraph(graph);

        // Visited Array
        boolean[]visited = new boolean[v];

        for (int i = 0;i < v;i++)
            if (!visited[i]) bfs(graph,visited,i);

        // Output :  0 1 2 3 4 5 6
    }
    static void createGraph(ArrayList<Edge>[]graph){
        for (int i = 0;i < graph.length;i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    static void bfs(ArrayList<Edge>[]graph,boolean[]visited,int start){
        // Making a queue to store the neighbors
        Queue<Integer>q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()){
            int curr = q.remove();
            if (!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0;i < graph[curr].size();i++)
                    q.add(graph[curr].get(i).d);
            }
        }
    }
}