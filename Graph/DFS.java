package Graph;

import java.util.ArrayList;

public class DFS {
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

        boolean[]visited = new boolean[v];
        for (int i = 0;i < v;i++)
            if (!visited[i])
                dfs(graph,visited,0);
        // Output :  0 1 3 4 2 5 6
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
    static void dfs(ArrayList<Edge>[]graph,boolean[]vis,int start){
        System.out.print(start + " ");
        vis[start] = true;

        for (int i = 0;i < graph[start].size();i++){
            Edge e = graph[start].get(i);
            // Recursive Work
            if (!vis[e.d]) dfs(graph, vis, e.d);
        }
    }
}