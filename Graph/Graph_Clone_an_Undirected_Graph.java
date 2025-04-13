package Graph;/*
 *
 * https://www.geeksforgeeks.org/problems/clone-graph/1
 *
 * # Clone an Undirected Graph
 *
 *   Q. Your task is to complete the function cloneGraph( ) which takes a starting node of the
 *      graph as input and returns the copy of the given node as a reference to the cloned
 *      graph.
 *
 *      Note: If you return a correct copy of the given graph, then the driver code will print
 *            true; and if an incorrect copy is generated or when you return the original node,
 *            the driver code will print false.
 *   Ex.
 *      Input : n = 4
 *              adjList[][] = [[1, 2],
 *                             [0, 2],
 *                             [0, 1, 3],
 *                             [2]]
 *      Output: true
 *      Explanation:          <1>---<2>
 *                             |   / |
 *                             |  /  |
 *                             | /   |
 *                            <0>   <3>
 *              As the cloned graph is identical to the original one, the driver code will print
 *              true.
 */
import java.util.*;

public class Graph_Clone_an_Undirected_Graph {

    /// Structure
    static class Node{
        int val;
        ArrayList<Node> neighbors;

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    /// main Method
    public static void main(String[] args) {
        System.out.println("""
                adjList[][] = [[1, 2],
                               [0, 2],
                               [0, 1, 3],
                               [2]]
                """);
        System.out.println("""
                Graph Looks Like:
                                    <1>---<2>
                                     |   / |
                                     |  /  |
                                     | /   |
                                    <0>   <3>
                """);

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        ArrayList<Node> list0 = new ArrayList<>(List.of(node1, node2));
        ArrayList<Node> list1 = new ArrayList<>(List.of(node0, node2));
        ArrayList<Node> list2 = new ArrayList<>(List.of(node0, node1, node3));
        ArrayList<Node> list3 = new ArrayList<>(List.of(node2));

        node0.neighbors = list0;
        node1.neighbors = list1;
        node2.neighbors = list2;
        node3.neighbors = list3;

        System.out.print("Original Graph BFS:\t");
        List<Node> org = bfs(node0);
        org.forEach((a) -> System.out.print(a.val + " "));
        System.out.println();

        Node ans = cloneGraph(node0);

        System.out.print("Cloned Graph BFS:\t");
        List<Node> clone = bfs(ans);
        clone.forEach((a) -> System.out.print(a.val + " "));
        System.out.println();

        System.out.println(compare(org, clone));
    }

    /// BFS
    private static List<Node> bfs (Node node) {

        List<Node> ans = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.add(node);
        visited.add(node.val);

        while (!q.isEmpty()) {
            
            Node v = q.poll();
            ans.add(v);
            
            for (Node n : v.neighbors) {
                if (!visited.contains(n.val)) {
                    visited.add(n.val);
                    q.add(n);
                }
            }
        }

        return ans;
    }
    
    // Comparing if Original and Clone is the same graph
    private static boolean compare(List<Node> list1, List<Node> list2) {
        int n = list1.size();
        if (n != list2.size()) return false;
        for (int i = 0;i < n;i++) {
            if (list1.get(i) == list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    /// Solution
    static Node cloneGraph(Node node) {
        // potd.code.hub
        Queue<Node> q = new LinkedList<>();
        Queue<Node> ansQ = new LinkedList<>();
        HashMap<Integer, Node> visited = new HashMap<>();

        q.add(node);
        Node ans = new Node(node.val);
        visited.put(node.val, ans);
        ansQ.add(ans);

        while (!q.isEmpty()) {
            
            Node v = q.poll();
            Node temp = ansQ.poll();
            ArrayList<Node> adj = new ArrayList<>();
            
            for (Node n : v.neighbors) {
                if (!visited.containsKey(n.val)) {
                    q.add(n);
                    Node cn = new Node(n.val);
                    ansQ.add(cn);
                    adj.add(cn);
                    visited.put(n.val, cn);
                }
                else {
                    adj.add(visited.get(n.val));
                }
            }
            if (temp != null) {
                temp.neighbors = adj;
            }
        }

        return ans;
    }
}
