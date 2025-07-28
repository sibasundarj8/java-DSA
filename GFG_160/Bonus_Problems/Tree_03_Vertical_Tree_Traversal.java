package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 *
 * # Vertical Tree Traversal
 *
 *   Q. Given a root of a Binary Tree, find the vertical traversal of it starting from the leftmost level to
 *      the rightmost level.
 *
 *      If there are multiple nodes passing through a vertical line, then they should be printed as they appear
 *      in level order traversal of the tree.
 *   Ex.
 *      Input : root[] = [1, 2, 3, 4, 5, N, 6]
 *                                                 [1]
 *                                                /   \
 *                                             [2]    [3]
 *                                            /  \      \
 *                                         [4]   [5]    [6]
 *      Output: [[4],
 *              [2],
 *              [1, 5],
 *              [3],
 *              [6]]
 *      Explanation: From left to right the vertical order will be [[4], [2], [1, 5], [3], [6]]
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Tree_03_Vertical_Tree_Traversal {

    /// Structure
    private static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
        }
    }

    /// main Method
    public static void main(String[] args) {
        Node[] nodes = {
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(6),
        };

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].right = nodes[5];

        ArrayList<ArrayList<Integer>> ans = verticalOrder(nodes[0]);

        System.out.println("Vertical order traversal: ");
        for (ArrayList<Integer> x : ans) {
            System.out.println(x);
        }
    }

    ///  Solution
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }

    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // potd.code.hub
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair<Integer, Node>> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        queue.offer(new Pair<>(0, root));

        while (!queue.isEmpty()) {
            Pair<Integer, Node> pair = queue.poll();
            int vertex = pair.getKey();
            Node curr = pair.getValue();

            if (!map.containsKey(vertex)) map.put(vertex, new ArrayList<>());
            map.get(vertex).add(curr.data);

            if (curr.left != null) queue.offer(new Pair<>(vertex - 1, curr.left));
            if (curr.right != null) queue.offer(new Pair<>(vertex + 1, curr.right));
        }

        for (int x : map.keySet()) {
            ans.add(map.get(x));
        }

        return ans;
    }
}
