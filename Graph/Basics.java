package Graph;

import java.util.ArrayList;

public class Basics {
    static class Edge{
        int src;
        int dst;
        int weight;
        public Edge(int src,int dst,int weight){
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        // Store graph using Adjacency Graph

        int v = 4;   // Initialization of graph
        ArrayList<Edge>[]graph = new ArrayList[v];
        for (int i = 0;i < v;i++)
            graph[i] = new ArrayList<>();

        // Input
        graph[0].add(new Edge(0,2,10));
        graph[1].add(new Edge(1,2,20));
        graph[1].add(new Edge(1,3,15));
        graph[2].add(new Edge(2,1,12));
        graph[2].add(new Edge(2,3,15));
        graph[3].add(new Edge(3,1,20));
        graph[3].add(new Edge(3,2,5));

        // Output
        System.out.println("Nodes connected with 2 :");
        for (int i = 0;i < graph[2].size();i++)
            System.out.print(graph[2].get(i).dst + ", " + graph[2].get(i).weight + "\n");

    }
}